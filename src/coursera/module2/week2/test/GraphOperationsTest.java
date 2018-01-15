package coursera.module2.test;

import static org.junit.Assert.assertEquals;

import coursera.common.FileIO;
import coursera.common.datastructures.AdjacencyList;
import coursera.module2.week2.GraphOperations;

import org.junit.Test;
import org.junit.Before;


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

        String fileName = "src/coursera/module2/test/testFiles/smallest.txt";
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
        String fileName = "src/coursera/module2/test/testFiles/smaller.txt";
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
}
