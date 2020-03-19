package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

/**
 * 在有序但含有空的数组中查找字符串
 */
public class _05FindTheFirstStringInOrderedArr {
    public static void main(String[] args) {
        _05FindTheFirstStringInOrderedArr findTheFirstStringInOrderedArr = new _05FindTheFirstStringInOrderedArr();
        String[] strs = new String[]{null, "a", null, "a", null, "b", null, "c", "c", null};
        String str = "a";
        int res = findTheFirstStringInOrderedArr.getFirstIndex(strs, str);
        System.out.println(res);
    }

    private int getFirstIndex(String[] strs, String str) {
        if (strs == null || strs.length == 0 || str == null) {
            return -1;
        }

        int res = -1;
        int start = 0;
        int end = strs.length - 1;
        int mid = 0;
        int i = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (str.equals(strs[mid])) {// 如果位true  必然有strs[mid] != null &&
                res = mid;
                end = mid - 1;
            } else if (strs[mid] != null) {
                if (strs[mid].compareTo(str) < 0) {
                    start = mid + 1;
                } else {//strs[mid].compareTo(str) > 0
                    end = mid - 1;
                }
            } else { // strs[mid] == null
                i = mid;
                while (strs[i] == null && --i >= start) {
                }
                //跳出while的三种可能

                //1  整个左半区都为null(上述遍历到尽头)
                //2  遇到一个strs[i] != null 且str[i] < str
                if (i < start || strs[i].compareTo(str) < 0) {
                    //去右半区找
                    start = mid + 1;
                }
                //3  遇到一个strs[i] != null 且 str[i] >= str
                else {
                    res = strs[i].equals(str) ? i : res;
                    end = i - 1;
                }
            }
        }

        return res;
    }
}
