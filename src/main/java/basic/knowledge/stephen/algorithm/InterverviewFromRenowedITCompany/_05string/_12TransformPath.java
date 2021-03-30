package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 字符串的转换路径问题, 找到所有的A-->B的最短路径
 * 图的典型应用
 */
public class _12TransformPath {
    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        String[] list = {"hot","dot","dog","lot","log","cog"};
        _12TransformPath transformPath = new _12TransformPath();
        LinkedList<LinkedList<String>> res = transformPath.findMinPath(start, end, list);

        System.out.println(res);
    }

    private LinkedList<LinkedList<String>> findMinPath(String start, String end, String[] list) {
        List<String> strList = new ArrayList<>();
        strList.add(start);
        for (int i = 0; i < list.length; i++) {
            strList.add(list[i]);
        }

        HashMap<String, List<String>> nextMap = getNexts(strList);
        HashMap<String, Integer> disMap = bfs(start, nextMap);
        LinkedList<LinkedList<String>> paths = new LinkedList<>();
        dfs(paths, new LinkedList<>(), start, end, disMap, nextMap);
        return paths;
    }

    private void dfs(LinkedList<LinkedList<String>> paths,
                     LinkedList<String> subList,
                     String cur, String to,
                     HashMap<String, Integer> disMap,
                     HashMap<String, List<String>> nextMap) {
        subList.addLast(cur);
        if (cur.equals(to)) {
            paths.add(new LinkedList<>(subList));
            //subList.pollLast();
            return;
        }

        for (String next : nextMap.get(cur)) {
            if (disMap.get(cur) + 1 == disMap.get(next)) {
                dfs(paths, subList, next, to, disMap, nextMap);
                subList.pollLast();
            }

        }
    }


    private HashMap<String, Integer> bfs(String start, HashMap<String, List<String>> nextMap) {
        HashMap<String, Integer> disMap = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        disMap.put(start, 0);
        HashSet<String> flaggedSet = new HashSet<>();
        flaggedSet.add(start);
        String cur = null;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            for (String next : nextMap.get(cur)) {
                if (!flaggedSet.contains(next)) {
                    disMap.put(next, disMap.get(cur) + 1);
                    flaggedSet.add(next);
                    queue.add(next);
                }
            }
        }
        return disMap;
    }

    private HashMap<String, List<String>> getNexts(List<String> strList) {
        HashSet<String> recordSet = new HashSet<>(strList);
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strList) {
            map.put(str, getNext(str, recordSet));
        }
        return map;
    }

    private List<String> getNext(String str, HashSet<String> recordSet) {
        char[] chars = str.toCharArray();

        char temp = 0;
        List<String> list = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ch) {
                    temp = chars[i];
                    chars[i] = ch;
                    if (recordSet.contains(String.valueOf(chars))) {
                        list.add(String.valueOf(chars));
                    }
                    chars[i] = temp;
                }
            }
        }
        return list;

    }


}
