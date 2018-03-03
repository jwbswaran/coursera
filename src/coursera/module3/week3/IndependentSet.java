package coursera.module3.week3;

import coursera.common.FileIO;
import coursera.common.model.WeightedObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Calculates the Maximum Weight IndependentSet of a list of WeightedObjects
 */
public class IndependentSet {

    private WeightedObject[] woArr;

    private int wisValues[];

    /**
     * Constructor that accepts an array of weighted objects and sets the woArr field to it.
     * @param woArr An array of WeightedObjects.
     */
    public IndependentSet(WeightedObject[] woArr) {
        this.woArr = woArr;
        wisValues = new int[woArr.length+1];
    }

    /**
     * Returns a string representation of whether or not the bits specified in the arr parameter are part of the
     * maximum independent weight set of the weightedObjectArr
     * @return
     */
    public String getStringRepresentationForSpecifiedIndices(int[] arr) {
        if (woArr == null || woArr.length == 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();
        HashMap<Integer, WeightedObject> map = getMaxWeightedIndependentSet();

        for (int i = 0, len = arr.length; i < len; i++) {
            if (map.get(arr[i]) != null) {
                builder.append("1");
            } else {
                builder.append("0");
            }
        }
        return builder.toString();
    }

    /**
     * Calculates the maximum weighted indepednent sets of the array of weighted objects stored in this instance
     * of IndependentSet's woArr field.
     */
    public void calculateMaximumWeightedIndependentSets() {
        if (woArr == null || woArr.length == 0) {
            return;
        }

        wisValues[0] = 0;
        wisValues[1] = woArr[0].getWeight();

        for (int i = 2, len = wisValues.length; i < len; i++) {
            wisValues[i] = Math.max(wisValues[i-2] + woArr[i-1].getWeight(), wisValues[i-1]);
        }
    }

    private HashMap<Integer, WeightedObject> getMaxWeightedIndependentSet() {
        int i = woArr.length;
        HashMap<Integer, WeightedObject> map = new HashMap<>();

        while (i > 1) {
            if (wisValues[i-1] >= (wisValues[i-2] + woArr[i-1].getWeight())) {
                i--;
            } else {
                map.put(woArr[i-1].getIdentifier(), woArr[i-1]);
                i -= 2;
            }
        }
        map.put(woArr[i-1].getIdentifier(), woArr[i-1]);
        return map;
    }

    public WeightedObject[] getWoArr() {
        return woArr;
    }

    public void setWoArr(WeightedObject[] woArr) {
        this.woArr = woArr;
    }

    public static void main(String[] args) {
        WeightedObject[] arr = null;

        FileIO fileIO = new FileIO();
        String fileName = "src/coursera/common/input-files/module3/week3/mwis.txt";
        int[] specifiedIndices = {1, 2, 3, 4, 17, 117, 517, 997};

        try {
            arr = fileIO.getWeightedObjectArrFromFile(fileName);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        if (arr != null) {
            IndependentSet is = new IndependentSet(arr);
            is.calculateMaximumWeightedIndependentSets();
            System.out.println(is.getStringRepresentationForSpecifiedIndices(specifiedIndices));
        }

    }
}
