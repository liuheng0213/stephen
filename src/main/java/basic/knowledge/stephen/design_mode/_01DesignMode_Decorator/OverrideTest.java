package basic.knowledge.stephen.design_mode._01DesignMode_Decorator;

public class OverrideTest {
    public static void main(String[] args) {
        Override3 override3 = new Override3();
        override3.show();
    }

    public void show(){
        System.out.println("base");
    }

}
class Override3 extends Override2{

    @Override
    public void show() {
        super.show();
        System.out.println("o3");
    }
}


class Override2 extends Override1 {

    @Override
    public void show() {
        super.show();
        System.out.println("o2");
    }
}

class Override1 extends OverrideTest{

    @Override
    public void show() {
        super.show();
        System.out.println("o1");
    }
}


