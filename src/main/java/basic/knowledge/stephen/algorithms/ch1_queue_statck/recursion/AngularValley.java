package basic.knowledge.stephen.algorithms.ch1_queue_statck.recursion;

/**
 * 角谷定理。输入一个自然数，若为偶数，则把它除以2，
 * 若为奇数，则把它乘以3加1。经过如此有限次运算后，
 * 总可以得到自然数值1。求经过多少次可得到自然数1。
 */
public class AngularValley {
    public static void main(String[] args) {
        int num = 50;
        int times = 0;
        while(num != 1){
            if(num % 2 == 0){
                num = num /2;
                times++;
            }else{
                num = num*3 +1;
                times++;
            }
        }
        System.out.println(times);
    }


}
