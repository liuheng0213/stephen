package basic.knowledge.stephen.overload_override.overload;

public class Overload {
    public static void main(String[] args) {
        Overload overload = new Overload();
        String res1 = overload.testOverload1(2);
        int res2 = overload.testOverload1(2,"ss");
    }

    private int testOverload1(int i, String ss) {
        return 2;
    }

    private String testOverload1(int i) {
        return "dss";
    }
}
