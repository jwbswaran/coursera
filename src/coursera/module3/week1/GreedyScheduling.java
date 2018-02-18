package coursera.module3.week1;

import coursera.common.FileIO;
import coursera.common.datastructures.Job;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * A class that performs various greedy scheduling algorithms on an array of Job elements
 */
public class GreedyScheduling {

    /**
     * Comparator used for difference scheduling.  This is needed because if two jobs have the same difference
     * between their weight and length, we want to consider the job out of the two with the higher weight to be
     * smaller than the one with the lower weight.
     */
    private class DifferenceComparator implements Comparator<Job> {
        public int compare(Job x, Job y) {
            int xWeight = x.getWeight();
            int yWeight = y.getWeight();

            int xDiff = xWeight - x.getLength();
            int yDiff = yWeight - y.getLength();

            if (xDiff == yDiff) {
                return yWeight - xWeight;
            }
            return yDiff - xDiff;
        }
    }

    /**
     * Comparator used for ratio scheduling.
     */
    public class RatioComparator implements Comparator<Job> {
        public int compare (Job x, Job y) {
            int xWeight = x.getWeight();
            int yWeight = y.getWeight();

            double xRatio = (double)xWeight / x.getLength();
            double yRatio = (double)yWeight / y.getLength();

            return Double.compare(yRatio, xRatio);
        }
    }

    /**
     * Array of job elements to perform scheduling on
     */
    private Job[] jobArr;

    /**
     * Default Constructor
     */
    public GreedyScheduling() {

    }


    /**
     * Constructor for the GreedyScheduling class
     * @param jobArr array of job objects to perform greedy scheduling on
     */
    public GreedyScheduling(Job[] jobArr) {
        this.jobArr = jobArr;
    }

    /**
     * Greedy schedule calculated using decreasing order of differences between the weight and length
     * @return minWeightedSum the weighted greedy schedule calculated
     */
    public long differenceScheduling() {
        long minWeightedSum = 0;
        long completionTimeSum = 0;

        if (jobArr != null ) {
            Job job;
            Arrays.sort(jobArr, new DifferenceComparator());

            for (int i = 0, len = jobArr.length; i < len; i++) {
                job = jobArr[i];
                completionTimeSum += job.getLength();
                minWeightedSum += completionTimeSum * job.getWeight();
            }
        }

        return minWeightedSum;
    }

    /**]
     * Greedy schedule calculated using decreasing order of ratios of weight to length
     * @return minWeightedSum the weighted greedy schedule calculated
     */
    public long ratioScheduling() {
        long minWeightedSum = 0;
        long completionTimeSum = 0;

        if (jobArr != null ) {
            Job job;
            Arrays.sort(jobArr, new RatioComparator());

            for (int i = 0, len = jobArr.length; i < len; i++) {
                job = jobArr[i];
                completionTimeSum += job.getLength();
                minWeightedSum += completionTimeSum * job.getWeight();
            }
        }

        return minWeightedSum;
    }

    public Job[] getJobArr() {
        return jobArr;
    }

    public void setJobArr(Job[] jobArr) {
        this.jobArr = jobArr;
    }

    public static void main(String[] args) {
        String fileName = "src\\coursera\\common\\input-files\\module3\\week1\\jobs.txt";
        FileIO fileIO = new FileIO();

        try {
            Job[] jobArr = fileIO.getJobArrFromFile(fileName);
            GreedyScheduling greedyScheduling = new GreedyScheduling(jobArr);
            System.out.println("Min schedule calculated by difference scheduling: " + greedyScheduling.differenceScheduling());
            System.out.println("Min schedule calculated by ratio scheduling: " + greedyScheduling.ratioScheduling());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
