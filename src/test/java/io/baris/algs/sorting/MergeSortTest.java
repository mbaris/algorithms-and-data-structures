package io.baris.algs.sorting;

public class MergeSortTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new MergeSort<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new MergeSort<>();
    }
}
