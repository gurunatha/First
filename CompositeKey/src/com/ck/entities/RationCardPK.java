package com.ck.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RationCardPK implements Serializable {
	@Column(name = "RATION_CARD_NO")
	private int rationCardNo;
	@Column(name = "WARD_NO")
	private int wardNo;

	public int getRationCardNo() {
		return rationCardNo;
	}

	public void setRationCardNo(int rationCardNo) {
		this.rationCardNo = rationCardNo;
	}

	public int getWardNo() {
		return wardNo;
	}

	public void setWardNo(int wardNo) {
		this.wardNo = wardNo;
	}

}
