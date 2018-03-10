package coursera.module3.week4.test;

import coursera.common.FileIO;
import coursera.common.model.Knapsack.Knapsack;
import coursera.module3.week4.KnapsackProblem;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class KnapsackProblemTest {

    private FileIO fileIO;

    private Knapsack knapsack;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    @Test
    public void testCalculateMaxValueOfKnapsackWithCapacity4NumItems4() {
        String filename = "src/coursera/module3/week4/test/testFiles/Capacity4NumItems4.txt";

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        assertEquals(4, KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
    }

    @Test
    public void testCalculateMaxValueOfKnapsackWithCapacity10NumItems10() {
        String filename = "src/coursera/module3/week4/test/testFiles/Capacity10NumItems10.txt";

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        assertEquals(14, KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
    }

    @Test
    public void testCalculateMaxValueOfKnapsackWithCapacity100NumItems100() {
        String filename = "src/coursera/module3/week4/test/testFiles/Capacity100NumItems100.txt";

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        assertEquals(478, KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
    }

    @Test
    public void testCalculateMaxValueOfKnapsackWithCapacity1000NumItems1000() {
        String filename = "src/coursera/module3/week4/test/testFiles/Capacity1000NumItems1000.txt";

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            fail(e.getMessage());
        }

        assertEquals(18604, KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
    }
}
