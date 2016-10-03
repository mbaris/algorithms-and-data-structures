package io.baris.algs.sorting;

public class MergeSort extends SortAlgorithmBase {

	private static Comparable[] aux;

	public static void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			InsertionSort.sort(a, lo, hi);
		}
		if (hi <= lo) {
			return;
		}
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid + 1, hi);
		if (!less(a[mid + 1], a[mid])) {
			return;
		}
		merge(a, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

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
