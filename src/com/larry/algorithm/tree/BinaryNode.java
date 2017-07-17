package com.larry.algorithm.tree;

public class BinaryNode<T> {

	T element;
	BinaryNode<T> left;
	BinaryNode<T> right;

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public BinaryNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryNode<T> left) {
		this.left = left;
	}

	public BinaryNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryNode<T> right) {
		this.right = right;
	}

	public BinaryNode(T element) {
		this(element, null, null);
	}

	public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
		super();
		this.element = element;
		this.left = left;
		this.right = right;
	}

}
