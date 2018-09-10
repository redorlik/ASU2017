package dk.au.ase.asu.beertab.Tree;

import java.util.ArrayList;
import java.util.Collection;
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
		}else
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

	public void remove(T i) {
		 ArrayList<TreeNode> f = this.search(i);
		
	}

	public ArrayList<TreeNode> search(T i) {
		ArrayList res;
		if (getValue().equals(i)) {
			res = new ArrayList<TreeNode>();
			res.add(this);
			return res;
		}	
		if (i.compareTo(getValue())>0) {
			res = this.getRight().search(i);
			res.add(this);
			return res;
		}else {
			res = this.getLeft().search(i);
			res.add(this);
			return res;
		}
		
	}

	public ArrayList<T> toList() {
		ArrayList<T> res; 
		if (this.left != null) {
			res = this.getLeft().toList();
		}else {
			res = new ArrayList<T>();
		}
		res.add(getValue());
		if (this.right != null) {
			res.addAll(this.getRight().toList());
		}
		
		return res;
	}
}
