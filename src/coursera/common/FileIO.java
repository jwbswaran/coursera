package coursera.common;

import coursera.common.model.WeightedObject;
import coursera.common.model.Job;
import coursera.common.datastructures.vertices.Edge;
import coursera.common.datastructures.AdjacencyList;
import coursera.common.datastructures.vertices.Vertex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * This class exists to read input files for the programming assignments for the Stanford Algorithms course
 * hosted by Coursera.  The goal of the class is to prevent duplication of reading files into data structures
 * for the programming assignments when possible.
 * 
 * @author Jordan Beck
 * @since 2018
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

    /**
     * Reads a file formatted with the first row being the number of vertices and the number of edges separated
     * by a space.
     *
     * All following lines are 3 values separated by spaces in the following format:
     *  [head vertex] [tail vertex] [weight]
     * @param fileName path to the file that needs to be read from
     * @return AdjacencyList representation of the graph in the file
     */
    public AdjacencyList getWeightedUndirectedAdjacencyListFromEdgeFile(String fileName) throws IOException {
        AdjacencyList adjacencyList = new AdjacencyList();
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {

            /* Variables for reading lines from the file */
            String line, lineSplit[];

            /* Variables for building ta new edge and vertex */
            int head, tail, weight;
            line = reader.readLine();

            // if the first line is null, this is an empty file, so return empty adjacencyList
            if (line == null) {
                return adjacencyList;
            }

            lineSplit = line.split("\\s+");
            int numNodes = Integer.parseInt(lineSplit[0]);

            for (int i = 0; i < numNodes; i++) {
                adjacencyList.appendNewVertex(new LinkedList<>());
            }

            while((line = reader.readLine()) != null) {

                lineSplit = line.split("\\s+");
                head = Integer.parseInt(lineSplit[0]);
                tail = Integer.parseInt(lineSplit[1]);
                weight = Integer.parseInt(lineSplit[2]);

                // add edge to the head vertex for this edge in the adjacencyList
                Vertex v = adjacencyList.getVertex(head);
                v.getEdges().add(new Edge(false, head, tail, weight));

                // add edge to the tail vertex for this edge in the adjacencyList
                v = adjacencyList.getVertex(tail);
                v.getEdges().add(new Edge(false, tail, head, weight));

            }
        } catch (IOException x) {
            throw new IOException("Error opening " + fileName);
        }

        return adjacencyList;
    }

    /**
     * Reads a file and converts its contents to an array of integers.  This method is intended to be used on a file
     * with one integer entry per line.
     * @param fileName path to the file that needs to be read from
     * @return int array representation of the file passed in as an argument
     */
    public int[] getIntegerArrFromBitRepresentationFile(String fileName) throws IOException{
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        int i = 0;
        int[] arr = new int[0];

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
            // Variables for reading lines from the file
            String line, lineSplit[];

            line = reader.readLine();

            if (line == null) {
                return arr;
            }

            lineSplit = line.split(" ");
            arr = new int[Integer.parseInt(lineSplit[0])];

            while ((line = reader.readLine()) != null) {
                line = line.replaceAll("\\s+", "");
                arr[i] = Integer.parseInt(line, 2);
                i++;
            }

        } catch (IOException x) {
            throw new IOException("Error opening " + fileName);
        }
        return arr;
    }

    /**
     * Reads a file and converts its contents to an array of integers.  This method is intended to be used on a file
     * with one integer entry per line.
     * @param fileName path to the file that needs to be read from
     * @return int array representation of the file passed in as an argument
     */
    public int[] getIntegerArrFromFile(String fileName) throws IOException{
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        ToIntFunction<String> parseStringToInt = s -> {
            return Integer.parseInt(s);
        };

        try {
            return Files.lines(filePath, charset).mapToInt(parseStringToInt).toArray();
        } catch(IOException e) {
            throw new IOException("Error opening " + fileName);
        }
    }

    /**
     * Reads a file and converts its contents to an array of integers.  This method is intended to be used on a file
     * with one integer entry per line.
     * @param fileName path to the file that needs to be read from
     * @return int array representation of the file passed in as an argument
     */
    public long[] getLongArrFromFile(String fileName) throws IOException{
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        ToLongFunction<String> parseStringToLong = s -> {
            return Long.parseLong(s);
        };

        try {
            return Files.lines(filePath, charset).mapToLong(parseStringToLong).toArray();
        } catch(IOException e) {
            throw new IOException("Error opening " + fileName);
        }
    }

    /**
     * Reads a file and converts its contents to an array of Jobs. This method is intended to be used on a file that
     * specifies the number of elements on the first line of the file, followed by each line of the file containing
     * 2 integers separated by white space.  The first is a job's weeight, the 2nd is a job's length
     * @param fileName path to the file that needs to be read from
     * @return Array of Job objects represented in the file.
     * @throws IOException
     */
    public Job[] getJobArrFromFile(String fileName) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);

        Function<String, Job> mapLineToJob = s -> {
            String[] tupleArr = s.split(" ");
            int weight = Integer.parseInt(tupleArr[0]);
            int length = Integer.parseInt(tupleArr[1]);
            return new Job(weight, length);
        };

        try {
            return Files.lines(filePath, charset).map(mapLineToJob).toArray(Job[]::new);
        } catch(IOException e) {
            throw new IOException("Error opening " + fileName);
        }
    }
    
    /**
     * Reads a file and converts its contents to an array of edge objects found in the 
     * coursera.common.datastructures.vertices package.  The file must follow the format below:
     * 
     * [number_of_nodes]
     * [edge 1 node 1] [edge 1 node 2] [edge 1 cost] - example of the following lines to follow
     * [edge 2 node 1] [edge 2 node 2] [edge 2 cost]
     *
     * This array will be packaged into an EdgeBundle object, which also maintains the number of vertices
     * in the graph these edges exist in.
     * 
     * @param fileName path to the file that needs to be read from
     * @return an array of Edges based on the contents of the file.
     * @throws IOException
     */
    public EdgeBundle getEdgeBundleFromFile(String fileName) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        EdgeBundle edgeBundle = new EdgeBundle();
        ArrayList<Edge> edges = new ArrayList<Edge>();

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {
            // Variables for reading lines from the file
            String line, lineSplit[];

            while ((line = reader.readLine()) != null) {
                lineSplit = line.split(" ");

                if (lineSplit.length < 3) {
                    edgeBundle.setNumVertices(Integer.parseInt(lineSplit[0]));
                } else {
                    int head = Integer.parseInt(lineSplit[0]);
                    int tail = Integer.parseInt(lineSplit[1]);
                    int weight = Integer.parseInt(lineSplit[2]);
                    edges.add(new Edge(false, head, tail, weight));
                }
            }

        } catch (IOException x) {
            throw new IOException("Error opening " + fileName);
        }

        edgeBundle.setEdges((edges.toArray(new Edge[0])));

        return edgeBundle;
    }

    /**
     * Reads a file in the format given by coursera for module 3 week 3 and stores the values in a Java PriorityQueue.
     * This file format may be reused in the future and if it is, I will re-purpose this method to handle multiple
     * cases.  The Format is as follows:
     *
     * [number_of_symbols]
     * [weight of symbol #1]
     * [weight of symbol #2]
     *  ...
     *
     * @param fileName path to the file that needs to be read from
     * @return priority queue
     */
    public PriorityQueue<WeightedObject> getPriorityQueueFromHuffmanFile(String fileName) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        PriorityQueue<WeightedObject> pq;
        String line;
        int symbolCount = 1;

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {

            line = reader.readLine();

            if (line == null) {
                return new PriorityQueue<>();
            }

            pq = new PriorityQueue<>(Integer.parseInt(line));

            while ((line = reader.readLine()) != null) {
                pq.add(new WeightedObject(symbolCount, Integer.parseInt(line)));
                symbolCount++;
            }

            return pq;
        } catch (IOException e) {
            throw new IOException("Error opening " + fileName);
        }
    }

    /**
     * Reads a file in the format given by coursera for module 3 week 3 and stores the values in an array.
     *
     * [number_of_symbols]
     * [weight of symbol #1]
     * [weight of symbol #2]
     *  ...
     *
     * @param fileName path to the file that needs to be read from
     * @return priority queue
     */
    public WeightedObject[] getWeightedObjectArrFromFile(String fileName) throws IOException{
        Charset charset = Charset.forName("UTF-8");
        Path filePath = Paths.get(fileName);
        WeightedObject[] arr;
        String line;
        int objectCount = 1;

        try (BufferedReader reader = Files.newBufferedReader(filePath, charset)) {

            line = reader.readLine();

            if (line == null) {
                return new WeightedObject[0];
            }

            arr = new WeightedObject[Integer.parseInt(line)];

            while ((line = reader.readLine()) != null) {
                arr[objectCount - 1] = new WeightedObject(objectCount, Integer.parseInt(line));
                objectCount++;
            }

            return arr;
        } catch (IOException e) {
            throw new IOException("Error opening " + fileName);
        }
    }
}
