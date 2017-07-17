package com.larry.algorithm.tree;

/**
 * 带有平衡条件的二叉树
 * 
 * @author Larry
 *
 * @param <T>
 */

public class AvlNode<T> extends BinaryNode<T> {

	int height;

	public AvlNode(T element) {
		this(element, null, null);
	}

	public AvlNode(T element, AvlNode<T> left, AvlNode<T> right) {
		super(element, left, right);
		this.height = 0;
	}

}
