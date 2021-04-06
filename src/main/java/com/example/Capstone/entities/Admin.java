package com.example.Capstone.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(	name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	int id;
	
	@Column(name="username")
	String username;
	
	@Column(name="password")
	String password;
	
	@Column(name="role")
    private final String role = "admin";

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public String getRole() {
		return role;
	}
	
	
	
}