package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;


//数组中两个最小字符串的距离:  贪心算法
public class _11MinDistance {
    public static void main(String[] args) {
        String[] strs = new String[]{"1", "3", "3", "3", "2", "3", "1", "0"};
        String str1 = "0";
        String str2 = "2";
        _11MinDistance minDistance = new _11MinDistance();
        int res = minDistance.minDis(strs, str1, str2);
        System.out.println(res);
    }

    private int minDis(String[] strs, String str1, String str2) {
        if (strs == null || str1 == null || str2 == null) {
            return -1;
        }
        if (str1.equals(str2)) {
            return 0;
        }
        int last1 = -1;//str1 上次出现的索引
        int last2 = -1;//str2 上次出现的索引
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            if (strs[i].equals(str1)) {
                min = Math.max(min, last2 == -1 ? min : i - last2);
                last1 = i;
            }
            if (strs[i].equals(str2)) {
                min = Math.max(min, last1 == -1 ? min : i - last1);
                last2 = i;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
