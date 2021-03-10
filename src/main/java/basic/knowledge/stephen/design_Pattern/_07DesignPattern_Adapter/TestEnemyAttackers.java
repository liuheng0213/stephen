package basic.knowledge.stephen.design_Pattern._07DesignPattern_Adapter;

public class TestEnemyAttackers {
    public static void main(String[] args) {
        EnemyTank rx7Tank = new EnemyTank();
        EnemyRobot fredTheRobot = new EnemyRobot();
        EnemyRobotAdapter robotAdapter = new EnemyRobotAdapter(fredTheRobot);

        System.out.println("The Robot");
        fredTheRobot.reactToHuman("Paul");
        fredTheRobot.walkForward();
        fredTheRobot.smashWithHands();

        System.out.println("===================");

        System.out.println("The Enemy Tank ");
        rx7Tank.assignDriver("Frank");
        rx7Tank.driveForward();
        rx7Tank.fireWeapon();

        System.out.println("===================");

        System.out.println("The Robot whith Adapter  ");
        robotAdapter.assignDriver("Mark");
        robotAdapter.driveForward();
        robotAdapter.fireWeapon();
    }
}
