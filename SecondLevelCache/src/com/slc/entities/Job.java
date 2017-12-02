package com.slc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "JOBS")
@Cache(region = "job", usage = CacheConcurrencyStrategy.READ_ONLY)
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "JOB_ID")
	protected int jobId;
	@Column(name = "JOB_DESCR")
	protected String jobDescription;
	@Column(name = "JOB_LEVEL")
	protected String level;
	protected String technology;
	@Column(name = "JOB_POSTED_DT")
	protected Date postedDate;
	protected String location;

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public Date getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Date postedDate) {
		this.postedDate = postedDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobDescription=" + jobDescription
				+ ", level=" + level + ", technology=" + technology
				+ ", postedDate=" + postedDate + ", location=" + location + "]";
	}

}
