package io.baris.algs.shuffling;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Arrays;

public class ShuffleTest {

	private Logger logger = Logger.getLogger(ShuffleTest.class);

	@Test
	public void knuthShuffleTest() {
		Integer[] numbers = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		logger.info("Numbers before shuffling:" + Arrays.asList(numbers).subList(0, 50));
		new KnuthShuffle<Integer>().shuffle(numbers);
		logger.info("Numbers after shuffling:" + Arrays.asList(numbers).subList(0, 50));
	}

}
