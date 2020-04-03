package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._08arrAndMatrix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//在数组中找到出现次数大于N/K的数  贪心
public class _03TimesMoreThanN_K {
    public static void main(String[] args) {
        _03TimesMoreThanN_K timesMoreThanN_k = new _03TimesMoreThanN_K();
        int[] arr = new int[]{1, 3, 5, 3, 4, 3, 3, 8, 3, 3};
        //timesMoreThanN_k.getIfKequals2(arr);
        timesMoreThanN_k.getN_K(arr, 3);
    }

    private void getN_K(int[] arr, int k) {
        HashMap<Integer, Integer> candMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (candMap.containsKey(arr[i])) {
                candMap.put(arr[i], candMap.get(arr[i]) + 1);
            } else {
                if (candMap.size() == k - 1) {
                    allMinusOneInCandMap(candMap);
                } else {
                    candMap.put(arr[i], 1);
                }
            }
        }

        Map<Integer, Integer> realMap = getReal(arr, candMap);
        System.out.println("===");
    }

    /**
     * 一定要有这个  candMap 只是抵消后的有优势的key value 而不是真实key value
     *
     * @param arr
     * @param candMap
     * @return
     */
    private Map<Integer, Integer> getReal(int[] arr, HashMap<Integer, Integer> candMap) {
        Map<Integer, Integer> realMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (candMap.containsKey(arr[i])) {
                if (realMap.containsKey(arr[i])) {
                    realMap.put(arr[i], realMap.get(arr[i]) + 1);
                } else {
                    realMap.put(arr[i], 1);
                }
            }

        }
        return realMap;
    }

    private void allMinusOneInCandMap(HashMap<Integer, Integer> candMap) {
        //List<Integer> removeList = new ArrayList<>();
        Set<Map.Entry<Integer, Integer>> entries = candMap.entrySet();
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> cur = iterator.next();
            Integer key = cur.getKey();
            Integer value = cur.getValue();
            if (value > 1) {
                candMap.put(key, value - 1);
                if (value == 1) {
                    iterator.remove();
                }
            }
        }
     /*   for(Integer removeKey : removeList){
            candMap.remove(removeKey);
        }*/
    }

    private void getIfKequals2(int[] arr) {
        //记录占优势的数的个数,所谓占优势就是当前最有可能次数大于一半的数, K = 2时
        // 这个数只有可能是K - 1 = 1个,所以一个变量times记录足矣
        int times = 0;
        int dominativeNum = 0;
        for (int i = 0; i < arr.length; i++) {
            //优势耗尽,重新指定优势数
            if (times == 0) {
                dominativeNum = arr[i];
                times = 1;
            } else if (arr[i] == dominativeNum) {
                times++;
            } else {
                times--;
            }
        }

        times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == dominativeNum) {
                times++;
            }
        }


        if (times > arr.length / 2) {
            System.out.println("this num is " + dominativeNum);
        } else {
            System.out.println("No such num");
        }
    }
}
