package com.rp199.sort.algorithm;

/**
 * Implementation of Selection Sort algorithm
 * O(n^2) complexity -> Unstable algorithm
 */
public class SelectionSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if (array[largest] < array[i]) {
                    largest = i;
                }
            }
            swap(array, largest, lastUnsortedIndex);
        }

    }
}
