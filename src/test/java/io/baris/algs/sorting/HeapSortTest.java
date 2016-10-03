package io.baris.algs.sorting;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HeapSortTest extends SortingTestBase {

	@Test
	public void testStringSorting() {
		String quote = "but i dont want to go among mad people";
		List<String> asList = new ArrayList<String>(Arrays.asList(quote.split(" ")));
		asList.add(0, null);
		String[] strings = new String[asList.size()];
		asList.toArray(strings);
		System.out.println("Quote:" + Arrays.asList(strings));
		HeapSort.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(HeapSort.isSorted(strings));
	}

	@Test
	public void testIntegerSorting() {
		Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		List<Integer> asList = new ArrayList<Integer>(Arrays.asList(numbers));
		asList.add(0, null);
		asList.toArray(numbers);
		System.out.println("Heap Sort");
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		HeapSort.sort(numbers);
		System.out.println("Number array after sorting:" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(HeapSort.isSorted(numbers));
	}

}
