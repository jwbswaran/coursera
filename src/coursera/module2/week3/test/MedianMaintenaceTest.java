package coursera.module2.week3.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import coursera.common.FileIO;
import coursera.module2.week3.MedianMaintenance;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MedianMaintenaceTest {

    private MedianMaintenance medianMaintenance;

    private FileIO fileIO;

    @Before
    public void setup() {
        medianMaintenance = new MedianMaintenance();
        fileIO = new FileIO();
    }

    @Test
    public void testMedianMaintenanceWithTest1File() {
        String fileName = "src\\coursera\\module2\\week3\\test\\testFiles\\test1.txt";
        int testArr[], medianSum;
        int expectedValue = 142;

        try {
            testArr = fileIO.getIntegerArrFromFile(fileName);
            medianSum = medianMaintenance.computeSumOfMediansMod10000(testArr);
            assertEquals(expectedValue, medianSum);
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMedianMaintenanceWithTest2File() {
        String fileName = "src\\coursera\\module2\\week3\\test\\testFiles\\test2.txt";
        int testArr[], medianSum;
        int expectedValue = 9335;

        try {
            testArr = fileIO.getIntegerArrFromFile(fileName);
            medianSum = medianMaintenance.computeSumOfMediansMod10000(testArr);
            assertEquals(expectedValue, medianSum);
        } catch(IOException e) {
            fail(e.getMessage());
        }
    }
}
