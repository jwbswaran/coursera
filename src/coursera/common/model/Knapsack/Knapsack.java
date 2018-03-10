package coursera.common.model.Knapsack;

/**
 * Knapsack object used to represent a container with a capacity.
 */
public class Knapsack {

    /**
     * total capacity of the knapsack
     */
    private int capacity;

    /**
     * List of Items that could potentially be stored in this knapsack.
     */
    private Item[] potentialItems;

    /**
     * no arg constructor
     */
    public Knapsack() {

    }

    /**
     * Constructor for initializing a knapsack of certain capacity
     * @param capacity total capacity of the knapsack
     */
    public Knapsack(int capacity) {
        this.capacity = capacity;
    }

    /**
     * Constructor for capacity and potential items known on creation
     * @param capacity total capacity of the knapsack
     * @param potentialItems List of Items that could potentially be stored in this knapsack.
     */
    public Knapsack(int capacity, Item[] potentialItems) {
        this.capacity = capacity;
        this.potentialItems = potentialItems;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Item[] getPotentialItems() {
        return potentialItems;
    }

    public void setPotentialItems(Item[] potentialItems) {
        this.potentialItems = potentialItems;
    }
}
