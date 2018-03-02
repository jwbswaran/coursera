package coursera.common.model;

public class GraphNode {
    private int value;
    private int identifier;

    public GraphNode (int value, int identifier) {
        this.value = value;
        this.identifier = identifier;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }
}
