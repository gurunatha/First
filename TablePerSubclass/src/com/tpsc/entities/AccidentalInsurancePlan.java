package com.tpsc.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ACCIDENTAL_INSURANCE_PLAN")
@PrimaryKeyJoinColumn(name = "U_PLAN_NO")
/* @DiscriminatorValue("AccidentalInsurancePlan") */
public class AccidentalInsurancePlan extends InsurancePlan {
	@Column(name = "COVERAGE_PERIOD")
	protected int coveragePeriod;
	@Column(name = "PARTIAL_DISABILITY_COVERAGE")
	protected boolean partialDisability;
	@Column(name = "DEATH_COVERAGE")
	protected boolean deathCoverage;

	public int getCoveragePeriod() {
		return coveragePeriod;
	}

	public void setCoveragePeriod(int coveragePeriod) {
		this.coveragePeriod = coveragePeriod;
	}

	public boolean isPartialDisability() {
		return partialDisability;
	}

	public void setPartialDisability(boolean partialDisability) {
		this.partialDisability = partialDisability;
	}

	public boolean isDeathCoverage() {
		return deathCoverage;
	}

	public void setDeathCoverage(boolean deathCoverage) {
		this.deathCoverage = deathCoverage;
	}

	@Override
	public String toString() {
		return "AccidentalInsurancePlan [coveragePeriod=" + coveragePeriod
				+ ", partialDisability=" + partialDisability
				+ ", deathCoverage=" + deathCoverage + ", uPlanNo=" + uPlanNo
				+ ", planName=" + planName + ", description=" + description
				+ ", planProvider=" + planProvider + "]";
	}

}
