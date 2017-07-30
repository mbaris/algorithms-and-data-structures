package io.baris.algs.sorting;

public class MergeSort<T extends Comparable<T>> extends MergeSortBase<T>{

	public void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}

	private void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo + CUTOFF - 1) {
			new InsertionSort<>().sort(a, lo, hi);
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
}
