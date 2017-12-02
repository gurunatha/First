package com.otm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "APPROVAL")
public class Approval {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "APPROVAL_ID")
	protected int approvalId;
	@Column(name = "APPROVAL_NM")
	protected String approvalName;
	@Column(name = "DESCR")
	protected String description;
	@Column(name = "ISSUED_DT")
	protected Date issuedDate;
	@Column(name = "ISSUED_AUTHORITY")
	protected String issuedAuthority;
	@ManyToOne
	@JoinColumn(name = "PROPERTY_ID", nullable = false)
	protected Property property;

	public int getApprovalId() {
		return approvalId;
	}

	public void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public String getApprovalName() {
		return approvalName;
	}

	public void setApprovalName(String approvalName) {
		this.approvalName = approvalName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

	public String getIssuedAuthority() {
		return issuedAuthority;
	}

	public void setIssuedAuthority(String issuedAuthority) {
		this.issuedAuthority = issuedAuthority;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((approvalName == null) ? 0 : approvalName.hashCode());
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
		Approval other = (Approval) obj;
		if (approvalName == null) {
			if (other.approvalName != null)
				return false;
		} else if (!approvalName.equals(other.approvalName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Approval [approvalId=" + approvalId + ", approvalName="
				+ approvalName + ", description=" + description
				+ ", issuedDate=" + issuedDate + ", issuedAuthority="
				+ issuedAuthority + "]";
	}

}
