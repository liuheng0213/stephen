package basic.knowledge.stephen.design_Pattern._04DesignPattern_Strategy.annotation;

@PriceRegion(max = 10000)
public class Orgnic implements CalPrice {

    @Override
    public Double calPrice(Double orgnicPrice) {
        return orgnicPrice;
    }
}
