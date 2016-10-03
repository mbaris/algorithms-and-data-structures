package io.baris.algs.queue;

public interface Queue<Item> extends Iterable<Item>{

	public void enqueue(Item s);

	public Item dequeue();

	public boolean isEmpty();

	public int size();
}
