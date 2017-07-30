package io.baris.algs.sorting;


public class QuickSort3WayTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new QuickSort3Way<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new QuickSort3Way<>();

    }
}
