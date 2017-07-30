package io.baris.algs.sorting;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public abstract class SortingTestBase {

	private static final int RANDOM_COUNT = 1000;
	private static final int RANDOM_MAX = 7500000;

	private Integer[] generateRandomNumberArray(int size, int rndInterval) {
		Random rnd = new Random();
		Integer[] numbers = new Integer[size];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = rnd.nextInt(rndInterval);
		}
		return numbers;
	}

    abstract AbstractSortAlgorithm<String> getStringSorter();

    abstract AbstractSortAlgorithm<Integer> getIntegerSorter();

    @Test
    public void testStringSorting() {
        AbstractSortAlgorithm<String> stringSorter = getStringSorter();
        String quote = "but i dont want to go among mad people";
		List<String> asList = new ArrayList<String>(Arrays.asList(quote.split(" ")));
		String[] strings = new String[asList.size()];
		asList.toArray(strings);
		System.out.println("Quote:" + Arrays.asList(strings));
		stringSorter.sort(strings);
		System.out.println("Quote after sorting" + Arrays.asList(strings));
		assertTrue(stringSorter.isSorted(strings));
	}

	@Test
	public void testIntegerSorting() {
        AbstractSortAlgorithm<Integer> integerSorter = getIntegerSorter();
        Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
		List<Integer> asList = new ArrayList<Integer>(Arrays.asList(numbers));
		asList.add(0, null);
		asList.toArray(numbers);
		System.out.println(integerSorter.getAlgorithmName());
		System.out.println("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		integerSorter.sort(numbers);
		System.out.println("Number array after sorting:" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(integerSorter.isSorted(numbers));
	}
}
