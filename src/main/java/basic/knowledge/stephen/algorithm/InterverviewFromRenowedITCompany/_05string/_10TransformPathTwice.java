package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class _10TransformPathTwice {
    public List<LinkedList<String>> getTransformPath(String start, String des, List<String> list) {
        HashMap<String, List<String>> linkNexts = getNexts(start, list);
        HashMap<String, Integer> distanceMap = bfs(start, linkNexts);
        List<LinkedList<String>> res = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        findPathList(start, des, linkNexts, distanceMap, res, queue);
        return res;
    }

    private void findPathList(String cur, String des,
                                            HashMap<String, List<String>> linkNexts, HashMap<String, Integer> distanceMap,
                                            List<LinkedList<String>> res, LinkedList<String> queue) {
        queue.add(cur);
        if (cur.equals(des)) {
            res.add(new LinkedList<>(queue));
        } else {
            for (String next : linkNexts.get(cur)) {
                if (distanceMap.get(next) == distanceMap.get(cur) + 1) {
                    findPathList(next, des, linkNexts, distanceMap, res, queue);
                }
            }
        }
        queue.pollLast();
    }

    private HashMap<String, Integer> bfs(String start, HashMap<String, List<String>> linkNexts) {
        HashMap<String, Integer> distanceMap = new HashMap<>();
        distanceMap.put(start, 0);
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        HashSet<String> marked = new HashSet<>();
        while (queue.size() > 0) {
            String cur = queue.poll();
            for (String next : linkNexts.get(cur)) {
                if (!marked.contains(next)) {
                    distanceMap.put(next, distanceMap.get(cur) + 1);
                    marked.add(next);
                    queue.add(next);
                }
            }
        }
        return distanceMap;
    }

    private HashMap<String, List<String>> getNexts(String start, List<String> list) {
        list.add(start);
        HashMap<String, List<String>> mapNexts = new HashMap<>();
        Set<String> dict = new HashSet<>(list);
        for (String str : list) {
            mapNexts.put(str, getNext(str, dict));
        }
        return mapNexts;
    }

    private List<String> getNext(String str, Set<String> dict) {
        char[] chs = str.toCharArray();
        List<String> res = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chs.length; i++) {
                if (ch != chs[i]) {
                    char temp = chs[i];
                    chs[i] = ch;
                    if (dict.contains(String.valueOf(chs))) {
                        res.add(String.valueOf(chs));
                    }
                    chs[i] = temp;
                }
            }
        }
        return res;
    }
}