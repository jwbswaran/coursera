package coursera.module3.week3;

import coursera.common.FileIO;
import coursera.common.datastructures.BinaryTree.BinaryTree;
import coursera.common.datastructures.BinaryTree.Node;
import coursera.common.model.HuffmanSymbol;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Class that provides methods that run Huffmans Algorithms on a set of data.
 */
public class HuffmanCodes {

    private PriorityQueue<HuffmanSymbol> pq;

    private Node head;

    private BinaryTree tree;

    private HuffmanSymbol minHuffmanSymbol;

    private HuffmanSymbol maxHuffmanSymbol;

    public HuffmanCodes() {

    }

    public HuffmanCodes(PriorityQueue<HuffmanSymbol> pq) {
        this.pq = pq;
        buildEncodingTree();
    }

    private void buildEncodingTree() {
        ArrayBlockingQueue<Node> queue = new ArrayBlockingQueue<>(pq.size());

        HuffmanSymbol mergeSymbol;
        Node leftNode, rightNode, mergeNode;

        while (pq.size() > 0) {
            if (pq.size() >= 2) {
                HuffmanSymbol sym1 = pq.remove();
                HuffmanSymbol sym2 = pq.remove();

                mergeSymbol = new HuffmanSymbol();
                mergeSymbol.setWeight(sym1.getWeight() + sym2.getWeight());
                
                if (queue.size() > 0) {
                    leftNode = new Node(sym1);
                    rightNode = new Node(sym2);

                    if (queue.size() > 0 && queue.peek().getValue().compareTo(sym1) == 0) {
                        leftNode = queue.poll();
                    }

                    if (queue.size() > 0 && queue.peek().getValue().compareTo(sym2) == 0) {
                        rightNode = queue.poll();
                    }
                } else {
                    leftNode = new Node(sym1);
                    rightNode = new Node(sym2);
                }

                mergeNode = new Node(mergeSymbol, leftNode, rightNode);

                queue.add(mergeNode);

                pq.add(mergeSymbol);
            } else {
                head = queue.poll();
                pq.remove();
            }

        }
        tree = new BinaryTree(head);
    }

    public int getMaxLengthOfCodeWord() {
        return tree.getMaxDepth() - 1;
    }

    public int getMinLengthOfCodeWord() {
        return tree.getMinDepth() - 1;
    }

    public static void main (String[] args) {
        String fileName = "src/coursera/common/input-files/module3/week3/huffman.txt";
        FileIO fileIO = new FileIO();
        PriorityQueue<HuffmanSymbol> pq = null;

        try {
            pq = fileIO.getPriorityQueueFromHuffmanFile(fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        HuffmanCodes codes = new HuffmanCodes(pq);

        System.out.println("Max length of word: " + codes.getMaxLengthOfCodeWord());
        System.out.println("Min length of word: " + codes.getMinLengthOfCodeWord());
    }
}
