package dk.au.ase.asu.Voting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class StemmeSeddel {

	private ArrayList<String> valgliste;
	HashMap<String,Integer> resultat= new HashMap<String,Integer>();

	public StemmeSeddel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setChoices(ArrayList<String> arrayList) {
		// TODO Auto-generated method stub
		this.valgliste = arrayList;
		for(Iterator<String> s=arrayList.iterator(); s.hasNext();) {
			String tmp = s.next();
			resultat.put(tmp, 0);
		}
		
	}

	public ArrayList<String> getChoices() {
		// TODO Auto-generated method stub
		return valgliste;
	}

	public void vote(String string) {
		// TODO Auto-generated method stub
		resultat.put(string,resultat.get(string)+1);		
	}

	public void add(String string) {
		// TODO Auto-generated method stub
		resultat.put(string, 0);
	}
	

}
