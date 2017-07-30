package io.baris.algs.sorting;


public class HeapSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	public void sort(Comparable<T>[] a) {
		int size = a.length-1;
		for (int k = size / 2; k >= 1; k--) {
			sink(a, k, size);
		}
		while (size > 1) {
			exchange(a, 1, size--);
			sink(a, 1, size);
		}
	}

	private void sink(Comparable<T>[] a, int k, int size) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(a[j], a[j + 1])) {
				j++;
			}
			if (!less(a[k], a[j])) {
				break;
			}
			exchange(a, k, j);
			k = j;
		}
	}

    @Override
	public boolean isSorted(Comparable<T>[] a) {
		for (int i = 2; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}
}
