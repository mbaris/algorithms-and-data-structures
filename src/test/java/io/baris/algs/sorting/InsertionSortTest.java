package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class InsertionSortTest extends SortingTestBase {
	
	@Test
	public void testStringSorting() {
		String quote = "but i dont want to go among mad people";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		InsertionSort.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}

	@Test
	public void testIntegerSorting() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT / 100, RANDOM_MAX);
		System.out.println("Insertion Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		InsertionSort.sort(numbers);
		System.out.println("Number array after sorting:" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

}
