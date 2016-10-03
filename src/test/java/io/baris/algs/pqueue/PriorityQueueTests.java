package io.baris.algs.pqueue;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PriorityQueueTests {
	@Test
	public void testMaxPriorityQueue() {
		Integer[] ints = { 2, 5, 8, 12, 43453, 65, 46, 4, 23, 879, 342, 34, 234 };
		MaxPriorityQueue<Integer> q = new MaxPriorityQueue<Integer>(ints);
		List<Integer> exclusion = new ArrayList<Integer>();
		while (q.isEmpty() != true) {
			Integer dequeue = q.dequeue();
			assertTrue(dequeue.equals(max(ints, exclusion)));
			exclusion.add(dequeue);
		}
	}

	@Test
	public void testUnorderedMaxPriorityQueue() {
		Integer[] ints = { 1, 56, 67, 21, 100, 57, 23, 87 };
		UnorderedMaxPriorityQueue<Integer> q = new UnorderedMaxPriorityQueue<Integer>(ints);
		int counter = 0;
		for (Integer i : q) {
			assertTrue(i.equals(ints[counter++]));
		}
		List<Integer> exclusion = new ArrayList<Integer>();
		while (q.isEmpty() != true) {
			Integer dequeue = q.dequeue();
			assertTrue(dequeue.equals(max(ints, exclusion)));
			exclusion.add(dequeue);
		}
	}

	private int max(Integer[] array, List<Integer> exclusion) {
		int max = 0;
		for (int i = 1; i < array.length; i++) {
			if (array[i] > array[max] && !exclusion.contains(array[i])) {
				max = i;
			}
		}
		return array[max];
	}
}
