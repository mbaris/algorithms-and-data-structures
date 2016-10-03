package io.baris.algs.sorting;

import java.util.Random;

public class SortingTestBase {

	protected static final int RANDOM_COUNT = 1000000;
	protected static final int RANDOM_MAX = 7500000;

	protected Integer[] generateRandomNumberArray(int size, int rndInterval) {
		Random rnd = new Random();
		Integer[] numbers = new Integer[size];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rnd.nextInt(rndInterval);
		}
		return numbers;
	}

}
