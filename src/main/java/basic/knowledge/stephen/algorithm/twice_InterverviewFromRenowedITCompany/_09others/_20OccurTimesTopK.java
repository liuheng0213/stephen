package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._09others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _20OccurTimesTopK {
    public static void main(String[] args) {
        _20OccurTimesTopK occurTimesTopK = new _20OccurTimesTopK();
        String[] strs = new String[]{"1", "2", "1", "2", "2", "3", "4", "4", "4","7", "10"};
        occurTimesTopK.solution(strs, 3);
    }

    private void solution(String[] strs, int topK) {
        if (strs == null || topK < 1) {
            return;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            if (!map.containsKey(strs[i])) {
                map.put(strs[i], 1);
            } else {
                map.put(strs[i], map.get(strs[i]) + 1);
            }
        }

        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entries.iterator();

        PriorityQueue<Node> pq = new PriorityQueue<>(new MaxHeapCom());

        while (iterator.hasNext()) {
            Map.Entry<String, Integer> cur = iterator.next();
            String key = cur.getKey();
            Integer value = cur.getValue();
            pq.add(new Node(key, value));
        }
        int sequence = 1;
        while (topK > 0) {
            Node node = pq.poll();
            topK--;
            System.out.print("No." + sequence++ + ": ");
            System.out.print(node.str + ", times: ");
            System.out.println(node.times);
        }



    }

    class Node {
        String str;
        Integer times;

        public Node(String str, Integer times) {
            this.str = str;
            this.times = times;
        }
    }

    class MaxHeapCom implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.times - o1.times;
        }
    }
}
