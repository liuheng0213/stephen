package basic.knowledge.stephen.ThreadRelevant._05howToShareData.inConsistentThreads;

/**
 * 演示多线程共享资源, ruunbale包sharedResource
 * 非一致性, 即一个方法对共享数据是增,一个是减
 */
public class ThreadDemo {


    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        for (int i=0;i<4;i++){
            if (i%2==0) {
                new Thread(new RunnableCusToInc(sharedData),"Thread"+i).start();
            }else{
                new Thread(new RunnableCusToDec(sharedData),"Thread"+i).start();
            }
        }
    }
}
