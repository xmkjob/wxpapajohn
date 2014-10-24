package com.papa.wx.web.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the message database table.
 * 
 */
@Entity
@Table(name="poxy")
@NamedQuery(name="Poxy.findAll", query="SELECT p FROM Poxy p")
public class Poxy implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private long id;
	private long customerid;
	private String poxyno;
	private long groupid;
	private long saleid;
	private Date createtime;
	
	

	public Poxy() {
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
	public long getCustomerid() {
		return customerid;
	}


	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	@Column(nullable=false, length=255)
	public String getPoxyno() {
		return poxyno;
	}


	public void setPoxyno(String poxyno) {
		this.poxyno = poxyno;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreatetime() {
		return createtime;
	}


	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Column(nullable=false, length=10)
	public long getGroupid() {
		return groupid;
	}


	public void setGroupid(long groupid) {
		this.groupid = groupid;
	}

	@Column(nullable=false, length=10)
	public long getSaleid() {
		return saleid;
	}


	public void setSaleid(long saleid) {
		this.saleid = saleid;
	}
	
	

	

}