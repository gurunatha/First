package com.tpc.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_PLAN")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "PLAN_TYPE")
@DiscriminatorValue("InsurancePlan")
public class InsurancePlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int uPlanNo;
	@Column(name = "U_PLAN_NM")
	protected String planName;
	@Column(name = "DESCR")
	protected String description;
	@Column(name = "PLAN_PROVIDER")
	protected String planProvider;

	public int getuPlanNo() {
		return uPlanNo;
	}

	public void setuPlanNo(int uPlanNo) {
		this.uPlanNo = uPlanNo;
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

	public String getPlanProvider() {
		return planProvider;
	}

	public void setPlanProvider(String planProvider) {
		this.planProvider = planProvider;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((planName == null) ? 0 : planName.hashCode());
		result = prime * result
				+ ((planProvider == null) ? 0 : planProvider.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsurancePlan other = (InsurancePlan) obj;
		if (planName == null) {
			if (other.planName != null)
				return false;
		} else if (!planName.equals(other.planName))
			return false;
		if (planProvider == null) {
			if (other.planProvider != null)
				return false;
		} else if (!planProvider.equals(other.planProvider))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "InsurancePlan [uPlanNo=" + uPlanNo + ", planName=" + planName
				+ ", description=" + description + ", planProvider="
				+ planProvider + "]";
	}

}
