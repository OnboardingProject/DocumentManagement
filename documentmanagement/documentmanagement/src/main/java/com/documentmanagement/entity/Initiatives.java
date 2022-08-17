package com.documentmanagement.entity;

public class Initiatives {

	private String initiativeName;
	private String initiativeDesc;

	public String getInitiativeName() {
		return initiativeName;
	}

	public void setInitiativeName(String initiativeName) {
		this.initiativeName = initiativeName;
	}

	public String getInitiativeDesc() {
		return initiativeDesc;
	}

	public void setInitiativeDesc(String initiativeDesc) {
		this.initiativeDesc = initiativeDesc;
	}

	public Initiatives(String initiativeName, String initiativeDesc) {
		super();
		this.initiativeName = initiativeName;
		this.initiativeDesc = initiativeDesc;
	}

}
