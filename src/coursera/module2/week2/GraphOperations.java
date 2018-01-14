package coursera.module2.week2;

import coursera.common.FileIO;
import coursera.common.datastructures.AdjacencyList;

/** Computes or runs operations common to graphs.  Currently includes computing the shortest path of a graph using
 * Dijkstra's algorithm.
 */
public class GraphOperations {
    public GraphOperations() {

    }

    public static void main(String args[]) {
        AdjacencyList adjacencyList;
        FileIO fileIO = new FileIO();
        String fileName = "C:\\dev\\coursera\\input-files\\module2\\week2\\smallTest.txt";
        adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromFile(fileName);

        System.out.println(adjacencyList);
    }
}