package com.beginners.HRRS.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity//this enables the spring framework to know that it is the entity of which a table is made by hibernate.... 
@Table(name="userrole_table")
public class UserRole implements Serializable {
	
	private static final long serialVersionUID = 1234567L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userrole_id")
	private int id;
	
	private String role;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="userdetail_id")
	private UserDetail userdetail;

	public UserRole() {
		super();
	}

	public UserRole(int id, String role, UserDetail userdetail) {
		super();
		this.id = id;
		this.role = role;
		this.userdetail = userdetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public UserDetail getUserdetail() {
		return userdetail;
	}

	public void setUserdetail(UserDetail userdetail) {
		this.userdetail = userdetail;
	}
	
	
}
