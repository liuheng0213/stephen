package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

//数组中子数组的最大累乘积
public class _15AccumulativeProduct {
    public static void main(String[] args) {
        _15AccumulativeProduct accumulativeProduct = new _15AccumulativeProduct();
        double[] arr = new double[]{2.5, 4, 0, 3, 0.5, 8, -1};
        double res = accumulativeProduct.maxProduct(arr);
        System.out.println(res);
    }

    private double maxProduct(double[] arr) {
        double curMax = Integer.MIN_VALUE;
        double curMin = Integer.MAX_VALUE;
        double lastMax = arr[0];
        double lastMin = arr[0];
        double res = 0;
        for (int i = 1; i < arr.length; i++) {
            curMax = Math.max(Math.max(lastMax * arr[i], lastMin * arr[i]), arr[i]);
            curMin = Math.min(Math.min(lastMax * arr[i], lastMin * arr[i]), arr[i]);
            lastMax = curMax;
            lastMin = curMin;
            res = Math.max(res, curMax);
        }
        return res;
    }
}
