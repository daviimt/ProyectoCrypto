package Entities;

import java.io.Serializable;

import javax.swing.Icon;

@SuppressWarnings("serial")
public class Crypto implements Serializable{

	private String name;
	private float value, marketCap, supply;
	private String description;
	private Icon icon;
	private String creator;
	private int month;

	public Crypto(String name, float value, float marketCap, float supply, String description, Icon icon,
			String creator, int month) {
		super();
		this.name = name;
		this.value = value;
		this.marketCap = marketCap;
		this.supply = supply;
		this.description = description;
		this.icon = icon;
		this.creator = creator;
		this.month = month;
	}

	public Crypto(String name, float value, float marketCap, float supply, String description, String creator, int month) {
		super();
		this.name = name;
		this.value = value;
		this.marketCap = marketCap;
		this.supply = supply;
		this.description = description;
		this.creator = creator;
		this.month = month;
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

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	@Override
	public String toString() {
		return "Crypto [name=" + name + ", value=" + value + ", marketCap=" + marketCap + ", supply=" + supply
				+ ", description=" + description + ", icon=" + icon + ", creator=" + creator + ", month=" + month + "]";
	}


}
