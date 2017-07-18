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
			System.out.println("中=============");
			printTree(mRoot);
			System.out.println("先=============");
			printTreeFirst(mRoot);
			System.out.println("后=============");
			printTreeLast(mRoot);
		}
	}

	/**
	 * O(logN)的最大复杂度
	 * 
	 * @param e
	 * @param root
	 * @return
	 */
	private boolean contains(T e, AvlNode<T> root) {
		// 1、如果为null，则为false
		if (root == null) {
			return false;
		}
		// 2、比较跟节点
		int compareResult = e.compareTo(root.element);

		// 3、递归
		if (compareResult > 0) {
			// 如果比根节点大，就和右孩子比较
			return contains(e, root.right);
		} else if (compareResult < 0) {
			// 如果比跟节点小，就和左孩子比较
			return contains(e, root.left);
		} else {
			// 等于0表示，相等
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
	 * 查询到想要的值,3种情况：树叶；一个孩子；两个孩子<br/>
	 * 两个孩子孩子时，查找右子树的最小值代替该节点的数据，并递归删除的那个节点。
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
			// 两个孩子
			root.element = findMin(root.right).element;
			root.right = remove(root.element, root.right);

		} else {
			// 树叶或者一个孩子
			root = (root.left != null) ? root.left : root.right;
		}
		return blance(root);
	}

	/**
	 * 中序遍历
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
	 * 先序遍历
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
	 * 后序遍历
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
			// 相同的值，不做任何事情
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
