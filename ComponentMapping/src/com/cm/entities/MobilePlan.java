package com.cm.entities;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOBILE_PLAN")
public class MobilePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLAN_ID")
	private int planId;
	@Column(name = "PLAN_NM")
	private String planName;
	@Column(name = "DESCR")
	private String description;
	@Column(name = "BILLING_DAY_OF_MONTH")
	private int billingDayOfMonth;
	@Column(name = "RENTAL_AMOUNT")
	private float rentalAmount;
	@Embedded
	private TarrifDetails tarrifDetails;

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getBillingDayOfMonth() {
		return billingDayOfMonth;
	}

	public void setBillingDayOfMonth(int billingDayOfMonth) {
		this.billingDayOfMonth = billingDayOfMonth;
	}

	public float getRentalAmount() {
		return rentalAmount;
	}

	public void setRentalAmount(float rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	public TarrifDetails getTarrifDetails() {
		return tarrifDetails;
	}

	public void setTarrifDetails(TarrifDetails tarrifDetails) {
		this.tarrifDetails = tarrifDetails;
	}

}
