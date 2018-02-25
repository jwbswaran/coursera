package coursera.module3.week1.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import coursera.common.FileIO;
import coursera.common.model.Job;
import coursera.module3.week1.GreedyScheduling;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class GreedySchedulingTest {

    private FileIO fileIO;

    private GreedyScheduling greedyScheduling;

    @Before
    public void setup() {
        this.greedyScheduling = new GreedyScheduling();
        fileIO = new FileIO();
    }

    @Test
    public void testDifferenceGreedySchedulingWithTestRandom1040() {
        String fileName = "src\\coursera\\module3\\week1\\test\\testFiles\\input_random_10_40.txt";
        Job[] jobArr = null;

        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        greedyScheduling.setJobArr(jobArr);
        long completionTimeSum = greedyScheduling.differenceScheduling();
        assertEquals(1175612, completionTimeSum);
    }

    @Test
    public void testRatioGreedySchedulingWithTestRandom1040() {
        String fileName = "src\\coursera\\module3\\week1\\test\\testFiles\\input_random_10_40.txt";
        Job[] jobArr = null;

        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        greedyScheduling.setJobArr(jobArr);
        long completionTimeSum = greedyScheduling.ratioScheduling();
        assertEquals(1142691, completionTimeSum);
    }

    @Test
    public void testDifferenceGreedySchedulingWithTestRandomR10() {
        String fileName = "src\\coursera\\module3\\week1\\test\\testFiles\\input_random_r_10.txt";
        Job[] jobArr = null;

        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        greedyScheduling.setJobArr(jobArr);
        long completionTimeSum = greedyScheduling.differenceScheduling();
        assertEquals(104913, completionTimeSum);
    }

    @Test
    public void testRatioGreedySchedulingWithTestRandomR10() {
        String fileName = "src\\coursera\\module3\\week1\\test\\testFiles\\input_random_r_10.txt";
        Job[] jobArr = null;

        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        greedyScheduling.setJobArr(jobArr);
        long completionTimeSum = greedyScheduling.ratioScheduling();
        assertEquals(104255, completionTimeSum);
    }

    @Test
    public void testDifferenceGreedySchedulingWithTestRandom21320() {
        String fileName = "src\\coursera\\module3\\week1\\test\\testFiles\\input_random_21_320.txt";
        Job[] jobArr = null;

        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        greedyScheduling.setJobArr(jobArr);
        long completionTimeSum = greedyScheduling.differenceScheduling();
        assertEquals(64603342, completionTimeSum);
    }
}
