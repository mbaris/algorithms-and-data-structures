package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest extends SortingTestBase {

	@Test
	public void testIntegerSorting() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		System.out.println("Merge Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		MergeSort.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void testStringSorting() {
		String quote = "would you tell me please which way i ought to go from here";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		MergeSort.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}

	@Test
	public void testBottomUpIntegerSorting() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		System.out.println("Merge Sort Bottom Up");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		MergeSortBottomUp.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void testBottomUpStringSorting() {
		String quote = "if everybody minded their own business the world would go around a great deal faster than it does";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		MergeSortBottomUp.sort(strings);
		System.out.println("Quote after Sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}
}
