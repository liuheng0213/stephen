package basic.knowledge.stephen.dynamic_Proxy.JDKproxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * write a proxy of ArrayList
 */
public class ArrayListDemo {
    //一定要有接口的类such as List in this case
    private static final List<String> list = new ArrayList<String>();

    public static void main(String[] args) {

        List<String> proxyInstance = (List<String>) Proxy.newProxyInstance(list.getClass().getClassLoader()
                , list.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println("before..."); no, must be the list relevant method.
                list.add("wash hands first");
                Object result = method.invoke(list, args);
                list.add("wash hands after");
                //System.out.println("after...");
                return result;
            }
        });

        proxyInstance.add("time to eat");

        for (String str:
            list ) {
            System.out.println(str);
        }
        /**
         * out put:
         * wash hands first
         time to eat
         wash hands after
         */
    }
}
