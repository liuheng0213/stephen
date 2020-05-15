package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

//删除多余字符
public class _08MinDicOderBydeletion {
    public static void main(String[] args) {
        _08MinDicOderBydeletion minDicOderBydeletion = new _08MinDicOderBydeletion();
        String str = "aa";
        String res = minDicOderBydeletion.removeDuplicateLetters(str);
        System.out.println(res);
        String res1 = minDicOderBydeletion.removeDuplicateLetters_best(str);
        System.out.println(res1);
    }

    /**
     * 用标记的方法假删除
     *
     * @param str
     * @return
     */
    private String removeDuplicateLetters_best(String str) {
        char[] chars = str.toCharArray();
        int[] map = new int[26];
        // map value == - 1 意味着 "删除"
        for (int i = 0; i < chars.length; i++) {
            map[chars[i] - 'a']++;
        }

        int index = 0;
        int left = 0;
        int right = 0;
        char[] res = new char[26];
        while (right < chars.length) {
            if (map[chars[right] - 'a'] == -1 || --map[chars[right] - 'a'] > 0) { //想想为什么不是等于>= 0  babac 就不行
                right++;
            } else {

                int minLex = -1;
                for (int i = left; i <= right; i++) {
                    if (map[chars[i] - 'a'] != -1 && (minLex == -1 || chars[i] < chars[minLex])) {
                        minLex = i;
                    }
                }
                res[index++] = chars[minLex];
                map[chars[minLex] - 'a'] = -1;
                for (int i = minLex + 1; i <= right; i++) {
                    if (map[chars[i] - 'a'] != -1) {
                        map[chars[i] - 'a']++;
                    }
                }
                left = minLex + 1;
                right = left;
            }

        }

        return new String(res, 0, index);

    }

    private boolean biggerthanZero(Map<Character, Integer> map, int right, char[] chars) {
        map.put(chars[right], map.get(chars[right]) - 1);
        return map.get(chars[right]) > 0;
    }

    /**
     * 我这是真删除, 效率低
     *
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        char[] chars = s.toCharArray();
        if (chars == null || chars.length == 0) {
            return "";
        }
        //得到res的size
        Map<Character, Integer> mark = markSize(chars);
        char[] res = new char[mark.size()];
        int resIndex = 0;
        while (mark.size() > 0) {

            int i = 0;
            for (; i < chars.length; i++) {
                if (mark.containsKey(chars[i]) && mark.get(chars[i]) > 0) {
                    mark.put(chars[i], mark.get(chars[i]) - 1);
                    if (mark.get(chars[i]) == 0) {
                        mark.remove(chars[i]);// very important
                        break;
                    }
                }
            }
            int minIndex = 0;
            for (int j = 0; j <= i; j++) {
                if (chars[minIndex] - chars[j] > 0) {
                    minIndex = j;
                }
            }
            res[resIndex++] = chars[minIndex];
            //删除剩余字符串中的chars[minIndex]
            ArrayList<Character> chList = new ArrayList<>();
            for (int j = minIndex + 1; j < chars.length; j++) {
                if (chars[j] != chars[minIndex]) {
                    chList.add(chars[j]);
                }
            }
            char[] newChs = new char[chList.size()];
            int k = 0;
            for (Character ch : chList) {
                newChs[k++] = ch;
            }
            mark = markSize(newChs);
            chars = newChs;
        }

        return new String(res);

    }

    private Map<Character, Integer> markSize(char[] chars) {
        Map<Character, Integer> mark = new LinkedHashMap<>();
        for (int i = 0; i < chars.length; i++) {
            if (mark.containsKey(chars[i])) {
                mark.put(chars[i], mark.get(chars[i]) + 1);
            } else {
                mark.put(chars[i], 1);
            }
        }
        return mark;
    }
}
