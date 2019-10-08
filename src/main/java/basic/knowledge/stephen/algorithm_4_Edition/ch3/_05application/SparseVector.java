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
        st.put(i, x);
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

    /**
     * e3.5.16
     * @param that
     * @return
     */
    public SparseVector sum(SparseVector that) {
        if(this.st.size() != that.st.size()){
            return null;
        }
        SparseVector newSV = new SparseVector();
        for (int i = 0; i < this.st.size(); i++) {
            if (!new BigDecimal(this.get(i) + that.get(i)).setScale(1, BigDecimal.ROUND_DOWN).equals(new BigDecimal(0.0))) {
                newSV.put(i, this.get(i) + that.get(i));
            }
        }
        return newSV;
    }



}
