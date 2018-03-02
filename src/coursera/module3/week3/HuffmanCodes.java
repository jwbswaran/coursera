package coursera.module3.week3;

import coursera.common.model.HuffmanSymbol;
import org.apache.log4j.Priority;

import java.util.PriorityQueue;

/**
 * Class that provides methods that run Huffmans Algorithms on a set of data.
 */
public class HuffmanCodes {

    private PriorityQueue<HuffmanSymbol> pq;



    public HuffmanCodes() {

    }

    public HuffmanCodes(PriorityQueue<HuffmanSymbol> pq) {
        this.pq = pq;
        buildEncodingTree();
    }

    private void buildEncodingTree() {

    }

    public int getMaxLengthOfCodeWord() {
        return 0;
    }

    public int getMinlengthOfCodeWord() {
        return 0;
    }
}
