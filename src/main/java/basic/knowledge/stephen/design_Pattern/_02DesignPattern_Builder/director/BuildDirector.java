package basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.director;


import basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.AbstractBuilder.ICarBuilder;
import basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.Product.Car;

public class BuildDirector {
    //only a directing method
    public Car constructCar(ICarBuilder builder)
    {
        builder.buildEngine();
        builder.buildSkeleton();
        builder.buildWheel();
        return builder.buildCar();
    }
}
