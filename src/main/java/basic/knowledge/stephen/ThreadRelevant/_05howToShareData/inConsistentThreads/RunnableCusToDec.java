package basic.knowledge.stephen.ThreadRelevant._05howToShareData.inConsistentThreads;

public class RunnableCusToDec implements Runnable{
    private SharedData sharedData;

    public RunnableCusToDec(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        for (int i = 0;i<5;i++){
            sharedData.dec();
        }
    }
}
