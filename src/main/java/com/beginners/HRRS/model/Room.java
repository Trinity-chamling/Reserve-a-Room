package com.beginners.HRRS.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="room_table")
public class Room implements Serializable {
	
	private static final long serialVersionUID = 12345678L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="room_id")
	private int id;
	private String description;
	private String type;
	private double rate;
	private boolean status;
	private String image;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="room")//making this parent model ..
	private Reservation reservation; // for now only one room can be reserved by a customer

	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Room(String description, String type, double rate, boolean status, Reservation reservation, String image) {
		super();
		this.description = description;
		this.type = type;
		this.rate = rate;
		this.status = status;
		this.reservation = reservation;
		this.image = image;
	}

	public Room(int id, String description, String type, double rate, boolean status, Reservation reservation, String image) {
		super();
		this.id = id;
		this.description = description;
		this.type = type;
		this.rate = rate;
		this.status = status;
		this.reservation = reservation;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	
}
