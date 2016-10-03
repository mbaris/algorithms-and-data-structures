package io.baris.algs.pqueue;

import java.util.Iterator;

import io.baris.algs.queue.Queue;

public class UnorderedMaxPriorityQueue<Key extends Comparable<Key>> implements Queue<Key> {

	private Key[] queue;
	private int size = 0;

	private boolean less(int i, int j) {
		return queue[i].compareTo(queue[j]) < 0;
	}

	private void exch(int i, int j) {
		Key swap = queue[i];
		queue[i] = queue[j];
		queue[j] = swap;
	}

	// create an empty priority queue
	public UnorderedMaxPriorityQueue(int capacity) {
		queue = (Key[]) new Comparable[capacity];
	}

	// initialize priority queue with given values
	public UnorderedMaxPriorityQueue(Key[] initialValues) {
		queue = (Key[]) new Comparable[initialValues.length+1];
		for(Key key:initialValues){
			enqueue(key);
		}
	}

	public void enqueue(Key k) {
		queue[size++] = k;
	}

	public Key dequeue() {
		int max = 0;
		for (int i = 1; i < size; i++) {
			if (less(max, i)) {
				max = i;
			}
		}
		exch(max, size - 1);
		return queue[--size];
	}

	// is the priority queue empty
	public boolean isEmpty() {
		return size == 0;
	}

	// number of keys in priority queue
	public int size() {
		return size;
	}

	private class UnorderedMaxQueueIterator implements Iterator<Key> {

		private int i = 0;

		public boolean hasNext() {
			return i < size;
		}

		public Key next() {
			return queue[i++];
		}

	}

	public Iterator<Key> iterator() {
		return new UnorderedMaxQueueIterator();
	}

}
