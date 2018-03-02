package coursera.module3.week2;

import java.io.IOException;
import java.util.Arrays;

import coursera.common.EdgeBundle;
import coursera.common.FileIO;
import coursera.common.datastructures.UnionFind;
import coursera.common.datastructures.vertices.Edge;
import coursera.common.datastructures.vertices.EdgeComparator;

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
     * @return
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
    
    public static void main(String args[]) {
        FileIO fileIO = new FileIO();
        String fileName = "src\\coursera\\common\\input-files\\module3\\week2\\clustering1.txt";
        EdgeBundle edgeBundle = null;
        
        try {
            edgeBundle = fileIO.getEdgeBundleFromFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        if (edgeBundle != null) {
            Clustering clustering = new Clustering();
            System.out.println(clustering.maxSpacingForKClusters(4, edgeBundle));
        }
    }
}
