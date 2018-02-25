package coursera.common.datastructures.vertices;

import java.util.Comparator;

/**
 * Comparator for Edge Objects.  If one object has a higher weight than another, the edge
 * with the higher weight is considered the greater of the two.  If the weights are equal,
 * the edges are considered equal.
 *
 * @author Jordan Beck
 * @since 2018
 */
public class EdgeComparator implements Comparator<Edge>{

    @Override
    public int compare(Edge e1, Edge e2) {
        return e1.getWeight() - e2.getWeight();
    }
}
