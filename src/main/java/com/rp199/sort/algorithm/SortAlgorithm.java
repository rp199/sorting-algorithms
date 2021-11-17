package com.rp199.sort.algorithm;

public interface SortAlgorithm {
    void sort(int[] array);

    default void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
