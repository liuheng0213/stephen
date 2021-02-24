package basic.knowledge.stephen.ThreadRelevant._22ShareData.differentLogicInRunMethod;

public class Acount {
    private  int money;
    Acount(int money) {
        this.money = money;
    }

    public synchronized void getMoney(int money) {
        while (this.money < money) {
            System.out.println("余额不足");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money -= money;
        System.out.println("取出" + money + ",还剩" + this.money);
    }

    public synchronized void setMoney(int money) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.money += money;
        System.out.println("新存入" + money + ",总额：" + this.money);
        notify();

    }

    public static void main(String[] args) {
        Acount acount = new Acount(0);
        Bank bank = new Bank(acount);
        Consumer consumer = new Consumer(acount);
        new Thread(bank).start();
        new Thread(consumer).start();

    }
}
