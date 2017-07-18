package com.larry.algorithm.tree;

public class AvlSearchTree<T extends Comparable<? super T>> {

	private static final int ALLOW_IMBALANCE = 1;

	private AvlNode<T> mRoot;

	public AvlSearchTree() {
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
		return findMin(mRoot).element;
	}

	public T findMax() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMax(mRoot).element;
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
			System.out.println("��=============");
			printTree(mRoot);
			System.out.println("��=============");
			printTreeFirst(mRoot);
			System.out.println("��=============");
			printTreeLast(mRoot);
		}
	}

	/**
	 * O(logN)������Ӷ�
	 * 
	 * @param e
	 * @param root
	 * @return
	 */
	private boolean contains(T e, AvlNode<T> root) {
		// 1�����Ϊnull����Ϊfalse
		if (root == null) {
			return false;
		}
		// 2���Ƚϸ��ڵ�
		int compareResult = e.compareTo(root.element);

		// 3���ݹ�
		if (compareResult > 0) {
			// ����ȸ��ڵ�󣬾ͺ��Һ��ӱȽ�
			return contains(e, root.right);
		} else if (compareResult < 0) {
			// ����ȸ��ڵ�С���ͺ����ӱȽ�
			return contains(e, root.left);
		} else {
			// ����0��ʾ�����
			return true;
		}
	}

	private AvlNode<T> findMin(AvlNode<T> root) {
		if (root == null) {
			return null;
		} else if (root.left == null) {
			return root;
		} else {
			return findMin(root.right);
		}
	}

	private AvlNode<T> findMax(AvlNode<T> root) {
		if (root != null) {
			while (root.right != null) {
				root = root.right;
			}
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
	private AvlNode<T> remove(T e, AvlNode<T> root) {
		if (root == null) {
			return null;
		}

		int compareResult = e.compareTo(root.element);

		if (compareResult < 0) {
			root.left = remove(e, root.left);
		} else if (compareResult > 0) {
			root.right = remove(e, root.right);
		} else if (root.left != null && root.right == null) {
			// ��������
			root.element = findMin(root.right).element;
			root.right = remove(root.element, root.right);

		} else {
			// ��Ҷ����һ������
			root = (root.left != null) ? root.left : root.right;
		}
		return blance(root);
	}

	/**
	 * �������
	 * 
	 * @param root
	 */
	private void printTree(AvlNode<T> root) {

		if (root != null) {
			printTree(root.left);
			System.out.println(root.height + ":" + root.element + " ("
					+ (root.left == null ? "null" : root.left.element) + ","
					+ (root.right == null ? "null" : root.right.element) + ")");
			printTree(root.right);
		}
	}

	/**
	 * �������
	 * 
	 * @param root
	 */
	private void printTreeFirst(AvlNode<T> root) {

		if (root != null) {
			System.out.println(root.height + ":" + root.element + " ("
					+ (root.left == null ? "null" : root.left.element) + ","
					+ (root.right == null ? "null" : root.right.element) + ")");
			printTreeFirst(root.left);
			printTreeFirst(root.right);
		}
	}

	/**
	 * �������
	 * 
	 * @param root
	 */
	private void printTreeLast(AvlNode<T> root) {

		if (root != null) {
			printTreeLast(root.left);
			printTreeLast(root.right);
			System.out.println(root.height + ":" + root.element + " ("
					+ (root.left == null ? "null" : root.left.element) + ","
					+ (root.right == null ? "null" : root.right.element) + ")");
		}
	}

	private AvlNode<T> insert(T e, AvlNode<T> root) {
		if (root == null) {
			return new AvlNode<T>(e, null, null);
		}

		int compareResult = e.compareTo(root.element);

		if (compareResult < 0) {
			root.left = insert(e, root.left);
		} else if (compareResult > 0) {
			root.right = insert(e, root.right);
		} else {
			// ��ͬ��ֵ�������κ�����
		}

		return blance((AvlNode<T>) root);
	}

	private int height(AvlNode<T> root) {
		return root == null ? -1 : root.height;
	}

	private AvlNode<T> blance(AvlNode<T> root) {

		if (root == null) {
			return root;
		}
		if (height(root.left) - height(root.right) > ALLOW_IMBALANCE) {
			if (height(root.left.left) >= height(root.left.right)) {
				root = rotateWithLeftChild(root);
			} else {
				root = doubleWithLeftChild(root);
			}
		} else if (height(root.right) - height(root.left) > ALLOW_IMBALANCE) {
			if (height(root.right.right) >= height(root.right.left)) {
				root = rotateWithRightChild(root);
			} else {
				root = doubleWithRightChild(root);
			}
		}
		root.height = Math.max(height(root.left), height(root.right)) + 1;
		return root;
	}

	private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
		AvlNode<T> k1 = k2.left;
		k2.left = k1.right;
		k1.right = k2;
		k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
		k1.height = Math.max(height(k2.left), k2.height) + 1;
		return k1;
	}

	private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
		k3.left = rotateWithRightChild(k3.left);
		return rotateWithLeftChild(k3);
	}

	private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
		AvlNode<T> k2 = k1.right;
		k1.right = k2.left;
		k2.left = k1;
		k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
		k2.height = Math.max(height(k2.right), k1.height) + 1;
		return k2;
	}

	private AvlNode<T> doubleWithRightChild(AvlNode<T> k3) {
		k3.right = rotateWithLeftChild(k3.right);
		return rotateWithRightChild(k3);
	}

	public static void main(String[] args) {

		AvlSearchTree<Integer> t = new AvlSearchTree();
		t.insert(10);
		t.insert(3);
		t.insert(2);
		t.insert(6);
		t.insert(1);
		t.insert(8);

		t.printTree();

		t.insert(11);
		t.printTree();

		t.insert(5);
		t.insert(4);
		t.printTree();

		t.insert(12);
		t.insert(15);
		t.printTree();
	}

}
