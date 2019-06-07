package basic.knowledge.stephen.ThreadRelevant._02TimerAndTimerTask;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimerTask {

    public static void main(String args[]) {
        new Reminder(3);
        System.out.println("About to schedule task.");//main tread
        System.out.println("Task scheduled.");//main thread
    }

    public static class Reminder {
        Timer timer;

        public Reminder(int sec) {
            timer = new Timer();        //主线程外开启的新的线程
            timer.schedule(new TimerTask() {
                public void run() {
                    System.out.println("Time's up!");
                    timer.cancel();
                }
            }, sec * 1000);
        }
    }


}