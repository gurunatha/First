package com.otmm.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INCIDENT")
public class Incident {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INCIDENT_ID")
	protected int incidentId;
	@Column(name = "DESCR")
	protected String description;
	@Column(name = "REPORTED_DT")
	protected Date reportedDate;
	protected int priority;
	protected String status;

	public int getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReportedDate() {
		return reportedDate;
	}

	public void setReportedDate(Date reportedDate) {
		this.reportedDate = reportedDate;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Incident [incidentId=" + incidentId + ", description="
				+ description + ", reportedDate=" + reportedDate
				+ ", priority=" + priority + ", status=" + status + "]";
	}

}
