package com.wm.entities;

public class AdEnquiry {
	private int id;
	private String description;
	private int duration;
	private String email;
	private String mobile;
	private String place;
	private boolean onTv;
	private boolean internetMedia;
	private boolean newsPaper;
	private boolean hordings;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public boolean getOnTv() {
		return onTv;
	}

	public void setOnTv(boolean onTv) {
		this.onTv = onTv;
	}

	public boolean getInternetMedia() {
		return internetMedia;
	}

	public void setInternetMedia(boolean internetMedia) {
		this.internetMedia = internetMedia;
	}

	public boolean getNewsPaper() {
		return newsPaper;
	}

	public void setNewsPaper(boolean newsPaper) {
		this.newsPaper = newsPaper;
	}

	public boolean getHordings() {
		return hordings;
	}

	public void setHordings(boolean hordings) {
		this.hordings = hordings;
	}

	
}
