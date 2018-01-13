package coursera.common.datastructures.vertices;

import java.util.LinkedList;

/**
 * Vertex Object used to represent the vertices of a graph.
 */
public class Vertex {

    /**
     * Identifier for a specific vertex.  Examples include the order in which a vertex is added to a graph, or
     * a value calculated by a topological sort.
     */
    private int identifier;

    /**
     * specifies whether or not this vertex has been explored.
     */
    private boolean isExplored;

    /**
     * List of edges that are connected to this vertex.
     */
    private LinkedList<Edge> edges;

    /**
     * Constructor that creates a vertex that points to no other vertices
     *
     * @param identifier Identifier for a specific vertex
     */
    public Vertex(int identifier) {
        this.identifier = identifier;
        this.isExplored = false;
        this.edges = new LinkedList<>();
    }

    /**
     * Constructor that allows for setting the vertices list of edges on creation
     *
     * @param identifier Identifier for a specific vertex
     * @param edges List of edges this vertex points to
     */
    public Vertex(int identifier, LinkedList<Edge> edges) {
        this.identifier = identifier;
        this.isExplored = false;
        this.edges = edges;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public boolean isExplored() {
        return isExplored;
    }

    public boolean isExplored(Boolean isExplored) {
        this.isExplored = isExplored;
    }

    public void setEdges(LinkedList<Edge> edges) {
        this.edges = edges;
    }

    public LinkedList<Edge> getEdges() {
        return edges;
    }
}
