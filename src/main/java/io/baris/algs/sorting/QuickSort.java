package io.baris.algs.sorting;

import io.baris.algs.shuffling.KnuthShuffle;

public class QuickSort extends SortAlgorithmBase {

	public static void sort(Comparable[] a) {
		KnuthShuffle.shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}
		if (hi < lo + CUTOFF - 1) {
			InsertionSort.sort(a, lo, hi+1);
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
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
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
	}
}
