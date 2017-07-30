package io.baris.algs.sorting;

import io.baris.algs.shuffling.KnuthShuffle;

public class QuickSort3Way<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

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

		int lt = lo;
		int gt = hi;
		Comparable v = a[lo];
		int i = lo;
		while (i <= gt) {
			int cmp = a[i].compareTo(v);
			if (cmp < 0) {
				exchange(a, i++, lt++);
			} else if (cmp > 0) {
				exchange(a, i, gt--);
			} else {
				i++;
			}
		}
		sort(a, lo, lt - 1);
		sort(a, gt + 1, hi);

	}

}
