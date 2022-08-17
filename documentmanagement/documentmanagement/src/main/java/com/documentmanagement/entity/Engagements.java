package com.documentmanagement.entity;

public class Engagements {
	private String engagementName;
	private String engagementDesc;

	public String getEngagementName() {
		return engagementName;
	}

	public void setEngagementName(String engagementName) {
		this.engagementName = engagementName;
	}

	public String getEngagementDesc() {
		return engagementDesc;
	}

	public void setEngagementDesc(String engagementDesc) {
		this.engagementDesc = engagementDesc;
	}

	public Engagements(String engagementName, String engagementDesc) {
		super();
		this.engagementName = engagementName;
		this.engagementDesc = engagementDesc;
	}

}
