package coursera.common.test.FileIO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import coursera.common.FileIO;
import coursera.common.datastructures.Job;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileIOTest {

    FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    /* test getIntegerArrFromFile */
    @Test
    public void GetIntegerArrFromFileThrowsIOException() {
        try {
            int[] arr = fileIO.getIntegerArrFromFile("dud.txt");
        } catch(IOException e) {
            assertEquals("Error opening dud.txt", e.getMessage());
        }
    }

    @Test
    public void testGetIntegerArrFromFileWithEmptyFile() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        int[] emptyArr = null;
        try {
            emptyArr = fileIO.getIntegerArrFromFile(emptyFilename);
        } catch(IOException e) {

        }
        assertNotNull("array under test in testGetArrayFromFileWithEmptyInput is null", emptyArr);
        assertEquals(0, emptyArr.length);
    }

    @Test
    public void testGetIntegerArrFromFileWithSingleElement() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\singleElement.txt";
        int[] emptyArr = null;
        try {
            emptyArr = fileIO.getIntegerArrFromFile(emptyFilename);
        } catch(IOException e) {

        }
        assertNotNull("array under test in testGetArrayFromFileWithSingleElement is null", emptyArr);
        assertEquals(1, emptyArr.length);
        assertEquals(-1, emptyArr[0]);
    }

    @Test
    public void testGetIntegerArrFromFileWithFiveElements() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\fiveElement.txt";
        int[] emptyArr = null;
        try {
            emptyArr = fileIO.getIntegerArrFromFile(emptyFilename);
        } catch(IOException e) {

        }
        assertNotNull("array under test in testGetArrayFromFileWithFiveElements is null", emptyArr);
        assertEquals(5, emptyArr.length);
        assertEquals(-1, emptyArr[0]);
        assertEquals(0, emptyArr[1]);
        assertEquals(1, emptyArr[2]);
        assertEquals(2, emptyArr[3]);
        assertEquals(2147483647, emptyArr[4]);
    }

    /* test getLongArrFromFile */
    @Test
    public void GetLongArrFromFileThrowsIOException() {
        try {
            long[] arr = fileIO.getLongArrFromFile("dud.txt");
        } catch(IOException e) {
            assertEquals("Error opening dud.txt", e.getMessage());
        }
    }

    @Test
    public void testGetLongArrFromFileWithEmptyFile() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        long[] emptyArr = null;
        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }
        assertNotNull("array under test in testGetArrayFromFileWithEmptyInput is null", emptyArr);
        assertEquals(0, emptyArr.length);
    }

    @Test
    public void testGetLongArrFromFileWithSingleElement() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\singleLong.txt";
        long[] emptyArr = null;

        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }

        assertNotNull("array under test in testGetArrayFromFileWithSingleElement is null", emptyArr);
        assertEquals(1, emptyArr.length);
        assertEquals(68037543430L, emptyArr[0]);
    }

    @Test
    public void testGetLongArrFromFileWithFiveElements() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\fiveLong.txt";
        long[] emptyArr = null;
        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }
        assertNotNull("array under test in testGetArrayFromFileWithFiveElements is null", emptyArr);
        assertEquals(5, emptyArr.length);
        assertEquals(68037543430L, emptyArr[0]);
        assertEquals(68037543431L, emptyArr[1]);
        assertEquals(68037543432L, emptyArr[2]);
        assertEquals(68037543433L, emptyArr[3]);
        assertEquals(68037543434L, emptyArr[4]);
    }

    @Test
    public void testGetJobArrFromFileWithEmptyFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);
        assertEquals(jobArr.length, 0);
    }

    @Test
    public void testGetJobArrFromFileWithSingleJob() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\singleJob.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);
        assertEquals(jobArr[0].getWeight(), 8);
        assertEquals(jobArr[0].getLength(), 50);
    }

    @Test
    public void testGetJobArrFromFileWithTwoJobs() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\twoJob.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);

        assertEquals(jobArr[0].getWeight(), 8);
        assertEquals(jobArr[0].getLength(), 50);

        assertEquals(jobArr[1].getWeight(), 9);
        assertEquals(jobArr[1].getLength(), 40);
    }
}
