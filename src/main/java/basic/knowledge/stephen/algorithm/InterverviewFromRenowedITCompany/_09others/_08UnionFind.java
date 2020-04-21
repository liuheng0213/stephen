package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._09others;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//底层是map的并查集 而不是数组
//quick union
//其实可以不需要rankMap  rankMap 只是为了保证 小的树挂在大的树上, 进一步优化而已
public class _08UnionFind<T> {
    public HashMap<T, Element<T>> eleMap;
    public HashMap<Element<T>, Element<T>> fatherMap;
    public HashMap<Element<T>, Integer> rankMap;

    public _08UnionFind(List<T> list) {
        this.eleMap = new HashMap<>();
        this.fatherMap = new HashMap<>();
        this.rankMap = new HashMap<>();
        for (T t : list) {
            Element<T> ele = new Element<>(t);
            eleMap.put(t, ele);
            fatherMap.put(ele, ele);
            rankMap.put(ele, 1);
        }
    }

    private Element<T> findHead(Element<T> element) {
        Stack<Element<T>> path = new Stack<>();
        while (element != this.fatherMap.get(element)) {
            path.push(element);
            element = this.fatherMap.get(element);
        }
        // now element is the father.
        //路径压缩, 所有子节点直接联系父节点
        while (!path.isEmpty()) {
            fatherMap.put(path.pop(), element);
        }
        return element;
    }

    public boolean isSameSet(T a, T b) {
        if (eleMap.containsKey(a) && eleMap.containsKey(b)) {
            return findHead(eleMap.get(a)) == findHead(eleMap.get(b));
        }
        return false;
    }

    public void union(T a, T b) {
        if (eleMap.containsKey(a) && eleMap.containsKey(b)) {
            Element<T> aF = findHead(eleMap.get(a));
            Element<T> bF = findHead(eleMap.get(b));
            if (aF != bF) {
                Element<T> big = rankMap.get(aF) >= rankMap.get(bF) ? aF : bF;
                Element<T> small = big == aF ? bF : aF;
                fatherMap.put(small, big);
                rankMap.put(big, rankMap.get(aF) + rankMap.get(bF));
                rankMap.remove(small);
            }
        }
    }


    static class Element<T> {
        private T value;

        public Element(T value) {
            this.value = value;
        }
    }
}
