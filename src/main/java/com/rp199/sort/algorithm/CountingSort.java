package com.rp199.sort.algorithm;

/**
 * Implementation of Counting Sort algorithm
 * Only work non-negative discrete values.
 * O(n)
 */
public class CountingSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        int[] maxAndMin = findMaxAndMin(array);
        countingSort(array, maxAndMin[0], maxAndMin[1]);
    }

    /**
     * Finds the max and the min value in the array.
     * Not part of the algorithm, just a util method
     *
     * @param input array of integers
     * @return array min value at position 0 and max at position 1
     */
    private int[] findMaxAndMin(int[] input) {
        int[] maxAndMin = {input[0], input[0]};

        for (int i = 1; i < input.length; i++) {
            if (input[i] < maxAndMin[0]) {
                maxAndMin[0] = input[i];
                continue;
            }

            if (input[i] > maxAndMin[1]) {
                maxAndMin[1] = input[i];
            }
        }
        return maxAndMin;
    }

    private static void countingSort(int[] input, int min, int max) {
        if (max < min) {
            throw new IllegalArgumentException("max should be greater than min");
        }
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int fillIndex = 0;
        for (int j = 0; j < countArray.length; j++) {
            for (int k = 0; k < countArray[j]; k++) {
                input[fillIndex++] = j + min;
            }
        }

        //Alternative implementation
//        int j = 0;
//        for (int i = min; i <= max; i++) {
//            while (countArray[i - min] > 0) {
//                input[j++] = i;
//                countArray[i - min]--;
//            }
//        }
    }

}
