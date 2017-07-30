package io.baris.algs.sorting;

public class SelectionSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	public void sort(Comparable<T>[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (less(a[j], a[min])) {
					min = j;
				}
			}
			exchange(a, i, min);
		}
	}
}
