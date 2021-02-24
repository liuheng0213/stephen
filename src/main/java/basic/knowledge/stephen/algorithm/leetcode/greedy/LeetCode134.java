package basic.knowledge.stephen.algorithm.leetcode.greedy;

public class LeetCode134 {
    public static void main(String[] args) {
        LeetCode134 obj = new LeetCode134();
        int[] gas = new int[]{1,2,3,4,5};
        int[] cost = new int[]{3,4,5,1,2};
        int res = obj.canCompleteCircuit(gas, cost);
        System.out.println(res);
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int cur = 0;
        int len = gas.length;
        int start = 0;
        for(int i =0 ;i< len;i++){
            cur += gas[i] - cost[i];
            total += gas[i] - cost[i];

            if(cur < 0){
                start = i + 1;
                cur = 0;
            }
        }
        return total >=0 ? start : -1;
    }
}
