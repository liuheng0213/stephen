package basic.knowledge.stephen.algorithm_4_Edition.ch3._05application;

import basic.knowledge.stephen.algorithm_4_Edition.ch3._04Symbol_table_hash.SeparateChainingHashST;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Iterator;

public class SparseVector {
    public SparseVector() {
    }

    private SeparateChainingHashST<Integer, Double> st;

    public int size() {
        return st.size();
    }

    public void put(int i, double x) {
        if (!new BigDecimal(x).setScale(1,BigDecimal.ROUND_DOWN).equals(new BigDecimal(0.0))) {
            st.put(i, x);
        }
    }

    public double get(int i) {
        if (!st.contains(i)) {
            return 0.0;
        }
        return st.get(i);
    }

    public double dot(double[] that) {
        double sum = 0.0;
        for (int i : st.keys()) {
            sum += that[i] * st.get(i);
        }
        return sum;
    }

    public SparseVector sum(SparseVector that) {
        SparseVector newSV = new SparseVector();

        //给输入的sparseVector去重
        //that.delete();

        for (int i = 0; i < Math.min(this.size(), that.size()); i++) {
            if (!new BigDecimal(this.get(i) + that.get(i)).setScale(1, BigDecimal.ROUND_DOWN).equals(new BigDecimal(0.0))) {
                newSV.put(i, this.get(i) + that.get(i));
            }
        }
        return newSV;
    }


    public void delete() {
        SeparateChainingHashST<Integer, Double> st = this.st;
        Iterable<Integer> keys = st.keys();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            Integer currKey = iterator.next();
            BigDecimal bigDecimal = new BigDecimal(st.get(currKey));
            if (bigDecimal.setScale(1, BigDecimal.ROUND_DOWN).equals(new BigDecimal(0.0))) {
                st.delete(currKey);
            }
        }


    }

}
