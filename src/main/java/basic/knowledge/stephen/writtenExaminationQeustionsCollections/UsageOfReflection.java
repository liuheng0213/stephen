package basic.knowledge.stephen.writtenExaminationQeustionsCollections;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * ArrayList<Integer> list = new ArrayList<Integer>();
 在这个泛型为Integer的ArrayList中存放一个String类型的对象。
 */
public class UsageOfReflection {
    public static void main(String[] args) throws Exception {

        ArrayList<Integer> list =new ArrayList<>();//定义一个Integer泛型集合

        String str ="java，我爱你！";//需要存放的String类型字符串。
        Method[] method = list.getClass().getMethods();//通过反射获取到list的所有方法。

        System.out.println(method.length);//输出。获取到的方法个数。
        System.out.println(method[0]);//输出可知,通过反射拿到的add为add(Object obj)

        method[0].invoke(list, str);//通过反射，把字符串str存进了list集合中。第一个list是指对象，第二个str是要存入的字符串。

        System.out.println(list.size());//输出集合元素长度。

        for (int i = 0; i <list.size(); i++) {
            System.out.println(list.get(i));//输出添加成功的字符串。
        }
    }
}
