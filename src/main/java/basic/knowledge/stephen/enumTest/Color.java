package basic.knowledge.stephen.enumTest;

public enum Color {
    //定义枚举中的常量
    RED(1,"红色"), GREEN(2,"青色"),BLACK(3,"黑色");

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //必需有这个构造器, 则自行匹配RED,GREEN,BLACK
    private Color(int code, String name) {
        this.code = code;
        this.name = name;
    }

    //在枚举列类中定义一个自定义方法，但如果要想能够被外面访问，需要定义成static类型。
    public static void containval(){

        Color[] colors = Color.values();

        for(Color c : colors){
            System.out.println(c.getCode() + ":" + c.getName());
        }
    }
}
