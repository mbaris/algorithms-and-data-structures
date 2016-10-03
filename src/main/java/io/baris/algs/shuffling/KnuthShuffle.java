package io.baris.algs.shuffling;

import java.util.Random;

import io.baris.algs.sorting.SortAlgorithmBase;

public class KnuthShuffle extends SortAlgorithmBase {
	public static void shuffle(Comparable[] a) {
		Random rnd = new Random();
		for (int i = 0; i < a.length; i++) {
			int r = rnd.nextInt(i + 1);
			exch(a, i, r);
		}
	}
}
