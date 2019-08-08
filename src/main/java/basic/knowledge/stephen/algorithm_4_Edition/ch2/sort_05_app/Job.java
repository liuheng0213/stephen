package basic.knowledge.stephen.algorithm_4_Edition.ch2.sort_05_app;

public class Job implements Comparable<Job> {
    private String name;
    private Double time;

    public Job(String name, Double time) {
        this.name = name;
        this.time = time;
    }

    public Job() {
    }


    @Override
    public int compareTo(Job that) {
        return this.time.compareTo(that.time);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", time=" + time +
                '}';
    }
}
