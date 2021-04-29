package basic.knowledge.stephen.algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Leetcode1239 {
    public static void main(String[] args) {
        ArrayList<String> objects = new ArrayList<>();
        objects.add("cha");
        objects.add("r");
        objects.add("act");
        objects.add("ers");
        Leetcode1239 leetcode1239 = new Leetcode1239();
        int i = leetcode1239.maxLength(objects);
        System.out.println();
    }
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();

        int max = dfs(arr,0,new StringBuilder(),list);
        return max;

    }


    public int dfs(List<String> arr,int index,StringBuilder sb,List<Integer> list){
        if(index == arr.size()){
            return 0;
        }

        int max = 0;
        for(int i = index;i < arr.size();i++){

            String strInArr = arr.get(i);
            if(unique(sb,strInArr)){

                list.add(sb.length());
                sb.append(strInArr);
                max = Math.max(max,sb.length());
                max = Math.max(dfs(arr,i + 1,sb,list),max);
                int startIndex = list.remove(list.size() - 1);
                sb.delete(startIndex,sb.length());
            }


        }

        return max;
    }

    private boolean unique(StringBuilder sb,String str2){
        StringBuilder newsb = new StringBuilder().append(sb).append(str2);

        HashSet<Character> set = new HashSet<>();
        for(int i =0;i< newsb.length();i++){
            if(!set.add(newsb.charAt(i))){
                return false;
            }
        }
        return true;

    }
}
