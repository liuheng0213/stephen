package basic.knowledge.stephen.design_Pattern._04DesignPattern_Strategy.annotation;

@PriceRegion(min=3000)
public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.7;
    }
}