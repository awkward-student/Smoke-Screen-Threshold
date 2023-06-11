package com.smoke.screen.payloads;

import jakarta.validation.constraints.NotEmpty;

public class UserDTO {

	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String email;
	private String password;
	private String branch;
	private int sem;
	
//	No Args constructor
	
	public UserDTO() {
		super();
	}
	
//	Getters and Setters
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	
}
