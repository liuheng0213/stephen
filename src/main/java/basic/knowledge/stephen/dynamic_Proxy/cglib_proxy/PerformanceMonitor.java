package basic.knowledge.stephen.dynamic_Proxy.cglib_proxy;

public class PerformanceMonitor {
    private static ThreadLocal<MethodPerformance> local = new ThreadLocal<MethodPerformance>();

    public static void begin(String method){            //启动对某一方法的监视
        System.out.println("监视开始");
        MethodPerformance methodPerformance = new MethodPerformance(method);
        local.set(methodPerformance);
    }

    public static void end(){
        System.out.println("监视结束");
        MethodPerformance methodPerformance = local.get();
        methodPerformance.printPerformance();
    }
}
