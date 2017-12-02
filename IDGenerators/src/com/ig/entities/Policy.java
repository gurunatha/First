package com.ig.entities;

public class Policy {
	private String id;
	private String policyName;
	private String description;
	private String type;
	private int minTenure;
	private int maxTenure;
	private int eligibleAge;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMinTenure() {
		return minTenure;
	}

	public void setMinTenure(int minTenure) {
		this.minTenure = minTenure;
	}

	public int getMaxTenure() {
		return maxTenure;
	}

	public void setMaxTenure(int maxTenure) {
		this.maxTenure = maxTenure;
	}

	public int getEligibleAge() {
		return eligibleAge;
	}

	public void setEligibleAge(int eligibleAge) {
		this.eligibleAge = eligibleAge;
	}

}
