package basic.knowledge.stephen.algorithm.leetcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class Leetcode352 {


    public static void main(String[] args) {
        Leetcode352 leetcode352 = new Leetcode352();
        leetcode352.addNum(1);
        leetcode352.getIntervals();
        leetcode352.addNum(3);
        leetcode352.getIntervals();
        leetcode352.addNum(7);
        leetcode352.addNum(2);
        leetcode352.getIntervals();
        System.out.println();
    }

    TreeMap<Integer,int[]> treeMap = null;


    /** Initialize your data structure here. */
    public Leetcode352() {
        this.treeMap = new TreeMap<>();
    }

    public void addNum(int val) {
        if(this.treeMap.containsKey(val)){
            return;
        }

        Integer lowerKey = treeMap.lowerKey(val);
        Integer higherKey = treeMap.higherKey(val);

        if(lowerKey != null && higherKey != null && treeMap.get(lowerKey)[1] + 1 == val && higherKey == val+ 1){
            int[] tmp = treeMap.get(lowerKey);
            tmp[1] = treeMap.get(higherKey)[1];
            treeMap.put(lowerKey,tmp);
            treeMap.remove(higherKey);
        }else if(lowerKey != null && val <= treeMap.get(lowerKey)[1] + 1){
            treeMap.get(lowerKey)[1] = Math.max(val,treeMap.get(lowerKey)[1]);
        }else if(higherKey != null && val >= higherKey - 1){
            int[] tmp = treeMap.get(higherKey);
            tmp[0] = Math.min(higherKey,val);
            treeMap.remove(higherKey);
            treeMap.put(tmp[0],tmp);

        }else{
            int[] temp = new int[2];
            temp[0] = val;
            temp[1] = val;
            treeMap.put(val,temp);
        }
    }

    public int[][] getIntervals() {
        Collection<int[]> values = this.treeMap.values();
        int[][] res = new int[values.size()][2];

        int index = 0;
        for(int[] arr  : values){
            res[index++] = arr;
        }
        return res;
    }

}
