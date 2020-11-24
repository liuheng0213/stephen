package basic.knowledge.stephen.algorithm.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class NqueensSolution {
    public List<List<String>> solveNQueens(int n) {
        if(n< 1){
            return null;
        }
        List<List<String>> res= new  ArrayList<>();
        int[] records = new int[n];
        process(res,records,0);
        return res;
    }

    public void process(List<List<String>> res,int[] records,int row){
        if(row == records.length){
            //todo
            List<String> subList = new ArrayList<>();
            for(int i = 0;i< records.length;i++){
                String str = "";
                for(int j = 0;j < records.length;j++){
                    if(records[i] == j){
                        str+="Q";
                    }else{
                        str+=".";
                    }
                }
                subList.add(str);
            }
            res.add(subList);
            return;
        }


        for(int k =0 ;k<records.length;k++){
            if(qualify(records,k,row)){
                records[row] = k;
                process(res,records,row+ 1);
            }
        }
    }

    public boolean qualify(int[] records,int k,int row){
        for(int i = 0;i <= row- 1;i++){
            if(records[i] == k || Math.abs(i - row) == Math.abs(records[i] - k)){
                return false;
            }
        }
        return true;
    }
}

