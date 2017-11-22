package dk.au.ase.asu.beertab.Tree;

public class TreeNode {

	public int value;
	private TreeNode right;
	private TreeNode left;

	public TreeNode(int i) {
		this.value = i;
	}

	public int getValue() {
		// TODO Auto-generated method stub
		return value;
	}

	public void insert(int i) {
		if (i>getValue()) {
			if (this.right == null) {
				this.right = new TreeNode(i);
			}else {
				this.right.insert(i);
			}
		}else {
			if (this.left == null) {
				this.left = new TreeNode(i);
			}else {
				this.left.insert(i);
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
}
