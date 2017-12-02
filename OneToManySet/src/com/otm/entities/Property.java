package com.otm.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY")
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROPERTY_ID")
	protected int propertyId;
	@Column(name = "PROPERTY_NM")
	protected String propertyName;
	@Column(name = "DESCR")
	protected String description;
	protected String type;
	protected int area;
	protected String location;
	protected float amount;

	@OneToMany(mappedBy = "property")
	protected Set<Approval> approvals;

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
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

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public Set<Approval> getApprovals() {
		return approvals;
	}

	public void setApprovals(Set<Approval> approvals) {
		this.approvals = approvals;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyName="
				+ propertyName + ", description=" + description + ", type="
				+ type + ", area=" + area + ", location=" + location
				+ ", amount=" + amount + ", approvals=" + approvals + "]";
	}

}
