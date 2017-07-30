package io.baris.algs.sorting;

abstract class MergeSortBase<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {
    void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        System.arraycopy(a, lo, aux, lo, hi + 1 - lo);
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }
}
