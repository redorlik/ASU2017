package dk.au.ase.asu.beertab.GUI;

import java.math.BigDecimal;

public class Drink {
	private String type;
	private BigDecimal price;

	public Drink(String type, BigDecimal bigDecimal) {
		this.type = type;
		this.price = bigDecimal;
	}
	
	public BigDecimal getPrice() {
		return price;
	}
}
