package com.ip.entities;

public class AudioCd extends Cd {
	private String artist;
	private int tracks;

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getTracks() {
		return tracks;
	}

	public void setTracks(int tracks) {
		this.tracks = tracks;
	}

	@Override
	public String toString() {
		return "AudioCd [artist=" + artist + ", tracks=" + tracks
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle()
				+ ", getPrice()=" + getPrice() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + "]";
	}

}
