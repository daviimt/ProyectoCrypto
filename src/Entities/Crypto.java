package Entities;

public class Crypto {
	private String name;
	private float value, quantity, marketCap, supply;

	public Crypto(String name, float value, float quantity, float marketCap, float supply) {
		super();
		this.name = name;
		this.value = value;
		this.quantity = quantity;
		this.marketCap = marketCap;
		this.supply = supply;
	}

	public Crypto() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(float marketCap) {
		this.marketCap = marketCap;
	}

	public float getSupply() {
		return supply;
	}

	public void setSupply(float supply) {
		this.supply = supply;
	}

	@Override
	public String toString() {
		return "Crypto [name=" + name + ", value=" + value + ", quantity=" + quantity + ", marketCap=" + marketCap
				+ ", supply=" + supply + "]";
	}
}
