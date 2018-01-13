package coursera.common.exceptions;

/**
 * Exception utilized by the AdjacencyList class.  Signifies that a vertex that may have been queried
 * does not currently exist in the Adjacency list.
 */
public class NoVertexExistsException extends RuntimeException {
    public NoVertexExistsException() {
        super();
    }

    public NoVertexExistsException(String message) {
        super(message);
    }
}