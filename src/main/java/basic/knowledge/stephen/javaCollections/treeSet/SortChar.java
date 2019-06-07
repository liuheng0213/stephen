package basic.knowledge.stephen.javaCollections.treeSet;


import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * 从键盘接收一个字符串, 程序对其中所有字符进行排序,例如键盘输入: helloitcast程序打印:acehillostt
 * 分析
 * 1, 键盘录入字符串
 * 2, 将字符串转换为字符数组		需要比较器,因为character里有compareTo是无法改变的(integer,string都是无法改变的),故直接添加一定会去除重复元素
 * 3, 定义TreeSet集合传入比较器,对字符排序并保留重复
 * 4, 遍历字符数组,将每一个字符存储在TreeSet集合中
 * 5, 遍历TreeSet集合,并打印
 */
public class SortChar {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();

        char[] chars = str.toCharArray();

        //3, 定义TreeSet集合传入比较器,对字符排序并保留重复
        TreeSet<Character> set = new TreeSet<>(new Comparator<Character>(){
            @Override
            public int compare(Character o1, Character o2) {
                // TODO Auto-generated method stub
                //接受重复的数字 so 需要有1 的可能
                return o1.compareTo(o2) == 0 ? 1 : o1.compareTo(o2);
            }
        });

        //4, 遍历字符数组,将每一个字符存储在TreeSet集合中
        for (char ch : chars) {
            set.add(ch);
        }

        for (Character character : set) {
            //不要ln哦
            System.out.print(character);
        }

        //转为字符串怎么做?
        //向下强转是这么写的(Character[])
		/*
		String newString = String.valueOf();
		System.out.println(newString);*/

    }
}
