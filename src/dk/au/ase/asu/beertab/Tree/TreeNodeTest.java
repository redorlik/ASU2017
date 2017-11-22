package dk.au.ase.asu.beertab.Tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TreeNodeTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCreate() {
		TreeNode node = new TreeNode(3);
		assertTrue(node != null);
		assertEquals(node.value,3);
		assertEquals(node.getValue(),3);
	}

	@Test
	public void testInsert() {
		TreeNode node = new TreeNode(3);
		node.insert(4);
		assertTrue(node.getRight() != null);
		assertEquals(node.getRight().getValue(),4);
		node.insert(2);
		assertTrue(node.getLeft() != null);
		assertEquals(node.getLeft().getValue(),2);
		node.insert(10);
		assertEquals(node.getRight().getValue(),4);
		assertEquals(node.getRight().getRight().getValue(),10);
		node.insert(9);
		assertEquals(node.getRight().getRight().getLeft().getValue(),9);
		
	}
}
