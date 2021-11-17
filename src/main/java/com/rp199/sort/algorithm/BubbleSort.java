package com.rp199.sort.algorithm;

/**
 * Implementation of BubbleSort Sort algorithm
 * O(n^2) complexity -> Stable algorithm
 */
public class BubbleSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        for (int lastUnsortedIndex = array.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i + 1);
                }
            }
        }
    }
}
