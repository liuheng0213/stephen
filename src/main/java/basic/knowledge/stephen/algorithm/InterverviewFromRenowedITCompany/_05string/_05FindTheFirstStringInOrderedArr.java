package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

/**
 * 在有序但含有空的数组中查找字符串
 */
public class _05FindTheFirstStringInOrderedArr {
    public static void main(String[] args) {
        _05FindTheFirstStringInOrderedArr findTheFirstStringInOrderedArr = new _05FindTheFirstStringInOrderedArr();
        String[] strs = new String[]{null, "a", null, "a", null, "b", null, "c", "c", null};
        String str = "c";
        int res = findTheFirstStringInOrderedArr.getFirstIndex(strs, str);
        System.out.println(res);
    }

    private int getFirstIndex(String[] strs, String str) {
        int left = 0;
        int right = strs.length - 1;
        int mid = 0;
        int res = -1;
        int i = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (strs[mid] != null && strs[mid].equals(str)) {
                right = mid - 1;
                res = mid;
            } else if (strs[mid] != null && !strs[mid].equals(str)) {
                if (strs[mid].compareTo(str) < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else { // ==null
                i = mid;
                while (--i >= left && strs[i] == null) {
                }
                // i < left or strs[i] != null
                if (i < left) {
                    left = mid + 1;
                } else {
                    if (strs[i].compareTo(str) < 0) {
                        left = mid + 1;
                    } else {
                        res = strs[i].compareTo(str) == 0 ? i : res;
                        right = i - 1;
                    }
                }
            }
        }
        return res;
    }
}
