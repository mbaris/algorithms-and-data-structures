package io.baris.algs.union;

public class QuickUnionUF implements UnionFindInterface {

	private int[] idArray;
	private int[] sizeArray;

	public QuickUnionUF(int elementCount) {
		idArray = new int[elementCount];
		sizeArray = new int[elementCount];
		for (int i = 0; i < idArray.length; i++) {
			idArray[i] = i;
			sizeArray[i] = 1;
		}
	}

	private int root(int i) {
		while (i != idArray[i]) {
			idArray[i] = idArray[idArray[i]];
			i = idArray[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int count() {
		return idArray.length;
	}

	public void union(int p, int q) {
		int rootp = root(p);
		int rootq = root(q);
		if (sizeArray[rootp] < sizeArray[rootq]) {
			idArray[rootp] = rootq;
			sizeArray[rootq] += sizeArray[rootp];
		} else {
			idArray[rootq] = rootp;
			sizeArray[rootp] += sizeArray[rootq];
		}
		idArray[rootp] = rootq;
	}

	public int find(int p) {
		return idArray[p];
	}

}
