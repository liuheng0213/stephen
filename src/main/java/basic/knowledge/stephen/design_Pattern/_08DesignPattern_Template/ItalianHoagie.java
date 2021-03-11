package basic.knowledge.stephen.design_Pattern._08DesignPattern_Template;

public class ItalianHoagie extends Hoagie{
   String[] meatUsed = {"A","B","C"};
   String[] cheeseUsed = {"CHEESE"};
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
        System.out.print("Adding cheese ");
        for(String cheese : cheeseUsed){
            System.out.print(cheese + " ");
        }
    }

    @Override
    void addMeat() {
        System.out.print("Adding meat ");
        for(String meat : meatUsed){
            System.out.print(meat + " ");
        }
    }
}
