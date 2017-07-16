package com.larry.algorithm.tree;

public class TreeNode {

    private Object element;

    private TreeNode firstChild;

    private TreeNode nextSibling;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }



}
