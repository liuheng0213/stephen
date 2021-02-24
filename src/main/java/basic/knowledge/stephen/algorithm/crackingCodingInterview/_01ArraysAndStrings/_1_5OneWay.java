package basic.knowledge.stephen.algorithm.crackingCodingInterview._01ArraysAndStrings;

public class _1_5OneWay {

    public static void main(String[] args) {
        _1_5OneWay oneWay = new _1_5OneWay();
        boolean oneEditAway = oneWay.isOneEditAway("pales", "pale");
        System.out.println(oneEditAway);
    }


    public boolean isOneEditAway(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();

        //dp[i][j] 表示 chars1(0-->i - 1) 可以按照one edit away转成 chars2(0-->j - 1)
        boolean[][] dp = new boolean[chars1.length + 1][chars2.length + 1];
        boolean[][] dpIsEqual = new boolean[chars1.length + 1][chars2.length + 1];

        dp[0][1] = true;
        dp[1][0] = true;


        dpIsEqual[0][0] = true;


        for(int i = 1; i<= Math.min(chars1.length, chars2.length);i++){
            if (chars1[i - 1] == chars2[i - 1]) {
                dpIsEqual[i][i] = dpIsEqual[i - 1][i - 1];
            }
        }

        //1 dp[i - 1][j - 1] == true 且chars1[i - 1] == chars2[j - 1]  则dp[i][j] = true
        //2 dp[i - 1][j] == true 且 i = chars1.length or dp[i][j - 1] == true 且 i = chars2.length
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (dp[i - 1][j - 1] && chars1[i - 1] == chars2[j - 1]
                        || dpIsEqual[i - 1][j - 1] && chars1[i - 1] != chars2[j - 1]
                        || dpIsEqual[i - 1][j]
                        || dpIsEqual[i][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }


        return dp[chars1.length][chars2.length];

    }
}
