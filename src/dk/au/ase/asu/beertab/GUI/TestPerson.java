package dk.au.ase.asu.beertab.GUI;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerson {

	private Person pers;
	private Drink d;

	@Before
	public void setUp() throws Exception {
		pers = new Person();
		d = new Drink("Øl",new BigDecimal(21));
		pers.addDrink(d);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Efter metode");
	}

	@Test
	public void testCreate() {
		assertNotNull(pers);
	}

	@Test
	public void testAddDrink() {
		assertEquals(pers.get(d),1);
		pers.addDrink(d);
		assertEquals(pers.get(d),2);	
	}
	
	@Test
	public void testFindPris() {
		
		assertEquals(pers.invoice().intValue(),21);
	}
}
