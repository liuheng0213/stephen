package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

//累加出整个范围所有的数最少还需几个数
//前提: 有序正整数
public class _10NeedsNums {
    public static void main(String[] args) {
        _10NeedsNums needsNums = new _10NeedsNums();
        int[] arr = new int[]{3, 17, 21, 78};
        int res = needsNums.getNeedsNums(arr, 67);
        System.out.println(res);

    }

    private int getNeedsNums(int[] arr, int range) {
        if (arr == null || arr.length == 0 || range < 1) {
            return 0;
        }
        int needsNum = 0;
        int maxLimit = 0;
        for (int i = 0; i < arr.length; i++) {
            while (arr[i] > maxLimit + 1) {
                maxLimit = 2 * maxLimit + 1;
                needsNum++;
                //while 里判断一次
                if (maxLimit >= range) {
                    return needsNum;
                }
            }
            //下面这个不要忘啊
            maxLimit += arr[i];
            //再判断一次
            if (maxLimit >= range) {
                return needsNum;
            }
        }
        //如果遍历完了 还是没有到range
        while (range > maxLimit) {
            maxLimit = 2 * maxLimit + 1;
            needsNum++;
        }
        return needsNum;

    }
}
