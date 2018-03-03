package coursera.module3.week3.test.weightedIndependentSet;

import coursera.common.FileIO;
import coursera.common.model.WeightedObject;
import coursera.module3.week3.IndependentSet;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.Assert.fail;
import static org.junit.Assert.assertEquals;

public class IndependentSetTest {

    private static final int[] SPECIFIED_INDICES = {1, 2, 3, 4, 17, 117, 517, 997};

    private IndependentSet is;

    private FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    @Test
    public void testGetStringRepresentationForSpecifiedIndicesWithTest1() {
        String fileName = "src/coursera/module3/week3/test/weightedIndependentSet/Test1.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        is = new IndependentSet(arr);

        is.calculateMaximumWeightedIndependentSets();

        assertEquals("10100000", is.getStringRepresentationForSpecifiedIndices(SPECIFIED_INDICES));
    }

    @Test
    public void testGetStringRepresentationForSpecifiedIndicesWithTest2() {
        String fileName = "src/coursera/module3/week3/test/weightedIndependentSet/Test2.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        is = new IndependentSet(arr);

        is.calculateMaximumWeightedIndependentSets();

        assertEquals("10010000", is.getStringRepresentationForSpecifiedIndices(SPECIFIED_INDICES));
    }

    @Test
    public void testGetStringRepresentationForSpecifiedIndicesWithTest3() {
        String fileName = "src/coursera/module3/week3/test/weightedIndependentSet/Test3.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        is = new IndependentSet(arr);

        is.calculateMaximumWeightedIndependentSets();

        assertEquals("10011000", is.getStringRepresentationForSpecifiedIndices(SPECIFIED_INDICES));
    }
}
