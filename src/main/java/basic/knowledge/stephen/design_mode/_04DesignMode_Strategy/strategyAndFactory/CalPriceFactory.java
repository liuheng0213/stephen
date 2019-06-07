package basic.knowledge.stephen.design_mode._04DesignMode_Strategy.strategyAndFactory;


import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.abstractStrategy.CalPrice;
import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.concreteStrategy.GoldVip;
import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.concreteStrategy.Orgnic;
import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.concreteStrategy.SuperVip;
import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.concreteStrategy.Vip;

/**
 * 出现if-else的判断,不好简单工厂的缺点
 */
public class CalPriceFactory {
    private CalPriceFactory() {
    }

    //根据客户的总金额产生相应的策略
    public static CalPrice createCalPrice(Player customer) {
        if (customer.getTotalAmount() > 30000) {
            //3000则改为金牌会员计算方式
            return new GoldVip();
        } else if (customer.getTotalAmount() > 20000) {
            //类似
            return new SuperVip();
        } else if (customer.getTotalAmount() > 10000) {
            //类似
            return (CalPrice) new Vip();
        } else {
            return (CalPrice) new Orgnic();
        }
    }
}
