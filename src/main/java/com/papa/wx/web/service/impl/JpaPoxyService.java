package com.papa.wx.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.Message;
import com.papa.wx.web.model.Poxy;
import com.papa.wx.web.repository.BonuslistRepository;
import com.papa.wx.web.repository.CustomerRepository;
import com.papa.wx.web.repository.MessageRepository;
import com.papa.wx.web.repository.PoxyRepository;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.service.CustomerService;
import com.papa.wx.web.service.MessageService;
import com.papa.wx.web.service.PoxyService;



@Service
public class JpaPoxyService implements PoxyService {

	
	@Autowired
	PoxyRepository poxyRepository;

	
	public void save(Poxy poxy) {
		
		// TODO Auto-generated method stub
		if(poxy!=null){
			poxyRepository.save(poxy);
		}
	}



	@Override
	public List<Poxy> foundByCustomerid(long customerid) {
		// TODO Auto-generated method stub
		return  poxyRepository.findByCustomerid(customerid);
	}


	@Override
	public List<Poxy> findAll() {
		// TODO Auto-generated method stub
		return poxyRepository.findAll();
	}



	@Override
	public List<Poxy> findByGroupid(long groupid) {
		// TODO Auto-generated method stub
		return poxyRepository.findByGroupid(groupid);
	}



	@Override
	public List<Poxy> findByGroupidAndSaleid(long groupid, long saleid) {
		// TODO Auto-generated method stub
		return poxyRepository.findByGroupidAndSaleid(groupid, saleid);
	}



	@Override
	public Poxy foundByCustomeridAndPoxyno(long customerid, String poxyno) {
		// TODO Auto-generated method stub
		return poxyRepository.findByCustomeridAndPoxyno(customerid, poxyno);
	}



	@Override
	public List<Poxy> findBySaleidAndCreatetimeGreaterThan(long saleid,Date createtime) {
		// TODO Auto-generated method stub
		return poxyRepository.findBySaleidAndCreatetimeGreaterThan(saleid,createtime);
	}



	@Override
	public List<Poxy> findByGroupidAndSaleidAndCreatetimeGreaterThan(
			long groupid, long saleid, Date createtime) {
		// TODO Auto-generated method stub
		return poxyRepository.findByGroupidAndSaleidAndCreatetimeGreaterThan(groupid,saleid, createtime);
	}



	@Override
	public List<Poxy> findByCustomeridAndCreatetimeGreaterThan(long customerid,
			Date createtime) {
		// TODO Auto-generated method stub
		return poxyRepository.findByCustomeridAndCreatetimeGreaterThan(customerid, createtime);
	}



}
