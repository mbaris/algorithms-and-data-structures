package io.baris.algs.sorting;

public class MergeSortBottomUp<T extends Comparable<T>> extends MergeSortBase<T>{

    public void sort(Comparable[] a) {
        Comparable[] aux = new Comparable[a.length];
		for (int sz = 1; sz < a.length; sz = sz + sz) {
			for (int lo = 0; lo < a.length - sz; lo += sz + sz) {
				merge(a, aux,lo, lo + sz - 1, Math.min(lo + sz + sz - 1, a.length - 1));
			}
		}
	}
}
