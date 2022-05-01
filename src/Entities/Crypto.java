package Entities;

import javax.swing.Icon;

public class Crypto {

	private String name;
	private float value, marketCap, supply;
	private String description;
	private Icon icon;

	public Crypto(String name, float value, float marketCap, float supply, String description, Icon icon) {
		super();
		this.name = name;
		this.value = value;
		this.marketCap = marketCap;
		this.supply = supply;
		this.description = description;
		this.icon = icon;
	}

	public Crypto(String name, float value, float marketCap, float supply, String description) {
		super();
		this.name = name;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	@Override
	public String toString() {
		return "Crypto [name=" + name + ", value=" + value + ", marketCap=" + marketCap + ", supply=" + supply
				+ ", description=" + description + ", icon=" + icon + "]";
	}

}
