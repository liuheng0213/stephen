package basic.knowledge.stephen.recursion.recursion_tail_recursion;

/**
 * 兔子问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
 问第二十个月的时候兔子对数为多少？
 思路:
 第一个月: 2(1)
 第二个月: 2(2)
 第三个月: 2(3)+2(0)=4
 第四个月: 2(4)+2(1)+2(0)=6
 第五个月: 2(5)+2(2)+2(1)+2(0)=8
 第六个月: 2(6)+2(3)+2(2)+2(1)+2(0)+2(0)= 12
 第七个月: 2(7)+2(4)+2(3)+2(2)+2(1)+2(1)+2(0)+2(0)+2(0)=18
 第八个月: 2(8)+2(5)+2(4)+2(3)+2(2)+2(2)+2(1)+2(1)+2(1)+2(0)+2(0)+2(0)+2(0)=26
 从规律可知f(month)=f(month-1)+f(month-2)
 */
public class Rabbit {
    public static void main(String[] args) {
        int num = rabbitNum(20);
        System.out.println(num);
    }

    public static int rabbitNum(int month){
        if(month == 1||month ==2){
            return 2;
        }else if(month < 1){
            return -1;
        }else{
            return rabbitNum(month -1) + rabbitNum(month -2);
        }
    }
}
