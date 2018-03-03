package coursera.common.test.FileIO;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import coursera.common.EdgeBundle;
import coursera.common.FileIO;
import coursera.common.datastructures.AdjacencyList;
import coursera.common.model.WeightedObject;
import coursera.common.model.Job;
import coursera.common.datastructures.vertices.Edge;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class FileIOTest {

    FileIO fileIO;

    @Before
    public void setup() {
        fileIO = new FileIO();
    }

    /* test getIntegerArrFromFile */
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
        assertNotNull("array under test in testGetArrayFromFileWithSingleElement is null", emptyArr);
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
        assertNotNull("array under test in testGetArrayFromFileWithFiveElements is null", emptyArr);
        assertEquals(5, emptyArr.length);
        assertEquals(-1, emptyArr[0]);
        assertEquals(0, emptyArr[1]);
        assertEquals(1, emptyArr[2]);
        assertEquals(2, emptyArr[3]);
        assertEquals(2147483647, emptyArr[4]);
    }

    /* test getLongArrFromFile */
    @Test
    public void GetLongArrFromFileThrowsIOException() {
        try {
            long[] arr = fileIO.getLongArrFromFile("dud.txt");
        } catch(IOException e) {
            assertEquals("Error opening dud.txt", e.getMessage());
        }
    }

    @Test
    public void testGetLongArrFromFileWithEmptyFile() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        long[] emptyArr = null;
        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }
        assertNotNull("array under test in testGetArrayFromFileWithEmptyInput is null", emptyArr);
        assertEquals(0, emptyArr.length);
    }

    @Test
    public void testGetLongArrFromFileWithSingleElement() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\singleLong.txt";
        long[] emptyArr = null;

        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }

        assertNotNull("array under test in testGetArrayFromFileWithSingleElement is null", emptyArr);
        assertEquals(1, emptyArr.length);
        assertEquals(68037543430L, emptyArr[0]);
    }

    @Test
    public void testGetLongArrFromFileWithFiveElements() {
        String emptyFilename = "src\\coursera\\common\\test\\FileIO\\testFiles\\fiveLong.txt";
        long[] emptyArr = null;
        try {
            emptyArr = fileIO.getLongArrFromFile(emptyFilename);
        } catch(IOException e) {
            fail();
        }
        assertNotNull("array under test in testGetArrayFromFileWithFiveElements is null", emptyArr);
        assertEquals(5, emptyArr.length);
        assertEquals(68037543430L, emptyArr[0]);
        assertEquals(68037543431L, emptyArr[1]);
        assertEquals(68037543432L, emptyArr[2]);
        assertEquals(68037543433L, emptyArr[3]);
        assertEquals(68037543434L, emptyArr[4]);
    }

    @Test
    public void testGetJobArrFromFileWithEmptyFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);
        assertEquals(jobArr.length, 0);
    }

    @Test
    public void testGetJobArrFromFileWithSingleJob() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\singleJob.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);
        assertEquals(jobArr[0].getWeight(), 8);
        assertEquals(jobArr[0].getLength(), 50);
    }

    @Test
    public void testGetJobArrFromFileWithTwoJobs() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\twoJob.txt";
        Job[] jobArr = null;
        try {
            jobArr = fileIO.getJobArrFromFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(jobArr);

        assertEquals(jobArr[0].getWeight(), 8);
        assertEquals(jobArr[0].getLength(), 50);

        assertEquals(jobArr[1].getWeight(), 9);
        assertEquals(jobArr[1].getLength(), 40);
    }

    @Test
    public void testGetWeightedUndirectedAdjacencyListFromEdgeFileWithEmptyFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        AdjacencyList adjacencyList = null;
        try {
            adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromEdgeFile(fileName);
        } catch(IOException e) {
            fail();
        }
        assertNotNull(adjacencyList);
        assertEquals(0, adjacencyList.getNumVertices());
    }

    @Test
    public void testGetWeightedUndirectedAdjacencyListFromEdgeFileWithOneEdgFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\oneEdge.txt";
        AdjacencyList adjacencyList = null;

        try {
            adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromEdgeFile(fileName);
        } catch(IOException e) {
            fail();
        }
        assertNotNull(adjacencyList);
        assertEquals(2, adjacencyList.getNumVertices());

        LinkedList<Edge> edges = adjacencyList.getVertex(1).getEdges();
        assertEquals(1, edges.size());

        Edge e = edges.getFirst();
        assertEquals(1, e.getHead());
        assertEquals(2, e.getTail());
        assertEquals(1687, e.getWeight());
    }

    @Test
    public void testGetWeightedUndirectedAdjacencyListFromEdgeFileWithTwoEdgFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\twoEdge.txt";
        AdjacencyList adjacencyList = null;

        try {
            adjacencyList = fileIO.getWeightedUndirectedAdjacencyListFromEdgeFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(adjacencyList);
        assertEquals(3, adjacencyList.getNumVertices());

        LinkedList<Edge> edges = adjacencyList.getVertex(1).getEdges();
        assertEquals(1, edges.size());

        Edge e = edges.getFirst();
        assertEquals(1, e.getHead());
        assertEquals(2, e.getTail());
        assertEquals(1687, e.getWeight());

        edges = adjacencyList.getVertex(2).getEdges();
        assertEquals(2, edges.size());

        e = edges.pop();
        assertEquals(2, e.getHead());
        assertEquals(1, e.getTail());
        assertEquals(1687, e.getWeight());

        e = edges.pop();
        assertEquals(2, e.getHead());
        assertEquals(3, e.getTail());
        assertEquals(-8023, e.getWeight());

        edges = adjacencyList.getVertex(3).getEdges();
        e = edges.pop();
        assertEquals(3, e.getHead());
        assertEquals(2, e.getTail());
        assertEquals(-8023, e.getWeight());
    }
    
    @Test
    public void testGetEdgeArrFromNonExistingFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\FAKE.txt";
        
        try {
            fileIO.getEdgeBundleFromFile(fileName);
        } catch(IOException e) {
            assertEquals(true, true);
        }
    }
    
    @Test
    public void testGetEdgeBundleFromEmptyFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        EdgeBundle edgeBundle = null;
        Edge[] edges = null;

        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch(IOException e) {
            fail();
        }
        
        assertNotNull(edgeBundle);
        edges = edgeBundle.getEdges();
        
        assertNotNull(edges); 
        assertEquals(0, edges.length);
    }
    
    @Test
    public void testGetEdgeBundleFromOneEdgeFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\OneEdge.txt";
        EdgeBundle edgeBundle = null;
        Edge[] edges = null;

        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch(IOException e) {
            fail();
        }
        
        assertNotNull(edgeBundle);
        assertEquals(2, edgeBundle.getNumVertices());
        
        edges = edgeBundle.getEdges();
        
        assertNotNull(edges); 
        assertEquals(1, edges.length);
        
        Edge edge = edges[0];
        
        assertEquals(1, edge.getHead());
        assertEquals(2, edge.getTail());
        assertEquals(1687, edge.getWeight());
    }
    
    @Test
    public void testGetEdgeBundleFromTwoEdgeFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\twoEdge.txt";
        EdgeBundle edgeBundle = null;
        Edge[] edges = null;

        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch(IOException e) {
            fail();
        }
        
        assertNotNull(edgeBundle);
        assertEquals(3, edgeBundle.getNumVertices());
        
        edges = edgeBundle.getEdges();
        
        assertNotNull(edges); 
        assertEquals(2, edges.length);
        
        Edge edge = edges[0];
        
        assertEquals(1, edge.getHead());
        assertEquals(2, edge.getTail());
        assertEquals(1687, edge.getWeight());
        
        edge = edges[1];
        
        assertEquals(2, edge.getHead());
        assertEquals(3, edge.getTail());
        assertEquals(-8023, edge.getWeight());
    }

    @Test
    public void testGetIntegerArrFromBitRepresentationFileWithEmptyFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\empty.txt";
        int[] arr = null;

        try {
            arr = fileIO.getIntegerArrFromBitRepresentationFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(arr);
        assertEquals(0, arr.length);
    }


    @Test
    public void testGetIntegerArrFromBitRepresentationFileWithTestFile() {
        String fileName = "src\\coursera\\common\\test\\FileIO\\testFiles\\BitRepresentation.txt";
        int[] arr = null;

        try {
            arr = fileIO.getIntegerArrFromBitRepresentationFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(arr);
        assertEquals(4, arr.length);
    }

    @Test
    public void testGetPriorityQueueFromHuffmanFileWithEmptyFile() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/empty.txt";
        PriorityQueue<WeightedObject> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(pq);

        assertEquals(0, pq.size());
    }

    @Test
    public void testGetPriorityQueueFromHuffmanFileWithOneElement() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/HuffmanTestFiles/SingleSymbol.txt";
        PriorityQueue<WeightedObject> pq = null;
        WeightedObject symbol;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(pq);

        assertEquals(1, pq.size());

        symbol = pq.peek();
        assertEquals(1, symbol.getIdentifier());
        assertEquals(7540662, symbol.getWeight());
    }

    @Test
    public void testGetPriorityQueueFromHuffmanFileWithTwoElements() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/HuffmanTestFiles/DoubleSymbol.txt";
        PriorityQueue<WeightedObject> pq = null;
        WeightedObject symbol;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch(IOException e) {
            fail();
        }

        assertNotNull(pq);

        assertEquals(2, pq.size());

        symbol = pq.remove();
        assertEquals(2, symbol.getIdentifier());
        assertEquals(6852892, symbol.getWeight());

        symbol = pq.remove();
        assertEquals(1, symbol.getIdentifier());
        assertEquals(7540662, symbol.getWeight());
    }

    @Test
    public void testGetWeightedObjectArrFromFileWithEmptyFile() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/empty.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch (IOException e) {
            fail();
        }

        assertNotNull(arr);
        assertEquals(0, arr.length);
    }

    @Test
    public void testGetWeightedObjectArrFromFileWithOneElement() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/HuffmanTestFiles/SingleSymbol.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch (IOException e) {
            fail();
        }

        assertNotNull(arr);
        assertEquals(1, arr.length);

        assertEquals(1, arr[0].getIdentifier());
        assertEquals(7540662, arr[0].getWeight());
    }

    @Test
    public void testGetWeightedObjectArrFromFileWithTwoElements() {
        String fileName = "src/coursera/common/test/FileIO/testFiles/HuffmanTestFiles/DoubleSymbol.txt";
        WeightedObject[] arr = null;

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch (IOException e) {
            fail();
        }

        assertNotNull(arr);
        assertEquals(2, arr.length);

        assertEquals(1, arr[0].getIdentifier());
        assertEquals(7540662, arr[0].getWeight());

        assertEquals(2, arr[1].getIdentifier());
        assertEquals(6852892, arr[1].getWeight());
    }
}
