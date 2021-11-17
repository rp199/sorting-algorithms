package com.rp199.sort.algorithm;

/**
 * Implementation of Selection Sort algorithm using a simple gap calculation
 * Worst case scenario: O(n^2) complexity -> Unstable algorithm
 */
public class ShellSort implements SortAlgorithm {


    @Override
    public void sort(int[] array) {
        int initialGap = array.length / 2;

        for (int gap = initialGap; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];
                int j = i;

                while (j >= gap && array[j - gap] > newElement) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = newElement;
            }
        }
    }
}
