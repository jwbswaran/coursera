package coursera.module2.week3;

import coursera.common.FileIO;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * Holds operations pertaining doing Median Maintenance Operations on a set of data.
 */
public class MedianMaintenance {

    /**
     * Max Heap for maintaining the lowest values in the total collection
     */
    private PriorityQueue<Integer> lowHeap;

    /**
     * Min Heap for maintaining the highest values in the total collection
     */
    private PriorityQueue<Integer> highHeap;

    /**
     * Initializes the heaps required to perform Median Maintenance
     */
    public MedianMaintenance() {
        this.lowHeap = new PriorityQueue<>((x, y) -> y - x);
        this.highHeap = new PriorityQueue<>();
    }

    /**
     * Returns the last 4 digits of the sum of the medians of this MedianMaintenanceObject as
     */
    public int computeSumOfMediansMod10000(int[] values) {
        int sum = 0;
        int length = values.length;

        if (length > 0) {
            lowHeap.add(values[0]);
            sum = values[0];
        }

        for (int i = 1; i < length; i++) {
            sum += computeNewMedian(values[i]);
        }
        return sum % 10000;
    }

    /*
     * Computes the new median of the collection of values
     * @param nextValue nextValue to compute a median for.
     */
    private int computeNewMedian(int nextValue) {
        // maxLowVal and minHighVal will be used to compute the new median
        int maxLowVal = Integer.MAX_VALUE;
        int minHighVal = Integer.MIN_VALUE;

        // heap sizes prior to adding the nextValue
        int lowHeapSize = lowHeap.size();
        int highHeapSize = highHeap.size();

        /* k is a counter for the median we are calculating.  As an example, if this function has been called
         * twice, then 2 medians have been calculated already.  If we make a 3rd call, k would be 3, as we are
         * calculating the 3rd median in the total amount
         */
        int k = lowHeapSize + highHeapSize + 1;

        int median;

        if (lowHeapSize > 0) {
            maxLowVal = lowHeap.peek();
        }

        if (highHeapSize > 0) {
            minHighVal = highHeap.peek();
        }

        if (nextValue <= maxLowVal) {
            lowHeap.add(nextValue);
        } else if (nextValue >= minHighVal) {
            highHeap.add(nextValue);
        } else {
            lowHeap.add(nextValue);
        }

        rebalance();

        if (lowHeapSize > 0) {
            maxLowVal = lowHeap.peek();
        }

        if (highHeapSize > 0) {
            minHighVal = highHeap.peek();
        }

        if (nextValue <= maxLowVal) {
            median = maxLowVal;
        } else if (nextValue >= minHighVal) {
            if (k % 2 == 0) {
                median = maxLowVal;
            } else {
                median = minHighVal;
            }
        } else {
            median = nextValue;
        }

        return median;
    }

    /*
     * Rebalances the heaps
     */
    private void rebalance() {
        // heap sizes prior to adding the nextValue
        int lowHeapSize = lowHeap.size();
        int highHeapSize = highHeap.size();

        if (lowHeapSize - highHeapSize > 1) {
            highHeap.add(lowHeap.poll());
        } else if (highHeapSize - lowHeapSize > 1) {
            lowHeap.add(highHeap.poll());
        }
    }

    public static void main (String args[]) {
        String fileName = "src\\coursera\\common\\input-files\\module2\\week3\\median.txt";
        FileIO fileIO = new FileIO();

        try {
            int[] arr = fileIO.getIntegerArrFromFile(fileName);
            MedianMaintenance medianMaintenance = new MedianMaintenance();
            System.out.println(medianMaintenance.computeSumOfMediansMod10000(arr));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
