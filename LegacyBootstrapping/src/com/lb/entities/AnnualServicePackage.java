package com.lb.entities;

public class AnnualServicePackage {
	protected int annualServicePackageNo;
	protected String packageName;
	protected float amount;
	protected int validityInDays;

	public int getAnnualServicePackageNo() {
		return annualServicePackageNo;
	}

	public void setAnnualServicePackageNo(int annualServicePackageNo) {
		this.annualServicePackageNo = annualServicePackageNo;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
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
