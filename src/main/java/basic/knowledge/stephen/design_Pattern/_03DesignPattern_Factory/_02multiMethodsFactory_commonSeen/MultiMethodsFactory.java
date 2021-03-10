package basic.knowledge.stephen.design_Pattern._03DesignPattern_Factory._02multiMethodsFactory_commonSeen;

/**
 * 模仿线程池关键类
 * Excecutor
 */
public class MultiMethodsFactory {

    /**
     * create lzNoodles
     * @return
     */
    public static LzNoodles createLzNoodles(){
        return new LzNoodles();
    }
    /**
     * create PaoNoodles
     * @return
     */
    public static PaoNoodles createPaoNoodles(){
        return new PaoNoodles();
    }
    /**
     * create RgNoodles
     * @return
     */
    public static RgNoodles createRgNoodles(){
        return new RgNoodles();
    }
}
