package com.oto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARD_HOLDER")
public class CardHolder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARD_HOLDER_ID")
	protected int cardHolderId;
	@Column(name = "FIRST_NM")
	protected String firstName;
	@Column(name = "LAST_NM")
	protected String lastName;
	protected String gender;
	protected int age;
	@Column(name = "RELATION_SHIP")
	protected String relationShip;
	protected String mobile;
	protected String email;

	public int getCardHolderId() {
		return cardHolderId;
	}

	public void setCardHolderId(int cardHolderId) {
		this.cardHolderId = cardHolderId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "CardHolder [cardHolderId=" + cardHolderId + ", firstName="
				+ firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", relationShip=" + relationShip
				+ ", mobile=" + mobile + ", email=" + email + "]";
	}

}
