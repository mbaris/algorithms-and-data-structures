package io.baris.algs.tree;

import io.baris.algs.queue.LinkedListQueue;
import io.baris.algs.queue.Queue;

public class LeftLeaningRedBlackTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public Value get(Key key) {
		Node x = root;
		while (x != null) {
			int cmp = key.compareTo(x.key);
			if (cmp < 0) {
				x = x.left;
			} else if (cmp > 0) {
				x = x.right;
			} else {
				return x.value;
			}
		}
		return null;
	}

	public Node put(Node h, Key key, Value value) {
		if (h == null) {
			return new Node(key, value, RED);
		}
		int cmp = key.compareTo(h.key);
		if (cmp < 0) {
			h.left = put(h.left, key, value);
		} else if (cmp > 0) {
			h.right = put(h.right, key, value);
		} else {
			h.value = value;
		}
		if (isRed(h.right) && !isRed(h.left)) {
			h = rotateLeft(h);
		}
		if (isRed(h.left) && isRed(h.left.left)) {
			h = rotateRight(h);
		}
		if (isRed(h.left) && isRed(h.right)) {
			flipColors(h);
		}
		return h;
	}

	public Node min() {
		return min(root);
	}

	private Node min(Node x) {
		if (x.left != null) {
			return min(x.left);
		} else {
			return x;
		}
	}

	public Node max() {
		return min(root);
	}

	private Node max(Node x) {
		if (x.right != null) {
			return max(x.right);
		} else {
			return x;
		}
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node rotateLeft(Node h) {
		Node x = h.right;
		h.right = x.left;
		x.left = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private Node rotateRight(Node h) {
		Node x = h.left;
		h.left = x.right;
		x.right = h;
		x.color = h.color;
		h.color = RED;
		return x;
	}

	private void flipColors(Node h) {
		h.color = RED;
		h.left.color = BLACK;
		h.right.color = BLACK;
	}

	private Node floor(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		} else if (cmp < 0) {
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	public Key ceiling(Key key) {
		Node x = ceiling(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
	}

	private Node ceiling(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp == 0) {
			return x;
		} else if (cmp > 0) {
			return ceiling(x.right, key);
		}

		Node t = ceiling(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	public Iterable<Key> iterator() {
		Queue<Key> queue = new LinkedListQueue<Key>();
		inorder(root, queue);
		return queue;
	}

	private void inorder(Node node, Queue<Key> queue) {
		if (node == null) {
			return;
		}
		inorder(node.left, queue);
		queue.enqueue(node.key);
		inorder(node.right, queue);
	}

	private static final boolean RED = true;
	private static final boolean BLACK = false;

	private class Node {
		Key key;
		Value value;
		Node left;
		Node right;
		boolean color;

		Node(Key key, Value value, boolean color) {
			this.key = key;
			this.value = value;
			this.color = color;
		}

	}

	private boolean isRed(Node x) {
		if (x == null) {
			return false;
		}
		return x.color;
	}
}
