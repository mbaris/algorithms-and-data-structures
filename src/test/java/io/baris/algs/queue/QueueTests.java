package io.baris.algs.queue;

import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

public class QueueTests {

	@Test
	public void initTests() {
		Queue<String> linkedListQueue = new LinkedListQueue<String>();
		queueTest(linkedListQueue);
		Queue<String> arrayQueue = new FixedCapacityQueue<String>(20);
		queueTest(arrayQueue);
	}

	private void queueTest(Queue<String> queue) {
		for (int i = 0; i < 10; i++) {
			queue.enqueue("roses");
			queue.enqueue("are");
			assertSame(queue.dequeue(), "roses");
			queue.enqueue("FF0000");
			queue.enqueue("violets");
			assertSame(queue.dequeue(), "are");
			assertSame(queue.dequeue(), "FF0000");
			queue.enqueue("are");
			queue.enqueue("0000FF");
			assertSame(queue.dequeue(), "violets");
			assertSame(queue.dequeue(), "are");
			assertSame(queue.dequeue(), "0000FF");
			assertNull(queue.dequeue());
		}
	}
}
