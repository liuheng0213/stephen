package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


//数组中两个最小字符串的距离:  贪心算法
public class _09minDistance {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "3", "3", "3", "2", "3", "1","0"};
        String str1 = "0";
        String str2 = "2";
        _09minDistance minDistance = new _09minDistance();
        int res = minDistance.minDis(strs, str1, str2);
        System.out.println(res);
    }

    private int minDis(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (str1.equals(strs[i])) {
                min = Math.min(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }

            if (str2.equals(strs[i])) {
                min = Math.min(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }
}
