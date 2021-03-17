package basic.knowledge.stephen.design_Pattern._11DesignPattern_StatePattern.simpleDemo;

public class Demo {

    public static void main(String[] args) {
        Context context = new Context();

        State startState = new StartState();
        startState.doAction(context);

        System.out.println(context.getState().toString());

        State stopState = new StopState();
        stopState.doAction(context);

        System.out.println(context.getState().toString());
    }

}
