package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.HashMap;
import java.util.Map;

//删除多余字符得到字典序最小的字符串
public class _09MinDicSequenByDel {
    public static void main(String[] args) {
        _09MinDicSequenByDel minDicSequenByDel = new _09MinDicSequenByDel();
        String res = minDicSequenByDel.getRes("baacccccbadaxacdcadc");
        System.out.println(res);
        String res1 = minDicSequenByDel.getResByHashMap("baacccccbadaxacdcadc");
        System.out.println(res1);
    }

    //注意: 要使用逻辑删除
    public String getRes(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chs = str.toCharArray();

        int[] map = new int[256];
        int num = 0;
        for (int i = 0; i < chs.length; i++) {
            if (map[chs[i]]++ == 0) {
                num++;
            }
        }

        int L = 0;
        int R = 0;
        int index = 0;
        char[] res = new char[num];
        while (R < chs.length) {
            if (map[chs[R]] == -1 || --map[chs[R]] > 0) {
                R++;
            } else {
                int pick = -1;
                for (int i = L; i <= R; i++) {
                    if ((map[chs[i]] != -1) && (pick == -1 || chs[i] < chs[pick])) {
                        pick = i;
                    }
                }

                res[index++] = chs[pick];
                map[chs[pick]] = -1;
                for (int i = pick + 1; i <= R; i++) {
                    if (map[chs[i]] != -1) {
                        map[chs[i]]++;
                    }
                }
                L = pick + 1;
                R = L;
            }
        }
        return String.valueOf(res);

    }


    public String getResByHashMap(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        char[] chs = str.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chs.length; i++) {
            if (map.containsKey(chs[i])) {
                map.put(chs[i], map.get(chs[i]) + 1);
            } else {
                map.put(chs[i], 1);
            }
        }
        char[] res = new char[map.size()];

        int left = 0;
        int right = 0;
        int index = 0;
        while (right < chs.length) {
            if (map.get(chs[right]) == -1 || map.get(chs[right]) >= 1) {
                if (map.get(chs[right]) >= 1) {
                    map.put(chs[right], map.get(chs[right]) - 1);
                }
                if (map.get(chs[right]) == 0) {
                    continue;
                }
                right++;
            } else {

                int pick = -1;
                for (int i = left; i <= right; i++) {
                    if (map.get(chs[i]) != -1 && ((pick == -1) || chs[i] < chs[pick])) {
                        pick = i;
                    }
                }

                res[index++] = chs[pick];

                // add back
                for (int i = pick + 1; i <= right; i++) {
                    if (map.get(chs[i]) != -1) {
                        map.put(chs[i], map.get(chs[i]) + 1);
                    }
                }

                // logically delete

                map.put(chs[pick], -1);

                left = pick + 1;
                right = left;

            }


        }

        return String.valueOf(res);
    }
}