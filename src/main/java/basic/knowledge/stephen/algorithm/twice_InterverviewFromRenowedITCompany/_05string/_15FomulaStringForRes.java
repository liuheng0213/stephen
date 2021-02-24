package basic.knowledge.stephen.algorithm.twice_InterverviewFromRenowedITCompany._05string;


import java.util.LinkedList;

//公式字符串求值
public class _15FomulaStringForRes {
    public static void main(String[] args) {
        String str = "(1+9)*3+4*10";
        char[] chars = str.toCharArray();
        _15FomulaStringForRes obj = new _15FomulaStringForRes();
        int res = obj.getRes(chars);
        System.out.println(res);
    }

    private int getRes(char[] chars) {
        return getData(chars, 0)[0];
    }

    private int[] getData(char[] chars, int i) {
        LinkedList<String> queue = new LinkedList<>();
        int[] data = null;
        int pre = 0;

        while (i < chars.length && chars[i] != ')') {
            if (chars[i] >= '0' && chars[i] <= '9') {
                pre = pre * 10 + chars[i++] - '0';
            } else if (chars[i] != '(') {
                addNum(queue, pre);
                queue.addLast(String.valueOf(chars[i++]));
                pre = 0;
            } else {
                data = getData(chars, i + 1);
                pre = data[0];
                i = data[1] + 1;
            }
        }
        addNum(queue, pre);
        return new int[]{getNum(queue), i};
    }

    private void addNum(LinkedList<String> queue, int pre) {
        String op = "";
        if (!queue.isEmpty()) {
            op = queue.pollLast();
            if (op.equals("+") || op.equals("-")) {
                queue.addLast(op);
            } else {
                int cur = Integer.valueOf(queue.pollLast());
                pre = op.equals("*") ? cur * pre : cur / pre;
            }
        }
        queue.addLast(String.valueOf(pre));
    }

    private int getNum(LinkedList<String> queue) {
        int res = 0;
        boolean add = true;
        int cur = 0;
        while (!queue.isEmpty()) {
            String str = queue.pollFirst();
            if(str.equals("+")){
                add = true;
            }else if(str.equals("-")){
                add = false;
            }else{
                cur = Integer.valueOf(str);
                res += add ? cur : - cur;
            }
        }
        return res;
    }


}
