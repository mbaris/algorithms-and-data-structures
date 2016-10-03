package io.baris.algs.tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import io.baris.algs.sorting.MergeSort;

public class BinarySearchTreeTest {

	@Test
	public void testBSTString() {
		BinarySearchTree<String, String> bst = new BinarySearchTree<String, String>();
		bst.put("at", "the");
		bst.put("always", "look");
		bst.put("bright", "side");
		bst.put("of", "life");
		bst.deleteMin();
		for (String key : bst.iterator()) {
			if (key.equals("always")) {
				fail();
			}
		}
		bst.deleteMin();
		for (String key : bst.iterator()) {
			if (key.equals("always") || key.equals("at")) {
				fail();
			}
		}
		bst.deleteMin();
		for (String key : bst.iterator()) {
			if (key.equals("always") || key.equals("at") || key.equals("bright")) {
				fail();
			}
		}
		bst.deleteMin();
		for (String key : bst.iterator()) {
			if (key.equals("of") || key.equals("always") || key.equals("at") || key.equals("bright")) {
				fail();
			}
		}
	}

	// insert 10000 random numbers into a binary search tree, use deleteMin
	// function to delete the smallest
	// sort the random number array and use it for validation
	@Test
	public void testBSTInteger() {
		BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<Integer, Integer>();
		Integer[] numbers = new Integer[10000];
		populateaCollections(numbers, bst);
		MergeSort.sort(numbers);
		int counter = 0;
		while (bst.size() > 0) {
			Integer bstMinKey = bst.min().getKey();
			Integer rndArrayMin = numbers[counter++];
			assertTrue(bstMinKey.equals(rndArrayMin));
			bst.deleteMin();
			assertTrue(bst.get(bstMinKey) == null);
		}

	}

	private Integer[] populateaCollections(Integer[] numbers, BinarySearchTree<Integer, Integer> bst) {
		Random random = new Random();
		for (int i = 0; i < 10000; i++) {
			int num = random.nextInt(250000);
			// check to see if the number is inserted before, if it is use a different number
			while (bst.get(num) != null) {
				num = random.nextInt(250000);
			}
			numbers[i] = num;
			bst.put(num, i);
		}
		return numbers;
	}

}
