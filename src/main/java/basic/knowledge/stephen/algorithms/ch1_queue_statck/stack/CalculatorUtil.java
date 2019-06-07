package basic.knowledge.stephen.algorithms.ch1_queue_statck.stack;


//用栈解析运算过程

import org.apache.commons.lang3.StringUtils;

import java.util.Stack;

/**
 * 用两个栈一个存运算符,一个存操作数符
 *  遇到")" 两个都需要弹栈并运算,将结果再推到vals
 */
public class CalculatorUtil {
    public static Double getCalcResult(String calStr){
        char[] chars = calStr.toCharArray();
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        for(char ch :chars){
            String s = String.valueOf(ch);
            if(s.equals("(") || StringUtils.isEmpty(s) || StringUtils.isBlank(s)){
                //do nothing
            }
            else if(s.equals("-"))
                ops.push(s);
            else if(s.equals("+"))
                ops.push(s);
            else if(s.equals("*"))
                ops.push(s);
            else if(s.equals("/"))
                ops.push(s);
            else if(s.equals("sqrt"))
                ops.push(s);
            else if(s.equals(")")){
                String op = ops.pop();
                Double sec = vals.pop();
                Double first = vals.pop();
                Double tempRes = 0d;
                if(op.equals("-")){
                    tempRes = first - sec;
                }else if(op.equals("+")){
                    tempRes = first + sec;
                }else if(op.equals("*")){
                    tempRes = first * sec;
                }else if(op.equals("/")){
                    tempRes = first / sec;
                }else if(op.equals("sqrt")){
                    tempRes = Math.sqrt(sec);
                }
                vals.push(tempRes);
            }
            else
                vals.push(Double.parseDouble(s));
        }
        return vals.pop();
    }
}
