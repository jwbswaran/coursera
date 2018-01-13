package coursera.common;

import coursera.common.exceptions.NoVertexExistsException;
import coursera.common.datastructures.AdjacencyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class exists to read input files for the programming assignments for the Stanford Algorithms course
 * hosted by Coursera.  The goal of the class is to prevent duplication of reading files into data structures
 * for the programming assignments when possible.
 */
public class FileIO {

    public AdjacencyList getWeightedUndirectedAdjacencyListFromFile(String fileName) {
        AdjacencyList adjacencyList = new AdjacencyList();
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
            LinkedList<Integer> directedEdges = new LinkedList<>();
            String line = reader.readLine();
            String[] lineSplit = line.split("\\s+");
            directedEdges.add(Integer.parseInt(lineSplit[1]) - 1);
            adjacencyList.addVertex(directedEdges);

            while((line = reader.readLine()) != null) {
                lineSplit = line.split("\\s+");
                int currentVertex = Integer.parseInt(lineSplit[0]) - 1;
                int vertexToAdd = Integer.parseInt(lineSplit[1]) - 1;

                if (!adjacencyList.vertexExists(vertexToAdd)) {
                    adjacencyList.setVerticesAttachedToVertex(vertexToAdd, new LinkedList<>());
                }

                try {
                    directedEdges = adjacencyList.getVerticesAttachedToVertex(currentVertex);
                    directedEdges.add(vertexToAdd);
                    adjacencyList.setVerticesAttachedToVertex(currentVertex, directedEdges);
                } catch (NoVertexExistsException e) {
                    directedEdges = new LinkedList<>();
                    directedEdges.add(vertexToAdd);
                    adjacencyList.setVerticesAttachedToVertex(currentVertex, directedEdges);
                }
            }
        } catch (IOException x) {
            System.out.println("Error opening " + fileName);
        }

        return adjacencyList;
    }
}
