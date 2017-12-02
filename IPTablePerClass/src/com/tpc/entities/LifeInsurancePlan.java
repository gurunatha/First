package com.tpc.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("LifeInsurancePlan")
public class LifeInsurancePlan extends InsurancePlan {
	@Column(name = "MAX_ELIGIBLE_AGE")
	protected int eligibleAge;
	@Column(name = "PLAN_PERIOD")
	protected int planPeriod;
	@Column(name = "PRE_MEDICAL_CHECKUP_REQ")
	protected boolean preMedicalCheckup;

	public int getEligibleAge() {
		return eligibleAge;
	}

	public void setEligibleAge(int eligibleAge) {
		this.eligibleAge = eligibleAge;
	}

	public int getPlanPeriod() {
		return planPeriod;
	}

	public void setPlanPeriod(int planPeriod) {
		this.planPeriod = planPeriod;
	}

	public boolean isPreMedicalCheckup() {
		return preMedicalCheckup;
	}

	public void setPreMedicalCheckup(boolean preMedicalCheckup) {
		this.preMedicalCheckup = preMedicalCheckup;
	}

	@Override
	public String toString() {
		return "LifeInsurancePlan [eligibleAge=" + eligibleAge
				+ ", planPeriod=" + planPeriod + ", preMedicalCheckup="
				+ preMedicalCheckup + ", uPlanNo=" + uPlanNo + ", planName="
				+ planName + ", description=" + description + ", planProvider="
				+ planProvider + "]";
	}

}
