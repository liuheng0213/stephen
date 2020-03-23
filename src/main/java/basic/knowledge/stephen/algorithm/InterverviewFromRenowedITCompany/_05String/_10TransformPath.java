package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 字符串的转换路径问题, 找到所有的A-->B的最短路径
 * 图的典型应用
 */
public class _10TransformPath {
    public static void main(String[] args) {
        String start = "abc";
        String end = "cab";
        String[] list = {"cab", "acc", "cbc", "ccc", "cac", "cbb", "aab", "abb"};
        _10TransformPath transformPath = new _10TransformPath();
        List<List<String>> res = transformPath.findMinPath(start, end, list);
        System.out.println();
    }

    private List<List<String>> findMinPath(String start, String end, String[] strs) {
        List<String> arrList = new ArrayList<>();
        for (String str : strs) {
            arrList.add(str);
        }
        arrList.add(start);
        Map<String, List<String>> nexts = getNexts(arrList);
        Map<String, Integer> distances = getDis(nexts, start);
        LinkedList<String> pathLinkedList = new LinkedList<>();
        List<List<String>> res = new ArrayList<>();
        getShortestPaths(start, end, nexts, distances, pathLinkedList, res);
        return res;
    }

    /**
     * 宽度优先搜索
     * 一个map  各点到start的距离
     *
     * @param nexts
     * @param start
     * @return
     */
    private Map<String, Integer> getDis(Map<String, List<String>> nexts, String start) {
        Map<String, Integer> distances = new HashMap<>();
        distances.put(start, 0);

        //控制遍历顺序
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        //控制记录走过的节点
        HashSet<String> mark = new HashSet<>();
        mark.add(start);

        while (!queue.isEmpty()) {
            String cur = queue.poll();//类似start
            for (String str : nexts.get(cur)) {
                //如果没有走过
                if (!mark.contains(str)) {
                    distances.put(str, distances.get(cur) + 1);
                    queue.add(str);
                    mark.add(str);
                }
            }
        }
        return distances;
    }

    private Map<String, List<String>> getNexts(List<String> arrList) {
        HashSet<String> set = new HashSet<>(arrList);
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < arrList.size(); i++) {
            map.put(arrList.get(i), getnext(arrList.get(i), set));
        }
        return map;
    }

    private List<String> getnext(String s, HashSet<String> set) {
        List<String> nextList = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] != ch) {
                    char temp = chars[i];
                    chars[i] = ch;
                    if (set.contains(String.valueOf(chars))) {
                        nextList.add(String.valueOf(chars));
                    }
                    chars[i] = temp;
                }
            }
        }
        return nextList;
    }

    /**
     * 找到所有 start ---> end的最短路径
     * 深度优先搜索  运用了回溯算法
     *
     * @param start
     * @param end
     * @param nexts
     * @param distances
     * @param pathLinkedList
     * @param res
     */
    private void getShortestPaths(String start,
                                  String end,
                                  Map<String, List<String>> nexts,
                                  Map<String, Integer> distances,
                                  LinkedList<String> pathLinkedList,
                                  List<List<String>> res) {
        pathLinkedList.add(start);
        if (start.equals(end)) {
            res.add(new LinkedList<>(pathLinkedList));
        } else {
            for (String next : nexts.get(start)) {
                if (distances.get(next) == distances.get(start) + 1) {
                    getShortestPaths(next, end, nexts, distances, pathLinkedList, res);
                }
            }
        }
        pathLinkedList.pollLast();
    }
}
