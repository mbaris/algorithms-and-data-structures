package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SelectionSortTest extends SortingTestBase {

	@Test
	public void testIntegerSort() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT / 100, RANDOM_MAX);
		System.out.println("Selection Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		SelectionSort.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void testStringSort() {
		String quote = "its no use going back because i was a different person back then";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		SelectionSort.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}
}
