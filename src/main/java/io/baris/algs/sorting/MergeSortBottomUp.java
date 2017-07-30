package io.baris.algs.sorting;

public class MergeSortBottomUp<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	private static Comparable[] aux;

	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		for (int sz = 1; sz < a.length; sz = sz + sz) {
			for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
				merge(a, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
			}
		}
	}

	private void merge(Comparable[] a, int lo, int mid, int hi) {

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
