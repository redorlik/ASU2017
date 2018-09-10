package dk.au.ase.asu.Voting;

import java.util.HashMap;

public class Multivalg {
	private HashMap<String,StemmeSeddel> valgsedler= new HashMap<String,StemmeSeddel>();

	public Multivalg() {
		
	}

	public void add(String string, StemmeSeddel stemmeSeddel) {
		// TODO Auto-generated method stub
		valgsedler.put(string,stemmeSeddel);
		
	}

	public StemmeSeddel get(String string) {
		// TODO Auto-generated method stub
		return valgsedler.get(string);
	}
	
}
