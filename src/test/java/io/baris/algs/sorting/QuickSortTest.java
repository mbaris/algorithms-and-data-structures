package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class QuickSortTest extends SortingTestBase {

	@Test
	public void testIntegerSort() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		System.out.println("Quick Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		QuickSort.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void testStringSort() {
		String quote = "imagination is the only weapon in the war against reality";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		QuickSort.sort(strings);
		System.out.println("Quote after Sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}

	@Test
	public void test3WayIntegerSort() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		System.out.println("Quick Sort 3 Way");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		QuickSort3Way.sort(numbers);
		System.out.println("Number array after sorting" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(SortAlgorithmBase.isSorted(numbers));
	}

	@Test
	public void test3WayStringSort() {
		String quote = "one pill makes you small one pill makes you larger the ones mother gives you doesnt do anything at all";
		String[] strings = quote.split(" ");
		System.out.println("Quote:" + Arrays.asList(strings));
		QuickSort3Way.sort(strings);
		System.out.println("Quote after Sorting" + Arrays.asList(strings));
		assertTrue(SortAlgorithmBase.isSorted(strings));
	}

}
