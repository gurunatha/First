package com.ip.entities;

public class VideoCd extends Cd {
	private String director;
	private long duration;

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "VideoCd [director=" + director + ", duration=" + duration
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getPrice()=" + getPrice() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
