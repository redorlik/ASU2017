package dk.au.ase.asu.beertab.GUI;

import java.math.BigDecimal;

public class Drink {
	private String type;
	private BigDecimal price;

	public Drink(String type, BigDecimal bigDecimal) {
		this.type = type;
		this.price = bigDecimal;
	}
	
	public Drink(String type2, int i) {
		this.type = type2;
		this.price = new BigDecimal(i);
	}

	public int getPrice() {
		return price.intValue();
	}
	public BigDecimal getPrice_() {
		return price;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return this.type;
	}
}
