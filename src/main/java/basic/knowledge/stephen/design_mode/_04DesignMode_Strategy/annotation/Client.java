package basic.knowledge.stephen.design_mode._04DesignMode_Strategy.annotation;


/**
 * 1.针对同一类型问题的多种处理方式，仅仅是具体行为有差别时；
 2.需要安全地封装多种同一类型的操作时；
 3.出现同一抽象类有多个子类，而又需要使用 if-else 或者 switch-case 来选择具体子类时。
 */
public class Client {
    public static void main(String[] args) {
        Player player = new Player();
        player.buy(5000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
        player.buy(12000D);
        System.out.println("玩家需要付钱：" + player.calLastAmount());
    }
}

