package com.rp199.sort.algorithm;

/**
 * Implementation of Quick Sort algorithm
 * O(nlog n) complexity -> best case
 * O(n^2) complexity -> worst case
 */
public class QuickSort implements SortAlgorithm {
    @Override
    public void sort(int[] array) {
        quickSort(array, 0, array.length);
    }

    private static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    private static int partition(int[] input, int start, int end) {
        // This is using the first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {

            // NOTE: empty loop body
            while (i < j && input[--j] >= pivot) ;
            if (i < j) {
                input[i] = input[j];
            }

            // NOTE: empty loop body
            while (i < j && input[++i] <= pivot) ;
            if (i < j) {
                input[j] = input[i];
            }

        }

        input[j] = pivot;
        return j;

    }
}
