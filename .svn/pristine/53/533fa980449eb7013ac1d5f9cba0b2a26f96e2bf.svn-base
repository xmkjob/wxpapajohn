package com.papa.wx.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.Message;
import com.papa.wx.web.repository.BonuslistRepository;
import com.papa.wx.web.repository.CustomerRepository;
import com.papa.wx.web.repository.MessageRepository;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.service.CustomerService;
import com.papa.wx.web.service.MessageService;



@Service
public class JpaMessageService implements MessageService {

	
	@Autowired
	MessageRepository messageRepository;

	
	public void save(Message user) {
		
		// TODO Auto-generated method stub
		if(user!=null){
			messageRepository.save(user);
		}
	}



	@Override
	public List<Message> foundByCustomerId(long customerId) {
		// TODO Auto-generated method stub
		return  messageRepository.findByCustomerId(customerId);
	}


	@Override
	public List<Message> findAll() {
		// TODO Auto-generated method stub
		return messageRepository.findAll();
	}



	@Override
	public List<Message> findByPoxyId(String poxyId) {
		// TODO Auto-generated method stub
		return messageRepository.findByPoxyId(poxyId);
	}



	@Override
	public List<Message> findByPoxyIdAndSalesConsultantIdOrderByCreatetimeDesc(String poxyId,
			long salesConsultantId) {
		// TODO Auto-generated method stub
		return messageRepository.findByPoxyIdAndSalesConsultantIdOrderByCreatetimeDesc(poxyId, salesConsultantId);
	}



	@Override
	public List<Message> findByCustomerIdAndStatus(long customerId, int status) {
		// TODO Auto-generated method stub
		return messageRepository.findByCustomerIdAndStatus(customerId, status);
	}



	@Override
	public List<Message> findByPoxyIdAndSalesConsultantId(String poxyId,
			long salesConsultantId) {
		// TODO Auto-generated method stub
		return messageRepository.findByPoxyIdAndSalesConsultantId(poxyId,salesConsultantId);
	}



	@Override
	public List<Message> findByCreatetimeLike(String createtime) {
		// TODO Auto-generated method stub
		return messageRepository.findByCreatetimeLike(createtime);
	}


}
