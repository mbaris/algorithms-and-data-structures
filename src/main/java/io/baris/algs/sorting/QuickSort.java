package io.baris.algs.sorting;

import io.baris.algs.shuffling.KnuthShuffle;

public class QuickSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	public void sort(Comparable<T>[] a) {
		new KnuthShuffle<T>().shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		if (hi < lo + CUTOFF - 1) {
			new InsertionSort<>().sort(a, lo, hi+1);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (less(a[++i], a[lo])) {
				if (i == hi) {
					break;
				}
			}
			while (less(a[lo], a[--j])) {
				if (j == lo) {
					break;
				}
			}
			if (i >= j) {
				break;
			}
			exchange(a, i, j);
		}
		exchange(a, lo, j);
		return j;
	}
}
