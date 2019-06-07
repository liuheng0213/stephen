package basic.knowledge.stephen.design_mode._04DesignMode_Strategy.annotation;

@PriceRegion(min=3000)
public class GoldVip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.7;
    }
}