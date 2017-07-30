package io.baris.algs.sorting;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public abstract class SortingTestBase {

    private final Logger logger = Logger.getLogger(getClass());

	private static final int RANDOM_COUNT = 1000;
	private static final int RANDOM_MAX = 7500000;

    @Test
    public void testStringSorting() {
        AbstractSortAlgorithm<String> stringSorter = getStringSorter();
        String quote = "but i don't want to go among mad people";
        String[] wordsArray = quote.split(" ");
        logger.info("Quote:" + Arrays.asList(wordsArray));
		stringSorter.sort(wordsArray);
        logger.info("Quote after sorting" + Arrays.asList(wordsArray));
		assertTrue(stringSorter.isSorted(wordsArray));
	}

    abstract AbstractSortAlgorithm<String> getStringSorter();

	@Test
	public void testIntegerSorting() {
        AbstractSortAlgorithm<Integer> integerSorter = getIntegerSorter();
        Integer[] numbers = generateRandomNumberArray(RANDOM_COUNT, RANDOM_MAX);
        logger.info(integerSorter.getAlgorithmName());
        logger.info("Random number array:" + Arrays.asList(numbers).subList(0, 50));
		integerSorter.sort(numbers);
        logger.info("Number array after sorting:" + Arrays.asList(numbers).subList(0, 50));
		assertTrue(integerSorter.isSorted(numbers));
	}

    abstract AbstractSortAlgorithm<Integer> getIntegerSorter();

    private Integer[] generateRandomNumberArray(int size, int rndInterval) {
        Random rnd = new Random();
        Integer[] numbers = new Integer[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(rndInterval);
        }
        return numbers;
    }
}
