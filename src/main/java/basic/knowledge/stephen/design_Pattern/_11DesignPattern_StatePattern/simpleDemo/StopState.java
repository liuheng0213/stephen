package basic.knowledge.stephen.design_Pattern._11DesignPattern_StatePattern.simpleDemo;

public class StopState implements State{
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);

    }

    @Override
    public String toString() {
        return "Stop State";
    }

}
