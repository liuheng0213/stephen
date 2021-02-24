package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._08arrAndMatrix;

//数组中子数组的最大累乘积
public class _15AccumulativeProduct {
    public static void main(String[] args) {
        _15AccumulativeProduct accumulativeProduct = new _15AccumulativeProduct();
        double[] arr = new double[]{2.5, 4, 0, 3, 0.5, 8, -1};
        double res = accumulativeProduct.maxProduct(arr);
        System.out.println(res);
    }

    private double maxProduct(double[] arr) {
        if (arr == null || arr.length == 0) {
            return 0.0;
        }
        double possibleMax = 0;
        double possibleMin = 0;
        double res = arr[0];
        double actualMax = arr[0];
        double actualMin = arr[0];
        for (int i = 1; i < arr.length; i++) {
            possibleMax = actualMax * arr[i];
            possibleMin = actualMin * arr[i];
            actualMax = Math.max(Math.max(possibleMax, possibleMin), arr[i]);
            actualMin = Math.min(Math.min(possibleMax, possibleMin), arr[i]);
            res = Math.max(res,actualMax);
        }
        return res;
    }
}
