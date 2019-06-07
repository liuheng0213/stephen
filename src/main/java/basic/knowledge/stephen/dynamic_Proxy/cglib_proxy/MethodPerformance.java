package basic.knowledge.stephen.dynamic_Proxy.cglib_proxy;

public class MethodPerformance {
    private long beginTime;
    private long endTime;
    private String serviceMethod;

    public MethodPerformance(String serviceMethod) {
        this.serviceMethod = serviceMethod;
        this.beginTime = System.currentTimeMillis();        //初始化
    }

    public void printPerformance(){
        this.endTime = System.currentTimeMillis();
        long collapse  = endTime - beginTime;
        System.out.println("花费了:"+ collapse);
    }
}
