package coursera.common.datastructures.vertices;

/**
 * Edge objects represent each edge that the vertex may be associated with.
 */
public class Edge {
    /**
     * specifies whether or not this edge is directed or undirected
     */
    private boolean isDirected;

    /** the head of this edge, more relevant if this edge is directed.  If the edge is directed, the head
     * of the edge represents the vertex that the edge starts at.
     */
    private int head;

    /** the tail of this edge, more relevant if this edge is directed.  If the edge is directed, the tail
     * of the edge represents the vertex that the edge points to.
     */
    private int tail;

    /**
     * The weight of the edge.  Weight can be used to represent many things such as distance, length,
     * etc..
     */
    private int weight;

    /**
     * Basic Constructor, useful for a vertex in an unweighted, undirected graph
     *
     * Sets the weight to a default of 1, and sets isDirected to false, specifying this is an edge for an
     * undirected graph.
     * @param head head of the edge, or the vertex that the edge begins at
     * @param tail tail of the edge, or the vertex that the edge ends at
     */
    public Edge(int head, int tail) {
        this.isDirected = false;
        this.head = head;
        this.tail = tail;
        this.weight = 1;
    }

    /**
     * Constructor that allows freedom to set all parameters.
     * @param isDirected false means this edge is for an undirected graph, true for directed.
     * @param head head of the edge, or the vertex that the edge begins at
     * @param tail tail of the edge, or the vertex that the edge ends at
     * @param weight weight of the edge depending on what the graphs edges represent
     */
    public Edge(boolean isDirected, int head, int tail, int weight) {
        this.isDirected = isDirected;
        this.head = head;
        this.tail = tail;
        this.weight = weight;
    }

    /**
     * Builds a string representation of an Edge
     * @return the string representation of the edge
     */
    @Override public String toString() {
        if (isDirected) {
            return head + "---> " + tail + " | weight: " + weight;
        } else {
            return head + "---" + tail + " | weight: " + weight;
        }
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getHead() {
        return head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public int getTail() {
        return tail;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

}
