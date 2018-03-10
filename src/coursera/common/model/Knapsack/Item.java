package coursera.common.model.Knapsack;

/**
 * Item that would be stored in a knapsack.
 */
public class Item {

    /**
     * represents this items worth compared to other items to put in the knapsack.
     */
    private int value;

    /**
     * represents how much of the total capacity this object would take up.
     */
    private int weight;

    /**
     * No arg constructor
     */
    public Item() {

    }

    /**
     * Constructor
     * @param value value of the item being created compared to other items
     * @param weight how much space the item would take up in a knapsack
     */
    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
