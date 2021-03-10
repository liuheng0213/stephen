package basic.knowledge.stephen.design_Pattern._03DesignPattern_Factory._01SimpleStaticFactory;

public class TestDemo {
    public static void main(String[] args) {
        /**
         * 简单工厂模式
         */
        INoodles noodles = SimpleNoodlesFactory.createNoodles(SimpleNoodlesFactory.TYPE_RG);
        noodles.desc();
    }
}
