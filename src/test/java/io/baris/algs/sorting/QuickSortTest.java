package io.baris.algs.sorting;

public class QuickSortTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new QuickSort<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new QuickSort<>();

    }
}
