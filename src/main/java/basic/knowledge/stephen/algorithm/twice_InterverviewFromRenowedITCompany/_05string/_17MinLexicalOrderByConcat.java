package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;

import java.util.Arrays;
import java.util.Comparator;

//将字符串拼接  拼接 使结果的字典序最小
public class _17MinLexicalOrderByConcat {
    public static void main(String[] args) {
        _17MinLexicalOrderByConcat obj = new _17MinLexicalOrderByConcat();
        String[] strs = new String[]{"b", "ba"};
        String res = obj.getMinLexicalOrderByConcat(strs);
        System.out.println(res);
    }

    private String getMinLexicalOrderByConcat(String[] strs) {
        Arrays.sort(strs, new StringComparator());
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    private class StringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1 + o2).compareTo(o2 + o1);
        }
    }
}
