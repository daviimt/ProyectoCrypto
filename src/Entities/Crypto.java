package Entities;

public class Crypto {
	private String name,details;

	private float value, marketCap, supply;
	private String description;

	public Crypto(String name, String details, float value, float marketCap, float supply, String description) {
		super();
		this.name = name;
		this.details = details;
		this.value = value;
		this.marketCap = marketCap;
		this.supply = supply;
		this.description = description;
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

	public String getDetails() {
		return details;
	}
	
	public void setDetails(String details) {
		this.details = details;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Crypto [name=" + name + ", details=" + details + ", value=" + value + ", marketCap=" + marketCap
				+ ", supply=" + supply + ", description=" + description + "]";
	}
	
}
