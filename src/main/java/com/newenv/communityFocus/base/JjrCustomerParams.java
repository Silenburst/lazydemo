package com.newenv.communityFocus.base;

import com.newenv.communityFocus.domain.jinggeng.CustomerCommunicator;
import com.newenv.communityFocus.domain.jinggeng.CustomerInfo;
import com.newenv.communityFocus.domain.jinggeng.CustomerRequirement;
import com.newenv.communityFocus.domain.jinggeng.CustomerRequirementOfBuy;
import com.newenv.communityFocus.domain.jinggeng.CustomerRequirementOfRent;
import com.newenv.communityFocus.domain.jinggeng.PersonInfo;
import com.newenv.communityFocus.domain.jinggeng.Relationship;

public class JjrCustomerParams  {
	
	private PersonInfo personInfo;
	
	private CustomerRequirement customerReq;
	
	private CustomerInfo customerInfo;
	
	private CustomerRequirementOfBuy buyInfo;
	
	private CustomerRequirementOfRent rentInfo;

	private CustomerCommunicator [] communicator;
	
	private Relationship relationship;
	
	private int type;
	private long fhid ;
	
	private int creatorId;
	private int bmId  ;
	
	private Integer stage;
	
	
	public long getFhid() {
		return fhid;
	}



	public void setFhid(long fhid) {
		this.fhid = fhid;
	}



	public Relationship getRelationship() {
		return relationship;
	}
	
	

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}

	public PersonInfo getPersonInfo() {
		return personInfo;
	}

	public void setPersonInfo(PersonInfo personInfo) {
		this.personInfo = personInfo;
	}

	public CustomerRequirement getCustomerReq() {
		return customerReq;
	}

	public void setCustomerReq(CustomerRequirement customerReq) {
		this.customerReq = customerReq;
	}

	public CustomerInfo getCustomerInfo() {
		return customerInfo;
	}

	public void setCustomerInfo(CustomerInfo customerInfo) {
		this.customerInfo = customerInfo;
	}

	public CustomerRequirementOfBuy getBuyInfo() {
		return buyInfo;
	}

	public void setBuyInfo(CustomerRequirementOfBuy buyInfo) {
		this.buyInfo = buyInfo;
	}

	public CustomerRequirementOfRent getRentInfo() {
		return rentInfo;
	}

	public void setRentInfo(CustomerRequirementOfRent rentInfo) {
		this.rentInfo = rentInfo;
	}




	public int getType() {
		return type;
	}



	public void setType(int type) {
		this.type = type;
	}



	public CustomerCommunicator [] getCommunicator() {
		return communicator;
	}



	public void setCommunicator(CustomerCommunicator [] communicator) {
		this.communicator = communicator;
	}


	public int getCreatorId() {
		return creatorId;
	}



	public void setCreatorId(int creatorId) {
		this.creatorId = creatorId;
	}



	public int getBmId() {
		return bmId;
	}



	public void setBmId(int bmId) {
		this.bmId = bmId;
	}



	public Integer getStage() {
		return stage;
	}



	public void setStage(Integer stage) {
		this.stage = stage;
	}
}
