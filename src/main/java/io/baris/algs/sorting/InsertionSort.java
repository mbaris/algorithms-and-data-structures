package io.baris.algs.sorting;

public class InsertionSort extends SortAlgorithmBase {

	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo; i < hi; i++) {
			for (int j = i; j > lo; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
				} else {
					break;
				}
			}
		}
	}

	public static void sort(Comparable[] a) {
		sort(a,0,a.length);
	}
}
