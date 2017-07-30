package io.baris.algs.pqueue;

import io.baris.algs.queue.Queue;

import java.util.Iterator;

public class MaxPriorityQueue<Key extends Comparable<Key>> implements Queue<Key> {

	private Key[] queue;
	private int size = 0;

	// create an empty priority queue
	public MaxPriorityQueue(int capacity) {
		// 0th element will always be empty, so we use capacity+1
		queue = (Key[]) new Comparable[capacity + 1];
	}

	// initialize priority queue with given values
	public MaxPriorityQueue(Key[] initialValues) {
		queue = (Key[]) new Comparable[initialValues.length + 1];
		for (Key key : initialValues) {
			enqueue(key);
		}
	}

	public void enqueue(Key k) {
		queue[++size] = k;
		swim(size);
	}

	public Key dequeue() {
		Key max = queue[1];
		exch(1, size--);
		sink(1);
		queue[size + 1] = null;
		return max;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	private boolean less(int i, int j) {
		return queue[i].compareTo(queue[j]) < 0;
	}

	private void exch(int i, int j) {
		Key swap = queue[i];
		queue[i] = queue[j];
		queue[j] = swap;
	}

	// if a leaf node is larger than its parent, swap them and compare it with
	// its new parent
	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	// if a parent node is smaller than either of its leaf nodes, swap it with
	// the larger one, compare the swapped node with its new leaf nodes
	private void sink(int k) {
		while (2 * k <= size) {
			int j = 2 * k;
			if (j < size && less(j, j + 1)) {
				j++;
			}
			if (!less(k, j)) {
				break;
			}
			exch(k, j);
			k = j;
		}
	}

	private class MaxPriorityQueueIterator implements Iterator<Key> {

		private int i = 1;

		public boolean hasNext() {
			return i < size + 1;
		}

		public Key next() {
			return queue[i++];
		}

	}

	public Iterator<Key> iterator() {
		return new MaxPriorityQueueIterator();
	}
}