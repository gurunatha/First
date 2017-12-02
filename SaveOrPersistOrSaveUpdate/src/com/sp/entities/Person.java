package com.sp.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@DynamicUpdate(true)
@DynamicInsert(true)
@Table(name = "PERSON")
public class Person {
	@Id
	@Column(name = "PERSON_ID")
	@GenericGenerator(name = "hilo_generator", strategy = "hilo", parameters = { @Parameter(name = "max_lo", value = "10") })
	@GeneratedValue(generator = "hilo_generator")
	private int id;
	@Column(name = "FIRST_NM")
	private String firstName;
	@Column(name = "LAST_NM", nullable = true)
	private String lastName;
	private String gender;
	private int age;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

}
