package com.papa.wx.web.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the bonuslist database table.
 * 
 */
@Entity
@Table(name="bonuslist")
@NamedQuery(name="Bonuslist.findAll", query="SELECT b FROM Bonuslist b")
public class Bonuslist implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String address;
	private String bonusno;
	private Date creattime;
	private String phonenum;
	private String username;

	public Bonuslist() {
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
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	@Column(nullable=false, length=255)
	public String getBonusno() {
		return this.bonusno;
	}

	public void setBonusno(String bonusno) {
		this.bonusno = bonusno;
	}


	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	public Date getCreattime() {
		return this.creattime;
	}

	public void setCreattime(Date creattime) {
		this.creattime = creattime;
	}


	@Column(nullable=false, length=255)
	public String getPhonenum() {
		return this.phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}


	@Column(nullable=false, length=255)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}