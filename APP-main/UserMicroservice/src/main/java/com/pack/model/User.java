package com.pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name="user_id")
	private int userId;

	@Column(name="password")
	private String password;

	@Column(name="email",unique = true)
	//@Email
	private String email;

	@Column(name="phone_number")
	private String phoneNumber;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", password=" + password + ", email=" + email + ", phoneNumber=" + phoneNumber
				+ "]";
	}

	public User(int userId, String password, String email, String phoneNumber) {
		super();
		this.userId = userId;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}

	public User() {
		
	}
	
	

	
	

}
