package com.oto.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "SPECIFICATION")
public class Specification {
	@Id
	@GenericGenerator(name = "foreign_generator", strategy = "foreign", parameters = { @Parameter(name = "property", value = "mobile") })
	@GeneratedValue(generator = "foreign_generator")
	protected int mobileId;
	protected String networkType;
	protected boolean dualSim;
	protected String mobileData;
	protected String processor;
	protected String storage;
	protected String ram;

	@OneToOne
	@PrimaryKeyJoinColumn
	protected Mobile mobile;

	public int getMobileId() {
		return mobileId;
	}

	public void setMobileId(int mobileId) {
		this.mobileId = mobileId;
	}

	public String getNetworkType() {
		return networkType;
	}

	public void setNetworkType(String networkType) {
		this.networkType = networkType;
	}

	public boolean isDualSim() {
		return dualSim;
	}

	public void setDualSim(boolean dualSim) {
		this.dualSim = dualSim;
	}

	public String getMobileData() {
		return mobileData;
	}

	public void setMobileData(String mobileData) {
		this.mobileData = mobileData;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getStorage() {
		return storage;
	}

	public void setStorage(String storage) {
		this.storage = storage;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Mobile getMobile() {
		return mobile;
	}

	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Specification [mobileId=" + mobileId + ", networkType="
				+ networkType + ", dualSim=" + dualSim + ", mobileData="
				+ mobileData + ", processor=" + processor + ", storage="
				+ storage + ", ram=" + ram + ", mobile=" + mobile + "]";
	}

}
