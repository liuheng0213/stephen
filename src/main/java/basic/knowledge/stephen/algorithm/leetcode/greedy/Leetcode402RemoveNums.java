package basic.knowledge.stephen.algorithm.leetcode.greedy;

import basic.knowledge.stephen.algorithm.InterverviewFromRenowedITCompany._01stackAndQueue._03ReverseStackByRecursive;

import java.util.Stack;

/**
 * 题目：已知一个使用字符串表示非负整数num，将num中的k个数字移除，求移除k个数字后，可以获得的最小的可能的新数字(num不会以0开头，num长度小于10002)
 * <p>
 * 例如：输入：num = “1432219”,k=3 
 * 在去掉3个数字后得到的很多可能里，如1432，4322，2219，1219。。。。；去掉数字4、3、2、得到的1219最小
 * 算法设计  原则   尽量保持  栈顶到栈底 单调递减  不符合的就删一个 且K--
 * 高位(先入栈的)的 又大的 拿掉： 高位(先入栈的)的又小的保留
 * 使用栈存储最终结果或删除工作，从高位向低位遍历num，
 * 如果遍历的数字大于栈顶元素，则将该数字push入栈，如果小于栈顶元素则进行pop弹栈，
 * 直到栈为空或不能再删除数字(k==0)或栈顶小于当前元素为止。
 * 最终栈中从栈底到栈顶存储的数字，即为结果。
 */
public class Leetcode402RemoveNums {
    public static void main(String[] args) {
        Integer result = solution("1432219", 3);
        System.out.println(result);
    }

    private static Integer solution(String s, int k) {
        char[] chars = s.toCharArray();
        Stack<Integer> tempStack = new Stack<>();
        for (char ch : chars) {
            if ((k == 0 || tempStack.isEmpty()) || tempStack.peek() < Integer.valueOf(ch + "")) {
                tempStack.push(Integer.valueOf(ch + ""));
            } else if (tempStack.peek() >= Integer.valueOf(ch + "")) {
                tempStack.pop();
                tempStack.push(Integer.valueOf(ch + ""));
                k--;
            }
        }
        String str = "";
        _03ReverseStackByRecursive.reverse(tempStack);
        while(!tempStack.isEmpty()){
            str += tempStack.pop();
        }
        //如果零在首位  就和下一位交换!
        //todo
        return Integer.parseInt(str);
    }
}








