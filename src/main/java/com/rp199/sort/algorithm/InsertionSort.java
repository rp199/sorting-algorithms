package com.rp199.sort.algorithm;

/**
 * Implementation of InsertionSort Sort algorithm
 * O(n^2) complexity -> Stable algorithm
 */
public class InsertionSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }
            array[i] = newElement;
        }
    }
}
