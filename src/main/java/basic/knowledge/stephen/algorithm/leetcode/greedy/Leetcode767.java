package basic.knowledge.stephen.algorithm.leetcode.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode767 {
    public static void main(String[] args) {
        Leetcode767 leetcode767 = new Leetcode767();
        String res = leetcode767.reorganizeString("baaba");
        String res1 = leetcode767.reorganizeString_best("baaba");
        System.out.println(res1);
    }

    private String reorganizeString_best(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }

        int length = S.length();
        int[] counts = new int[26];
        for (char c : S.toCharArray()) {
            counts[c - 'a'] += 100;
        }

        for (int i = 0; i < 26; ++i) {
            counts[i] += i;
        }
        Arrays.sort(counts);
        char[] result = new char[length];
        int t = 1;
        for (int code : counts) {
            int ct = code / 100;
            char ch = (char) ('a' + (code % 100));
            if (ct > (length + 1) / 2) {
                return "";
            }
            for (int i = 0; i < ct; ++i) {
                if (t >= length) {
                    t = 0;
                }
                result[t] = ch;
                t += 2;
            }
        }

        return String.valueOf(result);
    }

    public String reorganizeString(String str) {
        char[] chars = str.toCharArray();
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.times - o1.times;
            }
        });
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (map.containsKey(chars[i])) {
                map.put(chars[i], map.get(chars[i]) + 1);
            } else {
                map.put(chars[i], 1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer> cur = iterator.next();
            Character key = cur.getKey();
            Integer value = cur.getValue();
            if (value > (str.length() + 1) / 2) {
                return "";
            }
            pq.add(new Pair(key, value));
        }
        StringBuilder newStrBuilder = new StringBuilder();
        while(pq.size() > 1){
            Pair first = pq.poll();
            Pair second = pq.poll();
            newStrBuilder.append(first.ch).append(second.ch);
            first.times--;
            second.times--;
            if(first.times > 0){
                pq.add(first);
            }
            if(second.times > 0){
                pq.add(second);
            }
        }
        if(pq.size() == 1){
            newStrBuilder.append(pq.poll().ch);
        }
        return newStrBuilder.toString();

    }


    class Pair {
        private Character ch;
        private Integer times;

        public Pair(Character ch, Integer times) {
            this.ch = ch;
            this.times = times;
        }
    }


}
