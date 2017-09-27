package dk.au.ase.asu.beertab.GUI;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map.Entry;

public class Person {
	HashMap<Drink,Integer> tab = new HashMap<Drink,Integer>();
	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public void throwEcxcept() throws MyExcept {
		throw new MyExcept();
	}

	public void addDrink(Drink drink) {
		if (tab.get(drink)==null) {
			tab.put(drink,0);
		}
		tab.put(drink, tab.get(drink)+1);
	}

	public int get(Drink d) {
		// TODO Auto-generated method stub
		return tab.get(d);
	}

	public BigDecimal invoice() {
		BigDecimal price = new BigDecimal(0);
		// TODO Auto-generated method stub
		for (Entry<Drink,Integer> entry:tab.entrySet()) {
			// price += entry.getKey().getPrice()*entry.getValue();
			BigDecimal multiplicand = new BigDecimal(entry.getValue());
			BigDecimal additor = entry.getKey().getPrice_().
								 multiply(multiplicand);
			price = price.add(additor);
		}
		return price;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public int invoice_i() {
		// TODO Auto-generated method stub
		return invoice().intValue();
	}

	public void removeDrink(Drink v) {
		// TODO Auto-generated method stub
		if (tab.get(v)>0) {
			tab.put(v, tab.get(v)-1);
		}
	}
}
