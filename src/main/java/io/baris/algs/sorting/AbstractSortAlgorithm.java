package io.baris.algs.sorting;

public abstract class AbstractSortAlgorithm<T extends Comparable<T>> implements SortingAlgorithm<T> {

	final int CUTOFF = 5;

	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	public void exchange(Comparable<T>[] a, int i, int j) {
		Comparable<T> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public boolean isSorted(Comparable<T>[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

	public String getAlgorithmName() {
		return getClass().getSimpleName();
	}
}
