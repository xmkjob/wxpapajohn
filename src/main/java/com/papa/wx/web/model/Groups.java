package com.papa.wx.web.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */

public class Groups implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long groupId;
	private String buildName;
	private String url;
	
	public Groups() {
	}

	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public String getBuildName() {
		return buildName;
	}

	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}


	

}