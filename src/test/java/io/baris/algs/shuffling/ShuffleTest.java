package io.baris.algs.shuffling;

import java.util.Arrays;

import org.junit.Test;

public class ShuffleTest {

	@Test
	public void knuthShuffleTest() {
		Integer[] numbers = new Integer[100];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
		}
		System.out.println("Numbers before shuffling:" + Arrays.asList(numbers).subList(0, 50));
		KnuthShuffle.shuffle(numbers);
		System.out.println("Numbers after shuffling:" + Arrays.asList(numbers).subList(0, 50));
	}

}
