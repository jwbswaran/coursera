package coursera.common.datastructures.BinaryTree;

import coursera.common.model.HuffmanSymbol;

/**
 * A node of a BinaryTree
 * TODO - MAKE GENERIC
 */
public class Node {

    private HuffmanSymbol value;

    private Node left;

    private Node right;

    public Node() {
        this.value = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a node object with the value passed in as a parameter.  Sets the left and right child to null
     * @param value The value to attach to the node being created.
     */
    public Node(HuffmanSymbol value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    /**
     * Creates a node object with the value, left, and right fields set to the arguments passed into the
     * constructor
     * @param value The value to attach to the node being created.
     * @param left The Node that has a value less than the value of this node
     * @param right The Node that has a value greater than the value of this node
     */
    public Node(HuffmanSymbol value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public HuffmanSymbol getValue() {
        return value;
    }

    public void setValue(HuffmanSymbol value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
