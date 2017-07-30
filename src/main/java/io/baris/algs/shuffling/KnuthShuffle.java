package io.baris.algs.shuffling;

import java.util.Random;

public class KnuthShuffle<T extends Comparable<T>> {
	public void shuffle(Comparable<T>[] a) {
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = rnd.nextInt(i + 1);
			exchange(a, i, r);
		}
	}

	private void exchange(Comparable<T>[] a, int i, int j) {
		Comparable<T> swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
}
