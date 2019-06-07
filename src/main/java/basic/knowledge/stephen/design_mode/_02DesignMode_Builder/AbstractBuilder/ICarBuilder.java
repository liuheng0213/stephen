package basic.knowledge.stephen.design_mode._02DesignMode_Builder.AbstractBuilder;


import basic.knowledge.stephen.design_mode._02DesignMode_Builder.Product.Car;

public interface ICarBuilder {
    void buildWheel();
    void buildSkeleton();
    void buildEngine();

    Car buildCar();
}
