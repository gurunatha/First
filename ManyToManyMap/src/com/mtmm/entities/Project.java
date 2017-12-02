package com.mtmm.entities;

import java.util.Date;
import java.util.Map;

public class Project {
	protected int projectId;
	protected String title;
	protected String description;
	protected Date startDate;
	protected Date endDate;
	protected String client;
	protected String keyTechnologies;

	protected Map<String, Resource> assignedResources;

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getKeyTechnologies() {
		return keyTechnologies;
	}

	public void setKeyTechnologies(String keyTechnologies) {
		this.keyTechnologies = keyTechnologies;
	}

	public Map<String, Resource> getAssignedResources() {
		return assignedResources;
	}

	public void setAssignedResources(Map<String, Resource> assignedResources) {
		this.assignedResources = assignedResources;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title
				+ ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", client=" + client
				+ ", keyTechnologies=" + keyTechnologies
				+ ", assignedResources=" + assignedResources + "]";
	}

}
