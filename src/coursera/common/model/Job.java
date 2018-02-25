package coursera.common.model;

/**
 * Represents a job that needs to be scheduled, simple POJO
 */
public class Job {
    private int weight;
    private int length;

    /**
     * Constructor for the job class
     * @param weight weight of the job to be scheduled, this indicates the importance of this specific job instance
     * @param length the length of time units required to complete a job
     */
    public Job(int weight, int length) {
        this.weight = weight;
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
