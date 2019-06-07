package basic.knowledge.stephen.ThreadRelevant._05howToShareData.inConsistentThreads;


/**
 * 线程类
 */
public class RunnableCusToInc implements Runnable{

    private SharedData sharedData;

    public RunnableCusToInc(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            sharedData.inc();
        }
    }
}
