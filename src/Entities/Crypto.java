package Entities;

public class Crypto {
	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the value
	 */
	public float getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(float value) {
		this.value = value;
	}

	/**
	 * @return the marketCap
	 */
	public float getMarketCap() {
		return marketCap;
	}

	/**
	 * @param marketCap the marketCap to set
	 */
	public void setMarketCap(float marketCap) {
		this.marketCap = marketCap;
	}

	/**
	 * @return the supply
	 */
	public float getSupply() {
		return supply;
	}

	/**
	 * @param supply the supply to set
	 */
	public void setSupply(float supply) {
		this.supply = supply;
	}

	private float value, marketCap, supply;

}
