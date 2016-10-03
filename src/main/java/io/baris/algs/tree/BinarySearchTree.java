package io.baris.algs.tree;

import io.baris.algs.queue.LinkedListQueue;
import io.baris.algs.queue.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node root;

	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node x, Key key, Value value) {
		if (x == null) {
			return new Node(key, value);
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = put(x.left, key, value);
		} else if (cmp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

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

	public int rank(Key key) {
		return rank(key, root);
	}

	private int rank(Key key, Node node) {
		if (node == null) {
			return 0;
		}
		int cmp = key.compareTo(node.key);
		if (cmp < 0) {
			return rank(key, node.left);
		} else if (cmp > 0) {
			return 1 + size(node.left) + rank(key, node.right);
		} else {
			return size(node.left);
		}
	}

	public void delete(Key key) {
		root = delete(root, key);
	}

	private Node delete(Node x, Key key) {
		if (x == null) {
			return null;
		}
		int cmp = key.compareTo(x.key);
		if (cmp < 0) {
			x.left = delete(x.left, key);
		} else if (cmp > 0) {
			x.right = delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.count = size(x.left) + size(x.right) + 1;
		return x;
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

	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}
		x.left = deleteMin(x.left);
		x.count = 1 + size(x.left) + size(x.right);
		return x;
	}

	public int size() {
		return size(root);
	}

	public int size(Key lo, Key hi) {
		if (contains(hi)) {
			return rank(hi) - rank(lo) + 1;
		} else {
			return rank(hi) - rank(lo);
		}
	}

	private boolean contains(Key key) {
		return get(key) != null;
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		} else {
			return x.count;
		}
	}

	public Key floor(Key key) {
		Node x = floor(root, key);
		if (x == null) {
			return null;
		}
		return x.key;
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

	class Node {
		private Key key;
		private Value value;
		private Node left;
		private Node right;
		private int count;

		public Node(Key key, Value value) {
			this.key = key;
			this.value = value;
			this.count = 0;
		}

		public Value getValue() {
			return value;
		}

		public Key getKey() {
			return key;
		}
	}
}
