package basic.knowledge.stephen.design_Pattern._08DesignPattern_Template;

public abstract class Hoagie {

    boolean afterFirstCondiment = false;


    final void makeSancwich(){
        cutBun();

        if(customerWantsMeat()){
            addMeat();

            afterFirstCondiment = true;
        }

        if(customerWantsCheese()){
            if(afterFirstCondiment){
                System.out.print("\n");
            }
            addCheese();
            afterFirstCondiment = true;
        }
        if(customerWantsVegetables()){
            if(afterFirstCondiment){
                System.out.print("\n");
            }
            addVegetables();
            afterFirstCondiment = true;
        }
        if(customerWantsCondiments()){
            if(afterFirstCondiment){
                System.out.print("\n");
            }
            addCondiments();
            afterFirstCondiment = true;
        }
        wrapTheHoagie();
    }


    private void wrapTheHoagie() {
        System.out.println("wrap the hoagie");
    }

    private void cutBun() {
        System.out.println(" the hoagie is cut");
    }

    protected abstract void addCondiments();

    private boolean customerWantsCondiments() {
        return true;
    }

    protected abstract void addVegetables();

    private boolean customerWantsVegetables() {
        return true;
    }

    protected abstract void addCheese();

    private boolean customerWantsCheese() {
        return true;
    }

    abstract void addMeat();

    boolean customerWantsMeat(){
        return true;
    }
}
