package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class Leetcode44 {
    public static void main(String[] args) {
        Leetcode44 leetcode44 = new Leetcode44();
        boolean match = leetcode44.isMatch("abcdcecbcehb", "*cehb");
        boolean match1 = leetcode44.isMatch_dp("abcdcecbcehb", "*cehb");
        System.out.println(match == match1);

    }

    /**
     * f[i][j] s 的第i - 1  p 的 第j -1是匹配的  为什么不0..i 0..j 因为"" 也要考虑
     * @param s
     * @param p
     * @return
     */
    private boolean isMatch_dp(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] f = new boolean[m + 1][n + 1];

        f[0][0] = true;
        for(int i = 1; i <= n; i++){
            f[0][i] = f[0][i - 1] && p.charAt(i - 1) == '*';
        }

        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
                    f[i][j] = f[i - 1][j - 1];
                }

                //else else 可有可无  本来两个if 都是互斥的
                if(p.charAt(j - 1) == '*'){
                    f[i][j] = f[i][j - 1] || f[i - 1][j];
                }
            }
        }
        return f[m][n];
    }

    /**
     * 以下设计很精巧  上例 多个c  匹配到哪个c  是个难点
     * 一旦往后走 发现* 号后不匹配, 则p 又回到* 后的下一个字母重新匹配新号,
     * 如果* 号都匹配 就继续i ++ ;j ++
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int sn = s.length();
        int pn = p.length();
        int i = 0;
        int j = 0;
        int start = -1;//记录* 号的位置
        int match = 0;
        while (i < sn) {
            if (j < pn && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < pn && p.charAt(j) == '*') {// 定位* 且保证 在* 的下一位
                start = j;
                match = i;
                j++;
            } else if (start != -1) {
                j = start + 1;//j 有可能先往前走 再回来到* 的下一位
                match++;
                i = match;
            } else {
                return false;
            }
        }
        while (j < pn) {
            if (p.charAt(j) != '*') return false;
            j++;
        }
        return true;

    }

}
