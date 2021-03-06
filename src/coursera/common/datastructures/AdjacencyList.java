package coursera.common.datastructures;

import coursera.common.exceptions.NoVertexExistsException;
import coursera.common.datastructures.vertices.Vertex;
import coursera.common.datastructures.vertices.Edge;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Adjacency list representation of an undirected or directed graph.
 */
public class AdjacencyList {

    /**
     * An arrayList representation of the vertices in this list.  An arrayList is used over a traditional array
     * for increased flexibility.
     */
    private ArrayList<Vertex> vertices;

    /**
     * Constructor that initializes an empty adjacency list.
     */
    public AdjacencyList() {
        vertices = new ArrayList<>();
    }

    /**
     * Append a new vertex to the end of the adjacency list
     * @param edges the List of edges this vertex points to
     */
    public void appendNewVertex (LinkedList<Edge> edges) {
        Vertex vertex = new Vertex(vertices.size() + 1, edges);
        vertices.add(vertex);
    }

    /**
     * Returns the vertex based on the identifier passed in
     * @param identifier vertex identifier to search for in the array
     */
    public Vertex getVertex(int identifier) {
        try {
            return vertices.get(identifier - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoVertexExistsException("Vertex " + identifier + "doesn't exist in the adjacency list");
        }
    }

    /**
     * Sets the edges for an already existing vertex in the graph.  If the vertex doesn't exist in the graph,
     * then new vertices up to and including the identifier passed in are created.
     *
     * Each edge that didn't exist prior to the identifier is created with an empty list of edges.  The vertex
     * at the identifier specified is created, and its edges are set to the edges passed in as an argument to this
     * method.
     * @param identifier Identifier associated with a specific vertex
     * @param edges the List of edges this vertex points to
     */
    public void setVerticesAttachedToVertex(int identifier, LinkedList<Edge> edges) {
        try {
            vertices.get(identifier - 1).setEdges(edges);
        } catch (IndexOutOfBoundsException e) {
            //System.out.println("hi");
            for (int i = vertices.size(); i < identifier; i++) {
                //System.out.println(i);
                appendNewVertex(new LinkedList<>());
            }
            //System.out.println("bye");
            vertices.get(identifier - 1).setEdges(edges);
        }

    }

    /**
     * Sets the explored property of all vertices currently in the graph to unexplored (false).
     */
    public void markAllVerticesUnexplored() {
        Consumer<Vertex> markVertexUnexplored = vertex -> {
            vertex.isExplored(false);
        };

        vertices.forEach(markVertexUnexplored);
    }

    /**
     * Marks the identified vertex as unexplored
     * @param identifier Identifier associated with a specific vertex
     */
    public void markVertexUnexplored(int identifier) {
        vertices.get(identifier - 1).isExplored(false);
    }

    /**
     * Marks the identified vertex as unexplored
     * @param identifier Identifier associated with a specific vertex
     */
    public void markVertexExplored(int identifier) {
        vertices.get(identifier - 1).isExplored(true);
    }

    /**
     * Returns whether or not the vertex with the identifier passed in is explored
     * @param identifier Identifier associated with a specific vertex
     * @return true if explored, false if unexplored
     */
    public Boolean isVertexExplored(int identifier) {
        return vertices.get(identifier - 1).isExplored();
    }

    /**
     * get the number of vertices currently in the adjacency list
     * @return the number of verticies in the adjacency list
     */
    public int getNumVertices() {
        return vertices.size();
    }

    /**
     * Returns a string representation of the adjacencyList.
     * @return string representation of the adjacencyList
     */
    @Override public String toString() {
        StringBuilder printStr = new StringBuilder();
        for (int i = 0, length = vertices.size(); i < length; i++) {
            printStr.append(vertices.get(i).toString());
            printStr.append("\n");
        }
        return printStr.toString();
    }
}
