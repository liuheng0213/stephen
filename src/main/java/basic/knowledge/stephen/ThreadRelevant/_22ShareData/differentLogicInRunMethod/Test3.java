package basic.knowledge.stephen.ThreadRelevant._22ShareData.differentLogicInRunMethod;

public class Test3 {


    static  int j = 0;

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            new Thread(new Add()).start();
            new Thread(new Reduce()).start();
        }
    }

    /**
     * 共享数据内部类方式
     */
    /*****同步******/
    public static synchronized void add(){
        j++;
        System.out.println("add:"+j);
    }

    /*****同步******/
    public static synchronized void reduce(){
        j--;
        System.out.println("reduce:"+j);
    }

    static class Add implements Runnable{

        @Override
        public void run() {
            add();
        }
    }

    static class Reduce implements Runnable{

        @Override
        public void run() {
            reduce();
        }
    }

}
