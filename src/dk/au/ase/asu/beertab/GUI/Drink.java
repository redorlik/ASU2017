package dk.au.ase.asu.beertab.GUI;

import java.math.BigDecimal;

public class Drink {
	private String type;
	private BigDecimal price;

	public Drink(String type, BigDecimal bigDecimal) throws NegativePriceException {
		this.type = type;
		setPrice(bigDecimal);
	}
	
	public Drink(String type2, int i) throws NegativePriceException {
		this.type = type2;
		setPrice(new BigDecimal(i));
	}

	private void setPrice(BigDecimal price) throws NegativePriceException {
		// TODO Auto-generated method stub
		
		if (price.intValue()>0) this.price = price;
		else {
			NegativePriceException exc = new NegativePriceException();
			
			throw exc;
		}
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

	public void changePrice(int i) throws NegativePriceException {
		// TODO Auto-generated method stub
		setPrice( new BigDecimal(i));
	}
}
