package com.beginners.HRRS.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="checkout_table")
public class CheckOut implements Serializable {
	
	private static final long serialVersionUID = 2345678L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="checkout_id")
	private int id;
	private LocalDate date;
	
	public CheckOut() {
		super();
	}

	public CheckOut(int id, LocalDate date) {
		super();
		this.id = id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
