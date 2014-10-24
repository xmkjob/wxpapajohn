package com.papa.wx.web.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the SalesConsultant database table.
 * 
 */
@Entity
@Table(name="salesConsultant")
@NamedQuery(name="SalesConsultant.findAll", query="SELECT s FROM SalesConsultant s")
public class SalesConsultant implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String name;
	private long groupId;
	private String buildName;
	private long uid;
	private int online;
	private String phone400;
	private String picUrl;
	

	public SalesConsultant() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(nullable=false, length=255)
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable=false, length=10)
	public long getGroupId() {
		return groupId;
	}


	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	@Column(nullable=false, length=255)
	public String getBuildName() {
		return buildName;
	}


	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}

	@Column(nullable=false, length=10)
	public long getUid() {
		return uid;
	}


	public void setUid(long uid) {
		this.uid = uid;
	}

	@Column(nullable=false, length=2)
	public int getOnline() {
		return online;
	}


	public void setOnline(int online) {
		this.online = online;
	}

	@Column(nullable=false, length=255)
	public String getPhone400() {
		return phone400;
	}


	public void setPhone400(String phone400) {
		this.phone400 = phone400;
	}

	@Column(nullable=false, length=255)
	public String getPicUrl() {
		return picUrl;
	}


	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	
	


	

	

}