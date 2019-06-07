package basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.concreteStrategy;


import basic.knowledge.stephen.design_mode._04DesignMode_Strategy.onlyStartegy.abstractStrategy.CalPrice;

public class Orgnic implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}

