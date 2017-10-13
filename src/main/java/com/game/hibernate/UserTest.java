package com.game.hibernate;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;  


@Entity
@Table
public class UserTest {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private Integer score;
	
	public UserTest() {
	}
	
	public UserTest(Integer id, String name, Integer score) {
		this.id = id;
		this.name = name;
		this.score = score;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getScore() {
		return score;
	}
	
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
	
}
