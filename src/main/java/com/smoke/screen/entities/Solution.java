package com.smoke.screen.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private User user;

	@Column(nullable = true, columnDefinition = "TEXT")
//	default NULL
	private String solutionQ1;

	@Column(nullable = true, length = 6)
	private String langQ1;

	@Column(nullable = true, columnDefinition = "TEXT")
	private String solutionQ2;

	@Column(nullable = true, length = 6)
	private String langQ2;

	@Column(nullable = true, columnDefinition = "TEXT")
	private String solutionQ3;

	@Column(nullable = true, length = 6)
	private String langQ3;
	
	private int flashCount;

	private String timeTaken;

//	No Args Constructor
	
	public Solution() {
		super();
	}

//	Getters and Setters
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSolutionQ1() {
		return solutionQ1;
	}

	public void setSolutionQ1(String solutionQ1) {
		this.solutionQ1 = solutionQ1;
	}

	public String getLangQ1() {
		return langQ1;
	}

	public void setLangQ1(String langQ1) {
		this.langQ1 = langQ1;
	}

	public String getSolutionQ2() {
		return solutionQ2;
	}

	public void setSolutionQ2(String solutionQ2) {
		this.solutionQ2 = solutionQ2;
	}

	public String getLangQ2() {
		return langQ2;
	}

	public void setLangQ2(String langQ2) {
		this.langQ2 = langQ2;
	}

	public String getSolutionQ3() {
		return solutionQ3;
	}

	public void setSolutionQ3(String solutionQ3) {
		this.solutionQ3 = solutionQ3;
	}

	public String getLangQ3() {
		return langQ3;
	}

	public void setLangQ3(String langQ3) {
		this.langQ3 = langQ3;
	}

	public int getFlashCount() {
		return flashCount;
	}

	public void setFlashCount(int flashCount) {
		this.flashCount = flashCount;
	}

	public String getTimeTaken() {
		return timeTaken;
	}

	public void setTimeTaken(String timeTaken) {
		this.timeTaken = timeTaken;
	}

}
