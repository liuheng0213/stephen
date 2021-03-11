package basic.knowledge.stephen.design_Pattern._08DesignPattern_Template;

public class Veggiehoagie extends Hoagie {

    String[] veggiesUsed = {"G","H","I","j"};
    String[] condimentUsed = {"oil","vinegar","L"};


    @Override
    protected void addCondiments() {
        System.out.print("Adding condiment ");
        for(String condi : condimentUsed){
            System.out.print(condi + " ");
        }
    }

    @Override
    protected void addVegetables() {
        System.out.print("Adding egetables ");
        for(String vegetable : veggiesUsed){
            System.out.print(vegetable + " ");
        }
    }

    @Override
    protected void addCheese() {

    }

    @Override
    void addMeat() {

    }

    private boolean customerWantsCheese() {
        return false;
    }
    boolean customerWantsMeat(){
        return false;
    }
}
