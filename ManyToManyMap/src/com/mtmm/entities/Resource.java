package com.mtmm.entities;

public class Resource {
	protected int resourceId;
	protected String resourceName;
	protected String role;

	public int getResourceId() {
		return resourceId;
	}

	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName="
				+ resourceName + ", role=" + role + "]";
	}

}
