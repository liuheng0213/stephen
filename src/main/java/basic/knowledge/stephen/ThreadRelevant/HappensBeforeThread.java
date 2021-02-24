package basic.knowledge.stephen.ThreadRelevant;

public class HappensBeforeThread {
    public static void main(String[] args) {
        HappensBeforeThread happensBeforeThread = new HappensBeforeThread();
        happensBeforeThread.write();
    }
    int a = 0;
    int b = 1;
    boolean flag = false;
    public  void write() {
        b ++;
        a = 1;

        new Thread(() -> {
            if (flag) {
                System.out.println(a + b);
            }
        } ).start();
    }
}
