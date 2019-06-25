package basic.knowledge.stephen.algorithm_4_Edition.util;

import basic.knowledge.stephen.algorithm_4_Edition.ch1.unionfind.UnionFind;

public class UnionFindUtil {
    public static void checkUnion(UnionFind uf){
        while(true){
            int indexP = (int)(Math.random()*uf.ids.length);
            int indexQ = (int)(Math.random()*uf.ids.length);

            int p = uf.ids[indexP];
            int q = uf.ids[indexQ];

            if(!uf.connected(p, q)){
                System.out.println("not connected completely");
                return;
            }

            System.out.println("keep print...p...q");
        }
    }
}
