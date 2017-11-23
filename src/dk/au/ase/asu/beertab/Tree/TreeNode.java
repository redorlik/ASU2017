package dk.au.ase.asu.beertab.Tree;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeNode<T extends Comparable> {

	public T value = null;
	private TreeNode right;
	private TreeNode left;

	public TreeNode(T i) {
		this.value = i;
	}

	public TreeNode(ArrayList<T> l) {
	
		for (Iterator<T> it = l.iterator();it.hasNext();)
			this.insert(it.next());
	}

	public T getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void insert(T t) {
		if (getValue() == null) {
			this.value = t;
		}
		if (t.compareTo(getValue())>0) {
			if (this.right == null) {
				this.right = new TreeNode(t);
			}else {
				this.right.insert(t);
			}
		}else {
			if (this.left == null) {
				this.left = new TreeNode(t);
			}else {
				this.left.insert(t);
			}
		}
	}

	TreeNode getRight() {
		// TODO Auto-generated method stub
		return this.right;
	}
	TreeNode getLeft() {
		// TODO Auto-generated method stub
		return this.left;
	}

	public void remove(int i) {
		
		
	}

	public TreeNode search(T i) {
		if (getValue().equals(i)) return this;
		if (i.compareTo(getValue())>0) {
			return this.getRight().search(i);
		}else {
			return this.getLeft().search(i);
		}
		
	}
}
