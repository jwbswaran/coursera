package coursera.common.model;

import org.jetbrains.annotations.NotNull;

public class WeightedObject implements Comparable<WeightedObject>  {

    /**
     * Identifier of this particular symbol to distinguish it from others
     */
    private int identifier;

    /**
     * The frequency of the symbol to be encoded.
     */
    private int weight;


    /**
     * No-arg constructor
     */
    public WeightedObject() {
    }

    /**
     * Constructor for the Huffman Symbol that allows you to set the identifier and weight on instantiation
     * @param identifier Identifier of this particular symbol to distinguish it from others
     * @param weight The frequency of the symbol to be encoded.
     */
    public WeightedObject(int identifier, int weight) {
        this.identifier = identifier;
        this.weight = weight;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(@NotNull WeightedObject o) {
        return this.getWeight() - o.getWeight();
    }
}
