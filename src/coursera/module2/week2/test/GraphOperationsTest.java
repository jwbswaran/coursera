package coursera.module2.week2.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import coursera.common.FileIO;
import coursera.common.datastructures.AdjacencyList;
import coursera.module2.week2.GraphOperations;

import org.junit.Test;
import org.junit.Before;

import java.io.IOException;


public class GraphOperationsTest {

    private GraphOperations graphOperations;

    FileIO fileIO;

    @Before
    public void setup() {
        graphOperations = new GraphOperations();
        fileIO = new FileIO();
    }

    @Test
    public void testSmallest() {
        AdjacencyList adjacencyList;
        GraphOperations graphOperations = new GraphOperations();

        String fileName = "src/coursera/module2/week2/test/testFiles/smallest.txt";
        adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromFile(fileName);
        int[] a = graphOperations.calculateShortestPathsUsingDijkstra(adjacencyList, 1);

        assertEquals(a[0], 0);
        assertEquals(a[1], 1);
        assertEquals(a[2], 3);
        assertEquals(a[3], 6);
    }

    @Test
    public void testSmaller() {
        AdjacencyList adjacencyList;
        GraphOperations graphOperations = new GraphOperations();
        String fileName = "src/coursera/module2/week2/test/testFiles/smaller.txt";
        adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromFile(fileName);
        int[] a = graphOperations.calculateShortestPathsUsingDijkstra(adjacencyList, 1);

        assertEquals(a[0], 0);
        assertEquals(a[1], 1);
        assertEquals(a[2], 2);
        assertEquals(a[3], 3);
        assertEquals(a[4], 4);
        assertEquals(a[5], 4);
        assertEquals(a[6], 3);
        assertEquals(a[7], 2);
    }

    @Test
    public void testPrimsOnInputRandom310() {
        AdjacencyList adjacencyList = null;
        GraphOperations graphOperations = new GraphOperations();
        String fileName = "src\\coursera\\module2\\week2\\test\\testFiles\\prims\\input_random_3_10.txt";

        try {
            adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromEdgeFile(fileName);
            System.out.println(adjacencyList.toString());
        } catch (IOException e) {
            fail();
        }

        assertNotNull(adjacencyList);
        long minCost = graphOperations.getCostOfMinimumSpanningTree(adjacencyList, 1);
        assertEquals(-12572, minCost);
    }

    @Test
    public void testPrimsOnInputRandom1040() {
        AdjacencyList adjacencyList = null;
        GraphOperations graphOperations = new GraphOperations();
        String fileName = "src\\coursera\\module2\\week2\\test\\testFiles\\prims\\input_random_10_40.txt";

        try {
            adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromEdgeFile(fileName);
            System.out.println(adjacencyList.toString());
        } catch (IOException e) {
            fail();
        }

        assertNotNull(adjacencyList);
        long minCost = graphOperations.getCostOfMinimumSpanningTree(adjacencyList, 1);
        assertEquals(-97121, minCost);
    }
}
