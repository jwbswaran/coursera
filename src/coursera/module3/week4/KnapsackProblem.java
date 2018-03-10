package coursera.module3.week4;

import coursera.common.FileIO;
import coursera.common.model.Knapsack.Item;
import coursera.common.model.Knapsack.Knapsack;

import java.io.IOException;

/**
 * class that calculates the optimal solution for the knapsack problem.
 *
 * We're given a knapsack with a specific capacity W, and a list of items that each have a value V and a weight X.
 *
 * The knapsack problem class will calculate the set of items that provide the highest value when put in the knapsack,
 * while also maintaining the invariant that the total weight of the items remains less than W.
 */
public class KnapsackProblem {

    /**
     * Calculate the maximum value potential of the knapsack passed in based on the knapsaks potential items.
     * @param knapsack knapsack to perform this value calculation on
     * @return maximum possible value to be had with this knapsack.
     */
    public static int calculateMaxValueOfKnapsack(Knapsack knapsack) {
        Item[] potentialItems = knapsack.getPotentialItems();
        Item item;

        int n = potentialItems.length;
        int w = knapsack.getCapacity();

        int optimalSolutions[][] = new int[2][w + 1];

        // Initialize the solutions for 0 capacity and n items to 0
        for (int i = 0; i < 2; i++) {
            optimalSolutions[i][0] = 0;
        }

        // Initialize the solutions for w capacity and 0 items
        for (int x = 0; x < w; x++) {
            optimalSolutions[0][x] = 0;
        }

        for (int i = 0; i < n; i++) {
            item = potentialItems[i];

            for (int x = 0; x < w + 1; x++) {
                int case1 = optimalSolutions[0][x];

                if (item.getWeight() > x) {
                    optimalSolutions[1][x] = case1;
                } else {
                    int case2 = optimalSolutions[0][x - item.getWeight()] + item.getValue();

                    optimalSolutions[1][x] = Math.max(case1, case2);
                }
            }

            for (int k = 0, len = optimalSolutions[1].length; k < len; k++) {
                optimalSolutions[0][k] = optimalSolutions[1][k];
                optimalSolutions[1][k] = 0;
            }

            //printOptimalSolutions(optimalSolutions);
        }

        return optimalSolutions[0][w];
    }

    private static void printOptimalSolutions(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        int j, jLen;

        for (int i = 0, iLen = arr.length; i < iLen; i++) {
            builder.append("[");

            for (j = 0, jLen = arr[i].length; j < jLen - 1; j++) {
                builder.append(arr[i][j]).append(",");
            }

            builder.append(arr[i][j]).append("]\n");
        }
        System.out.println(builder.toString());
    }

    public static void main(String[] args) {
        FileIO fileIO = new FileIO();
        String filename = "src/coursera/common/input-files/module3/week4/knapsack1.txt";
        Knapsack knapsack = null;

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        if (knapsack != null) {
            System.out.println(KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
        }

        filename = "src/coursera/common/input-files/module3/week4/knapsack_big.txt";

        try {
            knapsack = fileIO.getKnapsackFromFile(filename);
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }

        if (knapsack != null) {
            System.out.println(KnapsackProblem.calculateMaxValueOfKnapsack(knapsack));
        }
    }
}
