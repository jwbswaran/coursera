package coursera.module3.week2;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

import coursera.common.EdgeBundle;
import coursera.common.FileIO;
import coursera.common.datastructures.UnionFind;
import coursera.common.datastructures.vertices.Edge;
import coursera.common.datastructures.vertices.EdgeComparator;
import coursera.common.model.GraphNode;

/**
 * Class that performs clustering operations
 *
 * @author Jordan Beck
 * @since 2018
 */
public class Clustering {

    public Clustering() {
        
    }
    
    /**
     * Calculates the maximum spacing for k clusters 
     *
     * @param k the maximum number of clusters we will create 
     * @param edgeBundle edgeBundle object containing an array of edges, and the number of vertices
     * @return maximum spacing for k clusters for the given edges in the edgeBundle
     */
    public int maxSpacingForKClusters(int k, EdgeBundle edgeBundle) {
        // Use a union find data structure to keep track of our clusters
        UnionFind uf = new UnionFind(edgeBundle.getNumVertices());
        
        // edges we will use to form the clusters
        Edge[] edges = edgeBundle.getEdges();
        
        // need to sort the edges by weight
        Arrays.sort(edges, new EdgeComparator());
        
        int i = 0, len, weight, maxSpacing = Integer.MAX_VALUE;
        Edge e;
       
        // Create the clusters
        while (i < edges.length && uf.count() > k) {
            e = edges[i];
            uf.union(e.getHead() - 1, e.getTail() - 1);
            i++;
        }
        
        // check edges, and if they aren't in the same union check the spacing
        for (i = 0, len = edges.length; i < len; i++) {
            e = edges[i];
            weight = e.getWeight();
            
            if (uf.find(e.getHead() - 1) != uf.find(e.getTail() - 1) && weight < maxSpacing) {
                maxSpacing = weight;
            }
        }
        
        return maxSpacing;
    }

    /**
     * Calculates the maximum number of clusters to ensure that no pair of nodes in this integer array with all
     * but 2 bits in common get split into different clusters.
     * @return maximum number of clusters
     */
    public int maxClustersNeededFor24BitValues(int[] values) {
        int identI, identJ, distance;

        HashSet<Integer> set = createSetOfValues(values);

        GraphNode[] nodes = createArrOfNodesFromSet(set);

        UnionFind uf = new UnionFind(nodes.length);

        for (int i = 0, len = nodes.length; i < len; i++) {
            GraphNode nodeI = nodes[i];
            identI = nodeI.getIdentifier();

            for (int j = 0; j < len; j++) {
                GraphNode nodeJ = nodes[j];
                identJ = nodeJ.getIdentifier();

                distance = calculateHammingDistance(nodeI.getValue(), nodeJ.getValue());
                if (distance < 3) {
                    uf.union(identI, identJ);
                }
            }
        }

        return uf.count();
    }

    private HashSet<Integer> createSetOfValues(int[] values) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0, len = values.length; i < len; i++) {
            set.add(values[i]);
        }

        return set;
    }

    private GraphNode[] createArrOfNodesFromSet(HashSet<Integer> set) {
        GraphNode[] nodes = new GraphNode[set.size()];
        Iterator<Integer> setIterator = set.iterator();

        int val, i = 0;

        while(setIterator.hasNext()) {
            val = setIterator.next();
            nodes[i] = new GraphNode(val, i);
            i++;
        }

        return nodes;
    }

    private int calculateHammingDistance(int p, int q) {
        int numDiffBits = p ^ q;

        int count = 0;
        while (numDiffBits > 0)
        {
            numDiffBits &= (numDiffBits - 1) ;
            count++;
        }
        return count;
    }


    
    public static void main(String args[]) {
        Clustering clustering = new Clustering();
        FileIO fileIO = new FileIO();
        String fileName = "src\\coursera\\common\\input-files\\module3\\week2\\clustering1.txt";
        EdgeBundle edgeBundle = null;
        
        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        if (edgeBundle != null) {
            System.out.println(clustering.maxSpacingForKClusters(4, edgeBundle));
        }

        int[] arr = null;

        fileName = "src\\coursera\\common\\input-files\\module3\\week2\\clustering_big.txt";

        try{
            arr = fileIO.getIntegerArrFromBitRepresentationFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (arr != null) {
            System.out.println(clustering.maxClustersNeededFor24BitValues(arr));
        }
    }
}
