package basic.knowledge.stephen.design_Pattern._04DesignPattern_Strategy.annotation;

@PriceRegion(max=20000)
public class Vip implements CalPrice {
    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice * 0.9;
    }
}
