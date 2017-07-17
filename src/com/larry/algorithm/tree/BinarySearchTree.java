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
	 * O(logN)������Ӷ�
	 * 
	 * @param e
	 * @param root
	 * @return
	 */
	private boolean contains(T e, BinaryNode<T> root) {
		// 1�����Ϊnull����Ϊfalse
		if (root == null) {
			return false;
		}
		// 2���Ƚϸ��ڵ�
		int compareResult = e.compareTo(root.getElement());

		// 3���ݹ�
		if (compareResult > 0) {
			// ����ȸ��ڵ�󣬾ͺ��Һ��ӱȽ�
			return contains(e, root.getRight());
		} else if (compareResult < 0) {
			// ����ȸ��ڵ�С���ͺ����ӱȽ�
			return contains(e, root.getLeft());
		} else {
			// ����0��ʾ�����
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
			// ��ͬ�Ľڵ㣬�����κ�����
		}

		return root;
	}

	/**
	 * ��ѯ����Ҫ��ֵ,3���������Ҷ��һ�����ӣ���������<br/>
	 * �������Ӻ���ʱ����������������Сֵ����ýڵ�����ݣ����ݹ�ɾ�����Ǹ��ڵ㡣
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
			// ��������
			BinaryNode<T> rightMin = findMin(root.getRight());
			root.setElement(rightMin.getElement());
			root.setRight(remove(root.getElement(), root.getRight()));

		} else {
			// ��Ҷ����һ������
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
