package basic.knowledge.stephen.design_Pattern._08DesignPattern_Template;

public class SandWichSculptor {
    public static void main(String[] args) {
        Hoagie cust12Hoagie = new ItalianHoagie();
        cust12Hoagie.makeSancwich();
        System.out.println("=================");
        Hoagie cust13Hoagie = new Veggiehoagie();
        cust13Hoagie.makeSancwich();
    }
}
