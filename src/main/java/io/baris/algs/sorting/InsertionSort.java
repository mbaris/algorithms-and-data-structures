package io.baris.algs.sorting;

public class InsertionSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	public void sort(Comparable<T>[] a, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo; j--) {
				if (less(a[j], a[j - 1])) {
					exchange(a, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public void sort(Comparable<T>[] a) {
		sort(a,0,a.length);
	}
}
