package io.baris.algs.sorting;

public class ShellSort<T extends Comparable<T>> extends AbstractSortAlgorithm<T> {

	public void sort(Comparable<T>[] a) {
		int h = 1;
		while (h < a.length / 3) {
			h = 3 * h + 1;
		}
		while (h >= 1) {
			for (int i = 0; i < a.length; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exchange(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

}
