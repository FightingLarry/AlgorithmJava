package com.larry.algorithm.tree;

public class AvlSearchTree<T extends Comparable<? super T>> extends
		BinarySearchTree<T> {

	public AvlSearchTree() {
		super();
	}

	@Override
	protected BinaryNode<T> insert(T e, BinaryNode<T> root) {
		if (root == null) {
			return new AvlNode<T>(e, null, null);
		}

		int compareResult = e.compareTo(root.element);

		if (compareResult < 0) {
			root.left = insert(e, root.left);
		} else if (compareResult > 0) {
			root.right = insert(e, root.right);
		} else {

		}

		return blance((AvlNode<T>) root);
	}

	private AvlNode<T> blance(AvlNode<T> root) {

		return null;
	}
}
