package basic.knowledge.stephen.classLoader.myClassLoader.myClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 自定义类加载器的作用：jvm自带的三个加载器只能加载指定路径下(一般classpath)的类字节码。
 * 如果某个情况下，我们需要加载应用程序之外的类文件呢？
 * 比如本地D盘下的，或者去加载网络上的某个类文件，这种情况就可以使用自定义加载器了。
 */
public class TestMyClassLoader {
    public static void main(String []args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, InvocationTargetException {
        //自定义类加载器的加载路径
        MyClassLoader myClassLoader=new MyClassLoader("D:\\lib");
        //包名+类名,LoadClass是继承自classLoader的
        Class c=myClassLoader.findClass("Cooper.classLoader.myClassLoader.myClassLoader.TestBean");

        if(c!=null){
            Object obj=c.newInstance();//获取实例
            //获取say方法的method对象
            Method method=c.getMethod("say", null);
            method.invoke(obj, null);
            System.out.println(c.getClassLoader().toString());
        }
    }
}
