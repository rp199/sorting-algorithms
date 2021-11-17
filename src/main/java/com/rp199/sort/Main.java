package com.rp199.sort;

import com.rp199.sort.algorithm.BubbleSort;
import com.rp199.sort.algorithm.CountingSort;
import com.rp199.sort.algorithm.InsertionSort;
import com.rp199.sort.algorithm.MergeSort;
import com.rp199.sort.algorithm.QuickSort;
import com.rp199.sort.algorithm.RadixSort;
import com.rp199.sort.algorithm.SelectionSort;
import com.rp199.sort.algorithm.ShellSort;
import com.rp199.sort.algorithm.SortAlgorithm;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int[] intArray = {20, 35, -15, 7, 55, 1, -22};
        int[] countArrayData = {2, 5, 9, 8, 2, 8, 7, 10, 4, 3};
        int[] radixArray = {4725, 4586, 1330, 8792, 1594, 5729};

        var sorters = generateSorters(
                new BubbleSort(),
                new SelectionSort(),
                new InsertionSort(),
                new ShellSort(),
                new MergeSort(),
                new QuickSort(),
                new CountingSort(),
                new RadixSort()
        );


        sorters.stream().map(sorter -> {
            if (sorter.getSortAlgorithm() instanceof CountingSort) {
                return sorter.sortAsync(countArrayData);
            } else if (sorter.getSortAlgorithm() instanceof RadixSort) {
                return sorter.sortAsync(radixArray);
            }
            return sorter.sortAsync(intArray);
        }).collect(Collectors.toList())
                .forEach(CompletableFuture::join);
    }

    public static List<Sorter> generateSorters(SortAlgorithm... sortAlgorithms) {
        return Arrays.stream(sortAlgorithms).map(Sorter::new).collect(Collectors.toList());
    }
}
