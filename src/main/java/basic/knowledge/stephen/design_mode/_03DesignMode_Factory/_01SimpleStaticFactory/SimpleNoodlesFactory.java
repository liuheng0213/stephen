package basic.knowledge.stephen.design_mode._03DesignMode_Factory._01SimpleStaticFactory;

public class SimpleNoodlesFactory {
    public static final int TYPE_LZ = 1;//兰州拉面
    public static final int TYPE_PM = 2;//泡面
    public static final int TYPE_RG = 3;//热干面

    public static INoodles createNoodles(int type) {

        switch (type) {
            case TYPE_LZ:
                return new LzNoodles();
            case TYPE_PM:
                return new PaoNoodles();
            case TYPE_RG:
            default:
                return new RgNoodles();
        }
    }
}
