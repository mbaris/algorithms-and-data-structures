package io.baris.algs.sorting;


public class MergeSortBottomUpTest extends SortingTestBase {


    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new MergeSortBottomUp<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new MergeSortBottomUp<>();
    }
}