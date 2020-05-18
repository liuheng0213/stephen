package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.HashMap;
import java.util.Map;

public class Leetcode860 {
    /**
     * 用了hash 很慢 最快得方法直接用tenCounts  fivecounts 计数
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                if (map.containsKey(5)) {
                    map.put(5, map.getOrDefault(5,0) + 1);
                }else {
                    map.put(5, 1);
                }
            }else if(bills[i] == 10){
                if (map.containsKey(10)) {
                    map.put(10, map.getOrDefault(10,0) + 1);
                } else {
                    map.put(10, 1);
                }
                if(map.getOrDefault(5,0) > 0){
                    map.put(5, map.getOrDefault(5,0) - 1);
                } else{
                    return false;
                }
            } else{
                if(map.getOrDefault(10,0)>0 && map.getOrDefault(5,0)>0){
                    map.put(10, map.getOrDefault(10,0) - 1);
                    map.put(5, map.getOrDefault(5,0) - 1);
                }else if(map.getOrDefault(5,0)>=3){
                    map.put(5, map.getOrDefault(5,0) - 3);
                }else{
                    return false;
                }
            }
        }

        return true;



    }
}
