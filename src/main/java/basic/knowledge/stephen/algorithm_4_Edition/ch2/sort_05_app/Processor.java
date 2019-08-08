package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

import java.util.ArrayList;
import java.util.List;

public class Processor implements Comparable<Processor> {
    private List<Job> jobs;
    private Double totalTime;
    public Processor() {
        this.jobs = new ArrayList<>();
        this.totalTime = 0d;
    }

    @Override
    public int compareTo(Processor that) {
        return this.totalTime.compareTo(that.totalTime);
    }

    public void insert(Job job){
        jobs.add(job);
        totalTime += job.getTime();
    }

    @Override
    public String toString() {
        return "Processor{" +
                "jobs=" + jobs +
                ", totalTime=" + totalTime +
                '}';
    }
}
