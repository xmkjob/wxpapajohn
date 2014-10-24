package com.papa.wx.web.service;

import java.util.Date;
import java.util.List;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.Message;





public interface MessageService {
	
	
	public void save( Message user );
	
	public List<Message> findAll();
	public List<Message> foundByCustomerId(long customerId);
	public List<Message> findByPoxyId(String poxyId);
	public List<Message> findByPoxyIdAndSalesConsultantId(String poxyId,long salesConsultantId);
	public List<Message> findByPoxyIdAndSalesConsultantIdOrderByCreatetimeDesc(String poxyId,long salesConsultantId);
	public List<Message> findByCustomerIdAndStatus(long customerId,int status);
	
	public List<Message> findByCreatetimeLike(String createtime);
}
