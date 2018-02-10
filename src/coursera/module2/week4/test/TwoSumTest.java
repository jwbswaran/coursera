package coursera.module2.week4.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import coursera.common.FileIO;
import coursera.module2.week4.TwoSum;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class TwoSumTest {
    private static final String TEST_ONE_FILE_PATH = "src\\coursera\\module2\\week4\\test\\testFiles\\test1.txt";
    private static final String TEST_TWO_FILE_PATH = "src\\coursera\\module2\\week4\\test\\testFiles\\test2.txt";

    TwoSum twoSum;

    FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    /* Test the doesTwoSumExist method with the test1.txt file */
    @Test
    public void twoSumExistsTestFalseWithTest1() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_ONE_FILE_PATH);
            twoSum = new TwoSum(arr);
            assertEquals(false, twoSum.doesTwoSumExist(9));
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void TtwoSumExistsTestTrueWithTest1() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_ONE_FILE_PATH);
            twoSum = new TwoSum(arr);
            assertEquals(true, twoSum.doesTwoSumExist(4));
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    /* Test the doesTwoSumExist method with the test2.txt file */
    @Test
    public void twoSumExistsTestFalseWithTest2() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_TWO_FILE_PATH);
            twoSum = new TwoSum(arr);
            assertEquals(false, twoSum.doesTwoSumExist(100));
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    /* Test the doesTwoSumExist method with the test2.txt file */
    @Test
    public void twoSumExistsTestTrueWithTest2() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_TWO_FILE_PATH);
            twoSum = new TwoSum(arr);
            assertEquals(false, twoSum.doesTwoSumExist(-3));
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    /* Test the twoSumRange method with test1.txt file */
    @Test
    public void testNumSumsWithTest1() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_ONE_FILE_PATH);
            twoSum = new TwoSum(arr);
            int expectedNumSums = 3;
            int numSums = twoSum.testTwoSumRange(-7, 7);
            assertEquals(expectedNumSums, numSums);
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    /* Test the twoSumRange method with test2.txt file */
    @Test
    public void testNumSumsWithTest2() {
        try {
            long[] arr = fileIO.getLongArrFromFile(TEST_TWO_FILE_PATH);
            twoSum = new TwoSum(arr);
            int expectedNumSums = 8;
            int numSums = twoSum.testTwoSumRange(3, 10);
            assertEquals(expectedNumSums, numSums);
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }
}
