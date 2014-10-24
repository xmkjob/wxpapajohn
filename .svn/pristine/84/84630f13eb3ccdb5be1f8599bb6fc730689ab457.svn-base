package com.papa.wx.web.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="message")
@NamedQuery(name="Message.findAll", query="SELECT m FROM Message m")
public class Message implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private long customerId;
	private long salesConsultantId;
	private String details;
	private int type;
	private String poxyId;
	private int status;
	private Date createtime;
	private String imgurl;
	private String thumbnail;
	private int sendtype;
	

	public Message() {
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

	@Column(nullable=false, length=10)
	public long getCustomerId() {
		return customerId;
	}


	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	@Column(nullable=false, length=10)
	public long getSalesConsultantId() {
		return salesConsultantId;
	}


	public void setSalesConsultantId(long salesConsultantId) {
		this.salesConsultantId = salesConsultantId;
	}

	@Column(nullable=false,length=2000)
	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}

	@Column(nullable=false,length=2)
	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}
	
	
	@Column(nullable=false,length=2)
	public int getSendtype() {
		return sendtype;
	}


	public void setSendtype(int sendtype) {
		this.sendtype = sendtype;
	}


	@Column(nullable=false,length=255)
	public String getPoxyId() {
		return poxyId;
	}


	public void setPoxyId(String poxyId) {
		this.poxyId = poxyId;
	}

	@Column(nullable=false,length=2)
	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(nullable=false,length=255)
	public String getImgurl() {
		return imgurl;
	}


	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	@Column(nullable=false,length=255)
	public String getThumbnail() {
		return thumbnail;
	}


	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	

}