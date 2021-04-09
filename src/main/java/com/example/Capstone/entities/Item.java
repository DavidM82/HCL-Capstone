package com.example.Capstone.entities;

import java.math.BigDecimal;

//Do not set as Entity, will not be stored in database
public class Item {

	private String name;
	private BigDecimal price;
	
	public Item(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
