package basic.knowledge.stephen.javaCollections.delayQueue;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        DelayQueue<DelayTask> queue = new DelayQueue<>();
        queue.add(new DelayTask("1", new Date()));
        queue.add(new DelayTask("2", new Date(System.currentTimeMillis() + 5000)));
        queue.add(new DelayTask("3", new Date(System.currentTimeMillis() + 10000)));

        System.out.println("queue put done");

        while (!queue.isEmpty()) {
            try {
                DelayTask task = queue.take();
                System.out.println(task.name + ":" + System.currentTimeMillis());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DelayTask implements Delayed {
        private String name;

        private Date taskTime;


        public DelayTask(String name, Date taskTime) {
            this.name = name;
            this.taskTime = taskTime;
        }

        @Override
        public int compareTo(Delayed o) {
            DelayTask delayTask = (DelayTask) o;
            long diff = taskTime.getTime() - delayTask.getTaskTime().getTime();
            if (diff > 0) {
                return 1;
            } else if (diff == 0) {
                return 0;
            } else {
                return -1;
            }
        }

        // 延迟任务是否到时就是按照这个方法判断如果返回的是负数则说明到期否则还没到期  到期才打印
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(taskTime.getTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getTaskTime() {
            return taskTime;
        }

        public void setTaskTime(Date taskTime) {
            this.taskTime = taskTime;
        }
    }
}
