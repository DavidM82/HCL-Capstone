package com.example.Capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false, unique = true)
	private String username;
	
	private String password;

	@Column(columnDefinition = "bigint default 0")
	private long creditcard; 
	
	@Column(columnDefinition = "int default 0")
	private int experation_date;
	
	private String email;
	
	private boolean isAdmin;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public long getCreditcard() {
		return creditcard;
	}

	public void setCreditcard(long creditcard) {
		this.creditcard = creditcard;
	}

	public int getExperation_date() {
		return experation_date;
	}

	public void setExperation_date(int experation_date) {
		this.experation_date = experation_date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
