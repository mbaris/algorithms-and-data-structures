package io.baris.algs.stack;

import org.junit.Test;

import static org.junit.Assert.assertSame;

public class StackTests {

	@Test
	public void linkedListBasedStackTest() {
		Stack<String> stack = new LinkedListStack<String>();
		stack.push("to");
		stack.push("be");
		assertSame("be", stack.pop());
		stack.push("or");
		assertSame("or", stack.pop());
		stack.push("not");
		stack.push("to");
		assertSame("to", stack.pop());
		stack.push("be");
		assertSame("be", stack.pop());
		assertSame("not", stack.pop());
		assertSame("to", stack.pop());
	}

	@Test
	public void fixedCapacityStackTest() {
		Stack<String> stack = new FixedCapacityStack<String>(6);
		stack.push("all");
		assertSame("all", stack.pop());
		stack.push("your");
		stack.push("base");
		stack.push("are");
		stack.push("belong");
		assertSame("belong", stack.pop());
		assertSame("are", stack.pop());
		assertSame("base", stack.pop());
		assertSame("your", stack.pop());
		stack.push("to");
		stack.push("us");
		assertSame("us", stack.pop());
		assertSame("to", stack.pop());
	}

}
