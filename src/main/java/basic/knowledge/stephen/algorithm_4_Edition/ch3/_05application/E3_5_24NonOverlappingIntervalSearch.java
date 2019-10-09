package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdIn;


/**
 1643
 2033
 5532
 7643
 8999
 10332
 5666653
 5669321
 */
public class E3_5_24NonOverlappingIntervalSearch {
    public static void main(String[] args) {
        ST<Integer, SET<Integer>> st = new ST<>();
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            st.put(p,new SET<>());
            for(int i = p;i<=q;i++){
                st.get(p).add(i);
            }
        }

        boolean flag = checkIfInST(8122, st);
        System.out.println(flag);
    }

    private static boolean checkIfInST(int num, ST<Integer, SET<Integer>> st) {
        Integer key = st.floor(num);
        if(st.get(key) == null){
            return false;
        }
        return st.get(key).contains(num);
    }


}
