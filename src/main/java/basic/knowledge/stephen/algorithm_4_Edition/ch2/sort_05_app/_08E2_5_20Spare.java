package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 能够并行处理N个任务的计算机
 * 一系列任务
 * 找到最长空闲时间和最长繁忙时间
 */
public class _08E2_5_20Spare {
    private static class JobEvent implements Comparable<JobEvent> {
        String jobName;
        int time;
        boolean isFinished;

        public JobEvent(String jobName, int time, boolean isFinished) {
            this.jobName = jobName;
            this.time = time;
            this.isFinished = isFinished;
        }


        @Override
        public int compareTo(JobEvent that) {
            return this.time - that.time;
        }
    }

    private static class IdleBusy {
        int maxIdle;
        int maxBusy;

        public IdleBusy(int maxIdle, int maxBusy) {
            this.maxIdle = maxIdle;
            this.maxBusy = maxBusy;
        }

        @Override
        public String toString() {
            return "IdleBusy{" +
                    "maxIdle=" + maxIdle +
                    ", maxBusy=" + maxBusy +
                    '}';
        }
    }


    public static void main(String[] args) {
        ArrayList<JobEvent> jobEvents = new ArrayList<>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readLine();
            String[] split = s.split("[\\:.]");
            if (split.length > 5)
                return;
            for (int i = 0; i < split.length; i++) {

                JobEvent jobEvent1 = new JobEvent(split[i].trim(),
                        Integer.valueOf(split[i + 1].trim()) * 60 + Integer.valueOf(split[i + 2].trim()), false);
                JobEvent jobEvent2 = new JobEvent(split[i].trim(),
                        Integer.valueOf(split[i + 3].trim()) * 60 + Integer.valueOf(split[i + 4].trim()), true);

                jobEvents.add(jobEvent1);
                jobEvents.add(jobEvent2);
            }
        }

        Collections.sort(jobEvents);

        IdleBusy maxIdleAndBusy = calcByMaxConcurrency(4, jobEvents);
        System.out.println(maxIdleAndBusy);
    }

    private static IdleBusy calcByMaxConcurrency(int maxConcurrencyNum, List<JobEvent> jobEventList) {
        int maxIdle = 0;
        int maxBusy = 0;
        int runningCount = 0;  //描述当前并行任务的数量

        int idleStart = 0;
        int busyStart = 0;
        for (int i = 0; i < jobEventList.size(); i++) {
            //启动,jobEvent是开始事件
            if (!jobEventList.get(i).isFinished) {
                if (runningCount == 0) {
                    int idle = jobEventList.get(i).time - idleStart;//idle是一个持续时间
                    if (maxIdle < idle) {
                        maxIdle = idle;
                    }
                    //busy start
                    busyStart = jobEventList.get(i).time;
                }
                runningCount++;
            }
            //完成,jobEvent是结束事件
            else {
                runningCount--;
                if (runningCount == 0) {
                    int busy = jobEventList.get(i).time - busyStart;
                    if (busy > maxBusy) {
                        maxBusy = busy;
                    }
                    //idle start
                    idleStart = jobEventList.get(i).time;
                }
            }
        }
        return new IdleBusy(maxIdle, maxBusy);
    }

}
