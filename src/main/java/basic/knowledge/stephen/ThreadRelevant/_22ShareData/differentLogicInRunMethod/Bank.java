package basic.knowledge.stephen.ThreadRelevant._22ShareData.differentLogicInRunMethod;

public class Bank implements Runnable{
    Acount acount;//share this account/money
    public Bank(Acount acount) {
        this.acount = acount;
    }

    @Override
    public void run() {
        while(true) {
            int random = (int)(Math.random() * 1000);
            acount.setMoney(random);
        }
    }
}
