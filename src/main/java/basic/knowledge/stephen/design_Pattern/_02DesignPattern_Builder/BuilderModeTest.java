package basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder;


import basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.ConcreteBuilder.ConcreteCarBuilder;
import basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.Product.Car;
import basic.knowledge.stephen.design_Pattern._02DesignPattern_Builder.director.BuildDirector;

public class BuilderModeTest {
    private Car car;
//    需要生产的产品对象有复杂的内部结构。
//    需要生产的产品对象的属性相互依赖，建造者模式可以强迫生成顺序。
//    在对象创建过程中会使用到系统中的一些其它对象，这些对象在产品对象的创建过程中不易得到
    public static void main(String[] args)
    {
        BuildDirector director = new BuildDirector();
        Car car = director.constructCar(new ConcreteCarBuilder(new Car()));
        System.out.println(car.getWheel());
        System.out.println(car.getEngine());
        System.out.println(car.getSkeleton());
    }
}
