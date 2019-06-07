package basic.knowledge.stephen.switchThrough;

public class TestSwitch {
    public static void main(String[] args) {
        char c = 'a';
        int rand = (int) (26 * Math.random());
        char c2 = (char) (c + rand);
        System.out.println(c2 + ":");
        switch (c2) {//如果是a e i o u 当中的一个会一直向下运行直到碰到break；
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                System.out.println("元音");
                break;
            case 'y':
            case 'w':
                System.out.println("半元音");
                break;

            default:
                System.out.println("辅音");
        }
    }
}
