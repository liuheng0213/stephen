package basic.knowledge.stephen.design_Pattern._11DesignPattern_StatePattern.scenario_lift;

public class Context {
    //定义出所有的电梯状态
    public final static OpenningState openningState = new OpenningState(); // == 1 2 3 4 会有大量if判断
    public final static ClosingState closeingState = new ClosingState();
    public final static RunningState runningState = new RunningState();
    public final static StoppingState stoppingState = new StoppingState();
    //定一个当前电梯状态
    private LiftState liftState;
    public LiftState getLiftState() {
        return liftState;
    }
    public void setLiftState(LiftState liftState) {
        this.liftState = liftState;
        //把当前的环境通知到各个实现类中
        this.liftState.setContext(this);
    }
    public void open(){
        this.liftState.open();
    }
    public void close(){
        this.liftState.close();
    }
    public void run(){
        this.liftState.run();
    }
    public void stop(){
        this.liftState.stop();
    }

}
