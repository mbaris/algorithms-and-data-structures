package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ShellSortTest extends SortingTestBase {
	@Test
	public void testIntegerSort() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		System.out.println("Shell Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		ShellSort.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void testStringSort() {
		String quote = "why sometimes i have believed as many as six impossible things before breakfast";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		ShellSort.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}

}
