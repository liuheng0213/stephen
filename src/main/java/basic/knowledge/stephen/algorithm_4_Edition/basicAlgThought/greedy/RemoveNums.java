package basic.knowledge.stephen.algorithm_4_Edition.basicAlgThought.greedy;

/**
 * 题目：已知一个使用字符串表示非负整数num，将num中的k个数字移除，求移除k个数字后，可以获得的最小的可能的新数字(num不会以0开头，num长度小于10002)

 例如：输入：num = “1432219”,k=3 
 在去掉3个数字后得到的很多可能里，如1432，4322，2219，1219。。。。；去掉数字4、3、2、得到的1219最小
 算法设计：
 使用栈存储最终结果或删除工作，从高位向低位遍历num，
 如果遍历的数字大于栈顶元素，则将该数字push入栈，如果小于栈顶元素则进行pop弹栈，
 直到栈为空或不能再删除数字(k==0)或栈顶小于当前元素为止。
 最终栈中从栈底到栈顶存储的数字，即为结果。
 */
public class RemoveNums {
    public static void main(String[] args) {
        Integer result = solution("1430219",2);
        System.out.println(result);
    }

    private static Integer solution(String s, int num) {
        char[] chars = s.toCharArray();

        return 0;
    }
}
