package coursera.module2.week4;

import coursera.common.FileIO;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Calculates if two numbers exist in an array of integers that equals the value of an integer.
 */
public class TwoSum {

    /** Hashtable to use for lookups on the value of the long array passed in on object instantiation*/
    private Hashtable<Long, Long> hashTableLong;

    /** array of longs to find TwoSums */
    long[] twoSumArrLong;

    public TwoSum(long[] twoSumArr) {
        this.twoSumArrLong = twoSumArr;
        hashTableLong = new Hashtable<>(1000000, 0.05f);

        for (int i = 0, length = twoSumArr.length; i < length; i++) {
            hashTableLong.put(twoSumArrLong[i], twoSumArrLong[i]);
        }
    }

    /**
     * Determines if two values in the array passed in sum to the value T
     * @param t value to try to achieve when summing any 2 distinct array values from the input array passed in
     *          during object creation
     * @return true if a 2 sum exists, false otherwise
     */
    public boolean doesTwoSumExist(int t) {
        
        for (int i = 0, length = twoSumArrLong.length; i < length; i++) {
            long necessaryOperand = t - twoSumArrLong[i];
            if (hashTableLong.containsKey(necessaryOperand) && necessaryOperand != twoSumArrLong[i]) {
                return true;
            }
        }

        return false;
    }

    /**
     * Determines if there is a range of sums between 2 numbers in the array passed in when the object is instantiated.
     * Returns a count of the total number of two sums
     *
     * @param bottomRange bottom of the range of possible t's to look for sums
     * @param topRange top of the range of possible t's to look for sums
     * @return number of sums in the array within the range specified.
     */
    public int testTwoSumRange(int bottomRange, int topRange) {
        int numSums = 0;

        for (int i = bottomRange; i <= topRange; i++) {
            if (doesTwoSumExist(i)) {
                numSums++;
            }
        }

        return numSums;
    }

    public static void main(String[] args) {
        String filePath = "src\\coursera\\common\\input-files\\module2\\week4\\2sum.txt";
        FileIO fileIO = new FileIO();

        try {
            long[] arr = fileIO.getLongArrFromFile(filePath );
            TwoSum twoSum = new TwoSum(arr);
            System.out.println(twoSum.testTwoSumRange(-10000, 10000));
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
