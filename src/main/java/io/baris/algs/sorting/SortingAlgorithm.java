package io.baris.algs.sorting;

public interface SortingAlgorithm<T extends Comparable<T>> {

    boolean less(Comparable<T> v, Comparable<T> w);

    void exchange(Comparable<T>[] a, int i, int j);

    boolean isSorted(Comparable<T>[] a);

    void sort(Comparable<T>[] a);
}
