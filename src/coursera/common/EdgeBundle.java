package coursera.common;

import coursera.common.datastructures.vertices.Edge;

/**
 * Class to make reading files with the following format simpler:
 * 
 * [number_of_nodes]
 * [edge 1 node 1] [edge 1 node 2] [edge 1 cost]
 * [edge 2 node 1] [edge 2 node 2] [edge 2 cost]
 * 
 * Because each line of the file isn't the same, the first line needs to be read differently than the rest
 * This class will act as a model for the data to be returned.
 *
 * @author Jordan Beck
 * @since 2018
 */
public class EdgeBundle {

    /**
     * The number of vertices that the edges in the array of edges are connecting to.
     */
    private int numVertices;
    
    /**
     * An array of edges in a graph, the edges could also represent the spacing between
     * objects in space.
     */
    private Edge[] edges;
    
    public int getNumVertices() {
        return numVertices;
    }

    
    public void setNumVertices(int numVertices) {
        this.numVertices = numVertices;
    }

    
    public Edge[] getEdges() {
        return edges;
    }

    
    public void setEdges(Edge[] edges) {
        this.edges = edges;
    }
}
