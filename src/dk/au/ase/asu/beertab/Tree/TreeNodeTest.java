package dk.au.ase.asu.beertab.Tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() {
		TreeNode<Integer> node = new TreeNode<Integer>(3);
		assertTrue(node != null);
		assertEquals(node.value,(Integer) 3);
		assertEquals(node.getValue(),(Integer) 3);
	}

	@Test
	public void testInsert() {
		TreeNode<Integer> node = new TreeNode<Integer>(3);
		node.insert(4);
		assertTrue(node.getRight() != null);
		assertEquals(node.getRight().getValue(),(Integer) 4);
		node.insert(2);
		assertTrue(node.getLeft() != null);
		assertEquals(node.getLeft().getValue(),(Integer) 2);
		node.insert(10);
		assertEquals(node.getRight().getValue(),(Integer) 4);
		assertEquals(node.getRight().getRight().getValue(),(Integer) 10);
		node.insert(9);
		assertEquals(node.getRight().getRight().getLeft().getValue(),(Integer) 9);
	}
	@Test
	public void testInsertList() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.addAll(Arrays.asList(new Integer[] {3,4,2,10,9}));
		TreeNode<Integer> root = new TreeNode<Integer>(l);
		assertEquals(root.getRight().getRight().getLeft().getValue(),(Integer) 9);
	}
	@Test
	public void testRemove() {
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.addAll(Arrays.asList(new Integer[] {3,4,2,10,9}));
		TreeNode<Integer> root = new TreeNode<Integer>(l);
		root.remove(9);
		assertEquals(root.toList().toString(),"[2,3,4,10]");
	}
	@Test
	public void testSearch() {
	ArrayList<Integer> l = new ArrayList<Integer>();
	l.addAll(Arrays.asList(new Integer[] {3,4,2,10,9}));
	TreeNode<Integer> root = new TreeNode<Integer>(l);
	ArrayList<TreeNode> res = root.search(9);
	assertEquals(res.get(0).getValue(),(Integer) 9);
	}
}
