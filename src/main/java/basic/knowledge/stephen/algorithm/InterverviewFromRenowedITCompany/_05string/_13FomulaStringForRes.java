package basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._05string;


import java.util.Stack;

//公式字符串求值
public class _13FomulaStringForRes {
    public static void main(String[] args) {
        _13FomulaStringForRes fomulaStringForRes = new _13FomulaStringForRes();
        String str = "((1 + 2) * ((5 - 1) + (sqrt4)))";
        Double res = fomulaStringForRes.getRes(str);
        System.out.println(res);
    }

    private Double getRes(String str) {
        char[] chars = str.toCharArray();
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            String s = String.valueOf(chars[i]);
            if(s.equals(" ")){
                continue;
            }
            if ("(".equals(s)) {
                //do nothing
            } else if ("+".equals(s)) {
                ops.push(s);
            } else if ("-".equals(s)) {
                ops.push(s);
            } else if ("*".equals(s)) {
                ops.push(s);
            } else if ("/".equals(s)) {
                ops.push(s);
            } else if ("s".equals(s)) {
                char[] temp = new char[4];
                ops.push(String.valueOf(temp));
                i = i + 3;
            } else if (")".equals(s)) {
                Double val = vals.pop();
                String op = ops.pop();
                if ("+".equals(op)) {
                    val = vals.pop() + val;
                } else if ("-".equals(op)) {
                    val = vals.pop() - val;
                } else if ("*".equals(op)) {
                    val = vals.pop() * val;
                } else if ("/".equals(op)) {
                    val = vals.pop() / val;
                } else {
                    val = Math.sqrt(val);
                }
                vals.push(val);
            } else{
                vals.push(Double.valueOf(s));
            }
        }
        return vals.pop();
    }
}
