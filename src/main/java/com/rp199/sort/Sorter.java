package com.rp199.sort;

import com.rp199.sort.algorithm.SortAlgorithm;
import com.rp199.utils.TimeMeasure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MapMessage;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Sorter {

    private static final Logger LOGGER = LogManager.getLogger(Sorter.class);
    private final SortAlgorithm sortAlgorithm;

    public Sorter(SortAlgorithm sortAlgorithm) {
        this.sortAlgorithm = sortAlgorithm;
    }

    public int[] sort(int[] intArray) {
        int[] arrayCopy = intArray.clone();
        var elapsedTime = TimeMeasure.measure(() -> sortAlgorithm.sort(arrayCopy));
        printSortingResult(intArray, arrayCopy, elapsedTime);
        return arrayCopy;
    }

    public CompletableFuture<int[]> sortAsync(int[] intArray) {
        return CompletableFuture.supplyAsync(() -> sort(intArray));
    }

    private static boolean wasCorrectlySorted(int[] original, int[] result) {
        return Arrays.equals(Arrays.stream(original).sorted().toArray(), result);
    }


    public static String getArrayAsString(int[] array) {
        return Arrays.stream(array).boxed().map(i -> i + "").collect(Collectors.joining(","));
    }

    private void printSortingResult(int[] originalArray, int[] sortedArray, long elapsedTime) {
        MapMessage mapMsg = new MapMessage();
        mapMsg.put("Algorithm Name", sortAlgorithm.getClass().getSimpleName());
        mapMsg.put("Original Array", getArrayAsString(originalArray));
        mapMsg.put("Sorted Array", getArrayAsString(sortedArray));
        mapMsg.put("Elapsed Time(millis)", elapsedTime + "");
        mapMsg.put("Correctly Sorted:", wasCorrectlySorted(originalArray, sortedArray) + "");
        if (wasCorrectlySorted(originalArray, sortedArray)) {
            LOGGER.info(mapMsg);
        } else {
            LOGGER.error(mapMsg);
        }
    }

    public SortAlgorithm getSortAlgorithm() {
        return sortAlgorithm;
    }
}
