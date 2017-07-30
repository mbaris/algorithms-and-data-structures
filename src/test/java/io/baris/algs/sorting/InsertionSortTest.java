package io.baris.algs.sorting;

public class InsertionSortTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new InsertionSort<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new InsertionSort<>();
    }
}
