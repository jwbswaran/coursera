package coursera.common.datastructures.BinaryTree;

import coursera.common.model.WeightedObject;

/**
 * Binary Tree class.  Supports the add and find operations.
 */
public class BinaryTree{
    private Node head;

    public BinaryTree () {
        head = null;
    }

    public BinaryTree(Node head) {
        this.head = head;
    }

    public void insert(WeightedObject value) {
        if (head == null) {
            Node node = new Node(value, null, null);
            head = node;
        } else {
            head = addRecursive(head, value);
        }

    }

    private Node addRecursive(Node current, WeightedObject value) {
        if (current == null) {
            return new Node(value, null, null);
        } else {
            WeightedObject nodeValue = current.getValue();
            int compareVal = value.compareTo(nodeValue);

            if (compareVal <= 0) {
                current.setLeft(addRecursive(current.getLeft(), value));
            } else if (compareVal > 0) {
                current.setRight(addRecursive(current.getRight(), value));
            }
        }
        return current;
    }

    public int getMaxDepth() {
        return getMaxDepthRecursive(head);
    }

    private int getMaxDepthRecursive(Node current) {
        if (current == null ) {
            return 0;
        } else {
            int leftHeight = getMaxDepthRecursive(current.getLeft());
            int rightHeight = getMaxDepthRecursive(current.getRight());

            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    public int getMinDepth() {
        if (head == null) {
            return 0;
        }
        return getMinDepthRecursive(head);
    }

    private int getMinDepthRecursive(Node current) {
        if (current.getLeft() == null && current.getRight() == null) {
            return 1;
        }

        if (current.getLeft() == null) {
            return getMinDepthRecursive(current.getRight()) + 1;
        }

        if (current.getRight() == null) {
            return getMinDepthRecursive(current.getLeft()) + 1;
        }

        return Math.min(getMinDepthRecursive(current.getLeft()), getMinDepthRecursive(current.getRight())) + 1;
    }

    public void traverseInOrder() {
        traverseInOrderRecursive(head);
    }

    private void traverseInOrderRecursive(Node node) {
        if (node != null) {
            traverseInOrderRecursive(node.getLeft());
            System.out.print(" " + node.getValue().getWeight());
            traverseInOrderRecursive(node.getRight());
        }
    }
}
