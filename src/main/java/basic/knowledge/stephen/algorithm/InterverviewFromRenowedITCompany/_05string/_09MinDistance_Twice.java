package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

public class _09MinDistance_Twice {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "3", "3", "3", "2", "3", "1", "0"};
        String str1 = "0";
        String str2 = "2";
        _09MinDistance_Twice minDistance = new _09MinDistance_Twice();
        int res = minDistance.minDis(strs, str1, str2);
        System.out.println(res);
    }

    public int minDis(String[] strs, String str1, String str2) {
        if (str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;
        int last2 = -1;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < strs.length; i++) {
            if (str1.equals(strs[i])) {
                last1 = i;
                min = Math.min(min, last2 == -1 ? min : Math.abs(last1 - last2));
            }

            if (str2.equals(strs[i])) {
                last2 = i;
                min = Math.min(min, last1 == -1 ? min : Math.abs(last1 - last2));
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
