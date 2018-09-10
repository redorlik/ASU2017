package dk.au.ase.asu.Voting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class testStemmeseddel {

	
	private StemmeSeddel seddel;
	@Before
	public void setUp() throws Exception {
		this.seddel = new StemmeSeddel();
		ArrayList<String> valg = new ArrayList<String>();
		valg.add("Valg1");
		valg.add("Valg2");
		valg.add("Valg3");
		seddel.setChoices(valg);
	}

	@Test
	public void test_Oprette() {
		assertEquals(seddel.getChoices().get(0),"Valg1");
		assertEquals(seddel.getChoices().get(2),"Valg3");
	}
	@Test 
	public void test_stemme() {
		seddel.vote("Valg1");
		assertEquals((Integer)seddel.resultat.get("Valg1"),(Integer)1);
	}
	@Test 
	public void test_FlereStemmesedler() {
		Multivalg multiValg = new Multivalg();
		multiValg.add("Kedelig Valg",new StemmeSeddel());
		multiValg.add("Mere kedeligt Valg",seddel);
		seddel.vote("Valg1");
		multiValg.get("Kedelig Valg").add("Rødt skur");
		multiValg.get("Kedelig Valg").add("Blåt skur");
		
		multiValg.get("Kedelig Valg").vote("Rødt skur");
		assertEquals((Integer)multiValg.get("Kedelig Valg").
				resultat.get("Rødt Skur"),(Integer)1);
		assertEquals((Integer)multiValg.get("Kedelig Valg").
				resultat.get("Blåt Skur"),(Integer)0);
	
	}

}
