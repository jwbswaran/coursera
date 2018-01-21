package coursera.common.test.FileIO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;

import coursera.common.FileIO;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class FileIOTest {

    FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

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
        assertNotNull("array under test in testGetArrayFromFileWithEmptyInput is null", emptyArr);
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
        assertNotNull("array under test in testGetArrayFromFileWithEmptyInput is null", emptyArr);
        assertEquals(5, emptyArr.length);
        assertEquals(-1, emptyArr[0]);
        assertEquals(0, emptyArr[1]);
        assertEquals(1, emptyArr[2]);
        assertEquals(2, emptyArr[3]);
        assertEquals(2147483647, emptyArr[4]);
    }
}
