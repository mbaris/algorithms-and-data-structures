package io.baris.algs.sorting;

public class SelectionSortTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new SelectionSort<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new SelectionSort<>();
    }
}
