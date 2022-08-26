package com.inti.formation.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_entity")
public class UserEntity {
	
	private long userId;
	private String pseudo;
	private String email;
	private String description;
	private String postalCodeUser;
	private String password;
	private String phone;
	private boolean isAdmin;
	
	
	
	public UserEntity(String pseudo, String email, String description, String postalCodeUser, String password,
			String phone, boolean isAdmin) {
		super();
		this.pseudo = pseudo;
		this.email = email;
		this.description = description;
		this.postalCodeUser = postalCodeUser;
		this.password = password;
		this.phone = phone;
		this.isAdmin = isAdmin;
	}

	public UserEntity(long userId, String pseudo, String email, String description, String postalCodeUser,
			String password, String phone, boolean isAdmin) {
		super();
		userId = userId;
		this.pseudo = pseudo;
		this.email = email;
		this.description = description;
		this.postalCodeUser = postalCodeUser;
		this.password = password;
		this.phone = phone;
		this.isAdmin = isAdmin;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}


	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostalCodeUser() {
		return postalCodeUser;
	}

	public void setPostalCodeUser(String postalCodeUser) {
		this.postalCodeUser = postalCodeUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public UserEntity() {
		super();
	}

	@Override
	public String toString() {
		return "UserEntity [UserId=" + userId + ", pseudo=" + pseudo + ", email=" + email + ", description="
				+ description + ", postalCodeUser=" + postalCodeUser + ", password=" + password + ", phone=" + phone
				+ ", isAdmin=" + isAdmin + "]";
	}


	
	
	
}
