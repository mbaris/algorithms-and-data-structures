package io.baris.algs.queue;

import java.util.Iterator;

public class LinkedListQueue<Item> implements Queue<Item> {

	private Node last;
	private Node first;

	private class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if (isEmpty()) {
			first = last;
		} else {
			oldLast.next = last;
		}

	}

	public Item dequeue() {
		if (isEmpty()) {
			return null;
		}
		Item item = first.item;
		first = first.next;
		if (isEmpty()) {
			last = null;
		}
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		int count = 0;
		Node iter = first;
		while (iter.next != null) {
			count++;
		}
		return count;
	}

	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator<Item> {

		private Node current = first;

		public boolean hasNext() {
			return current != null;
		}

		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
	}
}