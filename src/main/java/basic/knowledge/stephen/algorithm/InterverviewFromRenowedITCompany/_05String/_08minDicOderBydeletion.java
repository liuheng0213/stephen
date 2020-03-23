package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

//删除多余字符
public class _08minDicOderBydeletion {
    public static void main(String[] args) {
        _08minDicOderBydeletion minDicOderBydeletion = new _08minDicOderBydeletion();
        String str = "dbcacbca";
        char[] chars = str.toCharArray();
        char[] res = minDicOderBydeletion.removeDupLetters(chars);
        System.out.println(new String(res));
    }

    private char[] removeDupLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return chars;
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
            for(Character ch : chList){
                newChs[k++] = ch;
            }
            mark = markSize(newChs);
            chars = newChs;
        }

        return res;

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
