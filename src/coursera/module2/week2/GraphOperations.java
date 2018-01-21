package coursera.module2.week2;

import coursera.common.FileIO;
import coursera.common.datastructures.AdjacencyList;
import coursera.common.datastructures.vertices.Edge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/** Computes or runs operations common to graphs.  Currently includes computing the shortest path of a graph using
 * Dijkstra's algorithm.
 */
public class GraphOperations {

    /* denotes a vertex unreachable from the source vertex in dijkstra's algorithm */
    private static final int NO_PATH_BETWEEN_SOURCE_AND_VERTEX = 1000000;

    public GraphOperations() {

    }

    /**
     * Calculates the shortestPath from the source vertex to the rest of the graph if such a path exists.  Uses
     * Dijkstra's algorithm to accomplish this.
     * @param adjacencyList the graph to perform djikstra's algorithm on
     * @param sourceVertexIdentifier the identifier of the vertex where the graph should start
     * @return an array of calculated shortest paths
     */
    public int[] calculateShortestPathsUsingDijkstra(AdjacencyList adjacencyList, int sourceVertexIdentifier) {
        /* shortest paths array to return to the caller */
        int[] shortestPaths = new int[adjacencyList.getNumVertices()];


        /*
         * The set of vertices that have fully calculated shortest paths.
         */
        HashSet<Integer> x = new HashSet<>();

        /* The frontier is the vertices that are on the border betweenthe set of vertices x and the vertices
         * we have yet to calculate the shortest distance from.
         */
        HashSet<Integer> frontier = new HashSet<>();

        /*
         * book keeping list of edges that are used to keep track of edges on the vertices on the frontier.
         */
        LinkedList<Edge> frontierEdges;

        /*
         * book keeping list of edges for the vertex that is about to be absorbed into X.
         */
        LinkedList<Edge> vertexToAbsorbEdges;

        /* variables used for book keeping */
        int frontierVertex, minDijkstraScore, dijkstraScore, minDijkstraVertexIdentifier = sourceVertexIdentifier;
        Edge absorbEdge, tailEdge;
        Iterator<Integer> frontierIterator;
        Iterator<Edge> vertexToAbsorbEdgesIterator, tailEdgesIterator;

        /* Initialize shortestPaths to NO_PATH_BETWEEN_SOURCE_AND_VERTEX so any vertices with no path are covered,
           but initialize the sourceVertexIdentifier's value to 0;
         */
        for(int i = 0, len = shortestPaths.length; i < len; i++) {
            shortestPaths[i] = NO_PATH_BETWEEN_SOURCE_AND_VERTEX;
        }

        shortestPaths[sourceVertexIdentifier - 1] = 0;

        /* add source vertex to the frontier to explore*/
        frontier.add(sourceVertexIdentifier);
        x.add(sourceVertexIdentifier);

        /* Iterate until all vertices are in the set X */
        while (x.size() < shortestPaths.length) {
            minDijkstraScore = Integer.MAX_VALUE;
            frontierIterator = frontier.iterator();

            /* This section of code calculates the Dijkstra's greedy score for the vertices in the frontier */
            while (frontierIterator.hasNext()) {
                frontierVertex = frontierIterator.next();
                frontierEdges = adjacencyList.getVertex(frontierVertex).getEdges();
                if (frontierEdges.size() == 0) {
                    frontierIterator.remove();
                } else {

                    for (Edge edge : frontierEdges) {
                        dijkstraScore = shortestPaths[edge.getHead() - 1] + edge.getWeight();

                        if (dijkstraScore < minDijkstraScore) {
                            minDijkstraScore = dijkstraScore;
                            minDijkstraVertexIdentifier = edge.getTail();
                        }
                    }
                }
            }

            shortestPaths[minDijkstraVertexIdentifier - 1] = minDijkstraScore;
            vertexToAbsorbEdges = adjacencyList.getVertex(minDijkstraVertexIdentifier).getEdges();
            x.add(minDijkstraVertexIdentifier);

            vertexToAbsorbEdgesIterator = vertexToAbsorbEdges.iterator();

            /* This while loop removes the edges from the graph that point from the vertex with the minimum Dijkstra
             * score and vertices that are already in X. We do not want to check these for future shortest paths,
             * as we have already calculated their shortest paths
             */
            while(vertexToAbsorbEdgesIterator.hasNext()) {
                absorbEdge = vertexToAbsorbEdgesIterator.next();

                if (x.contains(absorbEdge .getTail())) {
                    LinkedList<Edge> tailEdges = adjacencyList.getVertex(absorbEdge .getTail()).getEdges();

                    tailEdgesIterator = tailEdges.iterator();

                    while(tailEdgesIterator.hasNext()) {
                        tailEdge = tailEdgesIterator.next();

                        if (tailEdge.getTail() == minDijkstraVertexIdentifier) {
                            tailEdgesIterator.remove();
                        }
                    }

                    vertexToAbsorbEdgesIterator.remove();
                }
            }

            frontier.add(minDijkstraVertexIdentifier);
        }
        return shortestPaths;
    }

    /**
     * Execute this main method to run dijkstra's algorithm on the dijkstraData.txt file.
     * @param args command line args
     */
    public static void main(String args[]) {
        AdjacencyList adjacencyList;
        FileIO fileIO = new FileIO();
        GraphOperations graphOperations = new GraphOperations();
        String fileName = "src\\coursera\\common\\input-files\\module2\\week2\\dijkstraData.txt";
        adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromFile(fileName);

        int[] a = graphOperations.calculateShortestPathsUsingDijkstra(adjacencyList, 1);

        System.out.print(a[6] + ",");
        System.out.print(a[36] + ",");
        System.out.print(a[58] + ",");
        System.out.print(a[81] + ",");
        System.out.print(a[98] + ",");
        System.out.print(a[114] + ",");
        System.out.print(a[132] + ",");
        System.out.print(a[164] + ",");
        System.out.print(a[187] + ",");
        System.out.print(a[196]);
        System.out.println();
    }
}