package com.papa.wx.web.service;

import java.util.Date;
import java.util.List;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.Message;
import com.papa.wx.web.model.Poxy;





public interface PoxyService {
	
	public void save( Poxy poxy );
	public List<Poxy> findAll();
	public List<Poxy> foundByCustomerid(long customerid);
	public List<Poxy> findByGroupid(long groupid);
	public List<Poxy> findByGroupidAndSaleid(long groupid,long saleid);
	public List<Poxy> foundByCustomeridAndPoxyno(long customerid,String poxyno);
	public List<Poxy> findByGroupidAndSaleidAndCreatetimeGreaterThan(long groupid,long saleid,Date createtime);
	public List<Poxy> findBySaleidAndCreatetimeGreaterThan(long saleid,Date createtime);
	public List<Poxy> findByCustomeridAndSaleidAndCreatetimeGreaterThan(long customerid,long saleid,Date createtime);
	
	public List<Poxy> findByCustomeridAndGroupidAndSaleidAndCreatetimeGreaterThan(long customerid,long groupid,long saleid,Date createtime);
	public List<Poxy> findBySaleid(long saleid);
}
