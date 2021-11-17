package com.rp199.sort.algorithm;

import java.util.function.BiPredicate;

/**
 * Implementation of Merge Sort algorithm
 * O(nlog n) complexity
 */
public class MergeSort implements SortAlgorithm {

    @Override
    public void sort(int[] array) {
        mergeSort(array, 0, array.length);
    }

    private static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end, true);
    }

    private static void merge(int[] input, int start, int mid, int end, boolean asc) {
        BiPredicate<Integer, Integer> sortDirectionPredicate = (f, s) -> f.compareTo(s) > 0;
        if (asc) {
            sortDirectionPredicate = sortDirectionPredicate.negate();
        }

        sortDirectionPredicate = sortDirectionPredicate.or((f, s) -> f.compareTo(s) == 0);

        if (sortDirectionPredicate.test(input[mid - 1], input[mid])) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = sortDirectionPredicate.test(input[i], input[j]) ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);

    }

}