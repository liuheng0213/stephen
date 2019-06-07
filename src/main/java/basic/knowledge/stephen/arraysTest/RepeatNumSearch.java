package basic.knowledge.stephen.arraysTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class RepeatNumSearch {
    public static void main(String[] args) {

        int[] nums = {1,4,1,4,2,6,8,9,8,4,7,0,7,1,5,2,5,6,8,9,9,2,3,5,3,6,6,5,5,5};
        //找到上述数组的有重复的数字且拿到重复的次数
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            if (map.containsKey(num)) {
                Integer integer = map.get(num);
                map.put(num, integer+1);
            }else{
                map.put(num, 1);
            }
        }

        //entrySet遍历  获得键值对的set集合
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //获得set的迭代器
        Iterator<Map.Entry<Integer, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer, Integer> currentPoint = iterator.next();
            System.out.println("数字"+currentPoint.getKey()+":出现了"+currentPoint.getValue()+"次");
        }

    }
}
