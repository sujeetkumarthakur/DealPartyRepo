package com.bs.party;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class PartyDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int partyId;
	private String name;
	private String email;
	private String mobileNumber;
	private String partyType;
	private String partySignatureName;
	private String address;
	private String branch;
	


	

	public PartyDetails() {
		super();
	}

	

	public PartyDetails(int partyId, String name, String email, String mobileNumber, String partyType,
			String partySignatureName, String address, String branch) {
		super();
		this.partyId = partyId;
		this.name = name;
		this.email = email;
		this.mobileNumber = mobileNumber;
		this.partyType = partyType;
		this.partySignatureName = partySignatureName;
		this.address = address;
		this.branch = branch;
	}



	public int getPartyId() {
		return partyId;
	}

	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getPartySignatureName() {
		return partySignatureName;
	}

	public void setPartySignatureName(String partySignatureName) {
		this.partySignatureName = partySignatureName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "PartyDetails [name=" + name + ", email=" + email + ", mobileNumber=" + mobileNumber + ", partyType="
				+ partyType + ", partySignatureName=" + partySignatureName + ", address=" + address + ", branch="
				+ branch + "]";
	}

}
