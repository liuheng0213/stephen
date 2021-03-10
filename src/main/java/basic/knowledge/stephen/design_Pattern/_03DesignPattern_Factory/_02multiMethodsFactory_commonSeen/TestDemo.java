package basic.knowledge.stephen.design_Pattern._03DesignPattern_Factory._02multiMethodsFactory_commonSeen;

public class TestDemo {
    public static void main(String[] args) {
        /**
         * 多方法工厂, 常用
         */
        LzNoodles lzNoodles = MultiMethodsFactory.createLzNoodles();
        lzNoodles.desc();
    }
}
