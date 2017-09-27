package dk.au.ase.asu.beertab.GUI;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DrinkTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	private Drink d;

	@Before
	public void setUp() throws Exception {
		d = new Drink("Vin",45);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test(expected=NegativePriceException.class)
	public void test_create() throws NegativePriceException {
		
		assertNotNull(d);
		assertEquals(d.getName(),"Vin");
		assertEquals(d.getPrice(),45);
		Drink na = new Drink("NN",-45);
		
	}
	@Test
	public void test_create2() throws NegativePriceException {
		Drink d = new Drink("Vin",new BigDecimal(45));
		assertNotNull(d);
		assertEquals(d.getName(),"Vin");
		assertEquals(d.getPrice(),45);
	}
	@Test(expected=NegativePriceException.class)
	public void testChangePrice() throws NegativePriceException {
		d.changePrice(145);
		assertEquals(145,d.getPrice());
		d.changePrice(-100);
		assertEquals(145,d.getPrice());
	}

}
