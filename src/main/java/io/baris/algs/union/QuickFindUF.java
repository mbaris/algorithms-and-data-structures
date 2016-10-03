package io.baris.algs.union;

public class QuickFindUF implements UnionFindInterface {

	private int[] idArray;

	public QuickFindUF(int elementCount) {
		idArray = new int[elementCount];
		for (int i = 0; i < idArray.length; i++) {
			idArray[i] = i;
		}
	}

	public void union(int p, int q) {
		int qid = q;
		int pid = p;
		for (int i = 0; i < idArray.length; i++) {
			if (idArray[i] == pid) {
				idArray[i] = qid;
			}
		}
	}

	public boolean connected(int p, int q) {
		return idArray[p] == idArray[q];
	}

	public int find(int p) {
		return idArray[p];
	}

	public int count() {
		return idArray.length;
	}

}
