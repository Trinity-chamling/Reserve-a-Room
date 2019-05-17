package com.beginners.HRRS.model;

import java.io.Serializable;
import java.time.LocalDate;

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

@Entity
@Table(name="reservation_table")
public class Reservation implements Serializable {
	
	private static final long serialVersionUID = 12345678L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reservation_id")
	private int id;
	private LocalDate date;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="userdetail_id")
	private UserDetail customer; //change done.....
	//change it after we make model for customer giving it relation to customer.... for now just giving manually a customer id
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
	@JoinColumn(name="room_id")
	private Room room;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(LocalDate date, UserDetail customer, Room room) {
		super();
		this.date = date;
		this.customer = customer;
		this.room = room;
	}

	public Reservation(int id, LocalDate date, UserDetail customer, Room room) {
		super();
		this.id = id;
		this.date = date;
		this.customer = customer;
		this.room = room;
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

	public UserDetail getCustomer() {
		return customer;
	}

	public void setCustomer(UserDetail customer) {
		this.customer = customer;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	

}
