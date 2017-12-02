package com.otmm.entities;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SUPPORT_ENGINEER")
public class SupportEngineer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUPPORT_ENGINEER_ID")
	protected int supportEngineerId;
	protected String name;
	protected String designation;
	@Column(name = "SUPPORT_ENGINEER_LEVEL")
	protected int level;
	@Column(name = "CONTACT_NO")
	protected String contactNo;
	protected String email;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUPPORT_ENGINEER_ID", nullable = true)
	@MapKeyColumn(name = "CASE_LOG_ID", nullable = true)
	protected Map<String, Incident> assignedIncidents;

	public int getSupportEngineerId() {
		return supportEngineerId;
	}

	public void setSupportEngineerId(int supportEngineerId) {
		this.supportEngineerId = supportEngineerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, Incident> getAssignedIncidents() {
		return assignedIncidents;
	}

	public void setAssignedIncidents(Map<String, Incident> assignedIncidents) {
		this.assignedIncidents = assignedIncidents;
	}

	@Override
	public String toString() {
		return "SupportEngineer [supportEngineerId=" + supportEngineerId
				+ ", name=" + name + ", designation=" + designation
				+ ", level=" + level + ", contactNo=" + contactNo + ", email="
				+ email + ", assignedIncidents=" + assignedIncidents + "]";
	}

}
