package basic.knowledge.stephen.writtenExaminationQeustionsCollections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 求出一个字符串得最大连续递增子字符串
 * 如dchhdp456789sn3987ssss得出456789
 */
public class MaxContinuousSubString {
    public static void main(String[] args) {
        String str = getMaxContinuousSubString("assd3456789edchhipns3987stuvw");
        System.out.println(str);
    }

    private static String getMaxContinuousSubString(String str) {
        char[] chars = str.toCharArray();


        Map<Integer, Integer> map = new HashMap<>();
        int subStringlen = 1;
        for (int i = 0; i+1< chars.length; i++) {
            if (Character.isDigit(chars[i+1]) && Character.isDigit(chars[i]) && chars[i+1] >= chars[i]) {
                subStringlen++;
            } else {
                map.put(i-subStringlen+1, subStringlen);
                subStringlen = 1;
                continue;
            }
        }
        System.out.println(map);
        //拿到map的键集合nO. 因为需要堆值排序,所以需要拿到键值对对象
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        //放入arraylist
        ArrayList<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(entries);
        //对list排序
        entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        //最后的那个键值对必然是value最大得也就是最长得subString
        Map.Entry<Integer, Integer> lastEntry = entryList.get(entryList.size() - 1);
        System.out.println(lastEntry);
        Integer lastKey = lastEntry.getKey();
        String substring = str.substring(lastKey, lastKey + lastEntry.getValue());
        return substring;
    }
}
