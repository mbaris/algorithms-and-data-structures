package io.baris.algs.stack;

import java.util.Iterator;

public class FixedCapacityStack<Item> implements Iterable<Item>, Stack<Item> {
	public Item[] itemArray;
	private int current = 0;

	public FixedCapacityStack(int capacity) {
		itemArray = (Item[]) new Object[capacity];
	}

	public boolean isEmpty() {
		return current == 0;
	}

	public void push(Item pushedItem) {
		itemArray[current++] = pushedItem;
	}

	public Item pop() {
		Item item = itemArray[--current];
		itemArray[current] = null;
		return item;
	}

	public Iterator<Item> iterator() {
		return new ReverseArrayIterator();
	}

	private class ReverseArrayIterator implements Iterator<Item> {

		private int i = current;

		public boolean hasNext() {
			return i > 0;
		}

		public Item next() {
			return itemArray[--i];
		}

	}
}
