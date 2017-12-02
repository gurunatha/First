package com.cm.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TarrifDetails {
	@Column(name = "LOCAL_CALL_COST")
	private float localCallCost;
	@Column(name = "STD_CALL_COST")
	private float stdCallCost;
	@Column(name = "ISD_CALL_COST")
	private float isdCallCost;
	@Column(name = "LOCAL_MESSAGE_COST")
	private float localMessageCost;

	public float getLocalCallCost() {
		return localCallCost;
	}

	public void setLocalCallCost(float localCallCost) {
		this.localCallCost = localCallCost;
	}

	public float getStdCallCost() {
		return stdCallCost;
	}

	public void setStdCallCost(float stdCallCost) {
		this.stdCallCost = stdCallCost;
	}

	public float getIsdCallCost() {
		return isdCallCost;
	}

	public void setIsdCallCost(float isdCallCost) {
		this.isdCallCost = isdCallCost;
	}

	public float getLocalMessageCost() {
		return localMessageCost;
	}

	public void setLocalMessageCost(float localMessageCost) {
		this.localMessageCost = localMessageCost;
	}

}
