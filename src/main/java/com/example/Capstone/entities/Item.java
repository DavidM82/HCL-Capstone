package com.example.Capstone.entities;

import java.math.BigDecimal;

//Do not set as Entity, will not be stored in database
public class Item {

	private long id;
	private String name;
	private BigDecimal price;
	
	public Item(long id, String name, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public long getId() {
		return this.id;
	}
	
	public void setId(long id) {
		this.id = id;
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
