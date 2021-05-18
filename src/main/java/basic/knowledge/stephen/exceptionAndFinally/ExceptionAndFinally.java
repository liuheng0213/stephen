package basic.knowledge.stephen.exceptionAndFinally;

public class ExceptionAndFinally {
    public static void main(String[] args) {
        System.out.println(getNum());
    }

    public static int getNum(){
        try {
            int a= 1 /0;
            return 1;
        } catch (Exception e) {
            return 2;
        }

        finally {
            return 3;
        }
    }
}
