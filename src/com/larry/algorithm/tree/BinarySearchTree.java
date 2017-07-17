package com.larry.algorithm.tree;

public class BinarySearchTree<T extends Comparable<? super T>> {

	protected BinaryNode<T> mRoot;

	public BinarySearchTree() {
		super();
		mRoot = null;
	}

	public boolean isEmpty() {
		return mRoot == null;
	}

	public boolean contains(T e) {
		return contains(e, mRoot);
	}

	public T findMin() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMin(mRoot).getElement();
	}

	public T findMax() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMax(mRoot).getElement();
	}

	public void insert(T e) {
		mRoot = insert(e, mRoot);
	}

	public void remove(T e) {
		mRoot = remove(e, mRoot);
	}

	public void printTree() {
		if (isEmpty()) {
			System.out.println("Emprty tree!!!");
		} else {
			printTree(mRoot);
		}
	}

	/**
	 * O(logN)的最大复杂度
	 * 
	 * @param e
	 * @param root
	 * @return
	 */
	private boolean contains(T e, BinaryNode<T> root) {
		// 1、如果为null，则为false
		if (root == null) {
			return false;
		}
		// 2、比较跟节点
		int compareResult = e.compareTo(root.getElement());

		// 3、递归
		if (compareResult > 0) {
			// 如果比根节点大，就和右孩子比较
			return contains(e, root.getRight());
		} else if (compareResult < 0) {
			// 如果比跟节点小，就和左孩子比较
			return contains(e, root.getLeft());
		} else {
			// 等于0表示，相等
			return true;
		}
	}

	private BinaryNode<T> findMin(BinaryNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.getLeft() == null) {
			return root;
		} else {
			return findMin(root.getRight());
		}
	}

	private BinaryNode<T> findMax(BinaryNode<T> root) {
		if (root != null) {
			while (root.getRight() != null) {
				root = root.getRight();
			}
		}
		return root;
	}

	protected BinaryNode<T> insert(T e, BinaryNode<T> root) {
		if (root == null) {
			return new BinaryNode<>(e);
		}

		int compareResult = e.compareTo(root.getElement());

		if (compareResult < 0) {
			root.setLeft(insert(e, root.getLeft()));
		} else if (compareResult > 0) {
			root.setRight(insert(e, root.getRight()));
		} else {
			// 相同的节点，不做任何事情
		}

		return root;
	}

	/**
	 * 查询到想要的值,3种情况：树叶；一个孩子；两个孩子<br/>
	 * 两个孩子孩子时，查找右子树的最小值代替该节点的数据，并递归删除的那个节点。
	 * 
	 * @param e
	 * @param root
	 * @return
	 */
	private BinaryNode<T> remove(T e, BinaryNode<T> root) {
		if (root == null) {
			return null;
		}

		int compareResult = e.compareTo(root.getElement());

		if (compareResult < 0) {
			root.setLeft(remove(e, root.getLeft()));
		} else if (compareResult > 0) {
			root.setRight(remove(e, root.getRight()));
		} else if (root.getLeft() != null && root.getRight() == null) {
			// 两个孩子
			BinaryNode<T> rightMin = findMin(root.getRight());
			root.setElement(rightMin.getElement());
			root.setRight(remove(root.getElement(), root.getRight()));

		} else {
			// 树叶或者一个孩子
			root = (root.getLeft() != null) ? root.getLeft() : root.getRight();
		}
		return root;
	}

	private void printTree(BinaryNode<T> root) {

		if (root != null) {
			printTree(root.getLeft());
			System.out.println(root.getElement());
			printTree(root.getRight());
		}

	}

	public static void main(String[] args) {
		BinarySearchTree<Integer> bsTress = new BinarySearchTree();
		bsTress.insert(10);
		bsTress.insert(3);
		bsTress.insert(2);
		bsTress.insert(6);
		bsTress.insert(1);
		bsTress.insert(8);

		bsTress.printTree();

		bsTress.insert(11);
		bsTress.printTree();
	}

}
