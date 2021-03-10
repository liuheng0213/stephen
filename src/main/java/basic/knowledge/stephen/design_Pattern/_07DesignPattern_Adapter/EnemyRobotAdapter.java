package basic.knowledge.stephen.design_Pattern._07DesignPattern_Adapter;

//adapter
public class EnemyRobotAdapter implements EnemyAttacker{
    EnemyRobot theRobot;

    public EnemyRobotAdapter(EnemyRobot theRobot) {
        this.theRobot = theRobot;
    }


    @Override
    public void fireWeapon() {
        theRobot.smashWithHands();
    }

    @Override
    public void driveForward() {
        theRobot.walkForward();
    }

    @Override
    public void assignDriver(String driveName) {
        theRobot.reactToHuman(driveName);
    }
}
