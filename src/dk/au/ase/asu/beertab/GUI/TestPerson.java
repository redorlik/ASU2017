package dk.au.ase.asu.beertab.GUI;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	private Person pers;
	private Drink d;
	private Drink v;

	@Before
	public void setUp() throws Exception {
		pers = new Person("Anders");
		d = new Drink("Øl",new BigDecimal(21));
		v = new Drink("Vin",new BigDecimal(51));
		pers.addDrink(d);
		pers.addDrink(v);
		pers.addDrink(v);
		pers.addDrink(v);
		pers.addDrink(v);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Efter metode");
	}

	@Test
	public void testCreate() {
		assertNotNull(pers);
		assertEquals("Anders",pers.getName());
	}

	@Test
	public void testAddDrink() {
		assertEquals(pers.get(d),1);
		pers.addDrink(d);
		
		assertEquals(pers.get(d),2);	
		assertEquals(pers.get(v),4);	
	}
	
	@Test
	public void testFindPris() {
		assertEquals(225,pers.invoice_i());
	}
	@Test
	public void testRemoveDrink() {
		pers.removeDrink(v);
		assertEquals(3,pers.get(v));
		for (int i=0;i<10;i++) {
			pers.removeDrink(d);
		}
		
		assertTrue((pers.get(d)>=0));
		assertEquals(0,pers.get(d));
		
	}
}
