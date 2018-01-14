package coursera.common;

import coursera.common.datastructures.vertices.Edge;
import coursera.common.datastructures.vertices.Vertex;
import coursera.common.datastructures.AdjacencyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

/**
 * This class exists to read input files for the programming assignments for the Stanford Algorithms course
 * hosted by Coursera.  The goal of the class is to prevent duplication of reading files into data structures
 * for the programming assignments when possible.
 */
public class FileIO {

    /**
     * Reads a file formatted with the first item in a row being the identifier for the vertex, followed by tuples
     * with the edge and weight for each edge as the rest of the items in the row.
     * @param fileName path to the file that needs to be read from
     * @return AdjacencyList representation of the graph in the file
     */
    public AdjacencyList getWeightedUndirectedAdjacencyListFromFile(String fileName) {
        AdjacencyList adjacencyList = new AdjacencyList();
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
            /* List of edges to attach to a vertex */
            LinkedList<Edge> directedEdges;
            Edge edge;

            /* Variables for reading lines from the file */
            String line, lineSplit[], tuple[];

            /* Variables for building ta new edge and vertex */
            int newIdentifier, tail, weight;

            while((line = reader.readLine()) != null) {
                directedEdges = new LinkedList<>();
                lineSplit = line.split("\\s+");
                newIdentifier = Integer.parseInt(lineSplit[0]);

                /* Build the list of edges */
                for (int i = 1, len = lineSplit.length; i < len; i++) {
                    tuple = lineSplit[i].split(",");
                    tail = Integer.parseInt(tuple[0]);
                    weight = Integer.parseInt(tuple[1]);
                    edge = new Edge(false, newIdentifier, tail, weight);
                    //System.out.println(edge);
                    directedEdges.add(edge);
                }

                adjacencyList.appendNewVertex(directedEdges);

            }
        } catch (IOException x) {
            System.out.println("Error opening " + fileName);
        }
        
        return adjacencyList;
    }
}
