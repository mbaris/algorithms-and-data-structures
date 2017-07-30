package io.baris.algs.sorting;

public class ShellSortTest extends SortingTestBase {

    @Override
    AbstractSortAlgorithm<String> getStringSorter() {
        return new ShellSort<>();
    }

    @Override
    AbstractSortAlgorithm<Integer> getIntegerSorter() {
        return new ShellSort<>();
    }
}
