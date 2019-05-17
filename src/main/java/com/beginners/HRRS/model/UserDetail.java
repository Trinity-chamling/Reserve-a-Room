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
import javax.persistence.OneToOne;
import javax.persistence.Table;// take import of persistence because it can be used by all

@Entity
@Table(name="userdetail_table")
public class UserDetail implements Serializable {
	
	private static final long serialVersionUID = 123456L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="userdetail_id")
	private int id;
	private String firstname;
	private String lastname;
	private String image;
	
	@Column(unique=true)
	private String username;
	private String password;
	private String number;
	private String address;
	private String email;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="userdetail")//making this parent model and mapping one to one relation with the model UserRole having an object of userdetail in it.
	private UserRole userrole;
	
	private LocalDate reg_date;//stores registered date or current date of registration....
	private boolean status;//checked-in, checked-out (1,0)//registration is only done when user have to reserve a room so at the fisrt time it will have checked in status.
	
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, mappedBy="customer")
	private Reservation reservation;
	
	public UserDetail() {
		super();
	}

	public UserDetail(String firstname, String lastname, String image, String username, String password, String number,
			String address, String email, UserRole userrole, LocalDate reg_date, boolean status,
			Reservation reservation) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.image = image;
		this.username = username;
		this.password = password;
		this.number = number;
		this.address = address;
		this.email = email;
		this.userrole = userrole;
		this.reg_date = reg_date;
		this.status = status;
		this.reservation = reservation;
	}

	public UserDetail(int id, String firstname, String lastname, String image, String username, String password,
			String number, String address, String email, UserRole userrole, LocalDate reg_date, boolean status,
			Reservation reservation) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.image = image;
		this.username = username;
		this.password = password;
		this.number = number;
		this.address = address;
		this.email = email;
		this.userrole = userrole;
		this.reg_date = reg_date;
		this.status = status;
		this.reservation = reservation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRole getUserrole() {
		return userrole;
	}

	public void setUserrole(UserRole userrole) {
		this.userrole = userrole;
	}

	public LocalDate getReg_date() {
		return reg_date;
	}

	public void setReg_date(LocalDate reg_date) {
		this.reg_date = reg_date;
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
	
	
	
	
}
