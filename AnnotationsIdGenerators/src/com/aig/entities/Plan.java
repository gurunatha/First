package com.aig.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "MOBILE_PLANS")
public class Plan {
	@Id
	@Column(name = "PLAN_ID")
	@GenericGenerator(name = "hilo_generator", strategy = "hilo", parameters = { @Parameter(name = "max_lo", value = "10") })
	@GeneratedValue(generator = "hilo_generator")
	private int id;
	@Column(name = "PLAN_NM", nullable = false, length = 50)
	private String planName;
	@Column(name = "PLAN_TYPE", nullable = false, length = 50)
	private String type;
	@Column(name = "DESCR", nullable = true, length = 500)
	private String description;
	private float amount;
	@Column(name = "VALIDITY_IN_DAYS", nullable = false, length = 3)
	private int validityInDays;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public int getValidityInDays() {
		return validityInDays;
	}

	public void setValidityInDays(int validityInDays) {
		this.validityInDays = validityInDays;
	}

}
