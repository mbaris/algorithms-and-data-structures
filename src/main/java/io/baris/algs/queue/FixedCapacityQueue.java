package io.baris.algs.queue;

import java.util.Iterator;

public class FixedCapacityQueue<Item> implements Queue<Item> {

	public Item[] itemArray;
	private int first = 0;
	private int last = 0;

	public FixedCapacityQueue(int capacity) {
		/*
		 * normally, we would like to use " itemArray = new Item[capacity];"
		 * instead of casting in this place but creating generic arrays is not
		 * permitted in java
		 */

		itemArray = (Item[]) new Object[capacity];
	}

	public void enqueue(Item s) {
		itemArray[first] = s;
		first = (first + 1) % itemArray.length;
	}

	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		Item item = itemArray[last];
		itemArray[last] = null;
		last = (last + 1) % itemArray.length;
		return item;
	}

	public boolean isEmpty() {
		return itemArray[last] == null;
	}

	public int size() {
		if (first > last) {
			return first - last;
		} else {
			return first + itemArray.length - last;
		}
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = last;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return itemArray[--i];
		}

	}
}
