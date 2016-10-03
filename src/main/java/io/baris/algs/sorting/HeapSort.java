package io.baris.algs.sorting;

public class HeapSort {

	public static void sort(Comparable[] pq) {
		int size = pq.length-1;
		for (int k = size / 2; k >= 1; k--) {
			sink(pq, k, size);
		}
		while (size > 1) {
			exch(pq, 1, size--);
			sink(pq, 1, size);
		}
	}

	private static void sink(Comparable[] pq, int k, int size) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(pq[j], pq[j + 1])) {
				j++;
			}
			if (!less(pq[k], pq[j])) {
				break;
			}
			exch(pq, k, j);
			k = j;
		}
	}

	protected static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	protected static void exch(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i = 2; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
	}

}
