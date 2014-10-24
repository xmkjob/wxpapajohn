package com.papa.wx.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.SalesConsultant;
import com.papa.wx.web.repository.BonuslistRepository;
import com.papa.wx.web.repository.CustomerRepository;
import com.papa.wx.web.repository.SalesConsultantRepository;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.service.CustomerService;
import com.papa.wx.web.service.SalesConsultantService;



@Service
public class JpaSalesConsultantService implements SalesConsultantService {

	
	@Autowired
	SalesConsultantRepository salesConsultantRepository;

	
	public void save(SalesConsultant user) {
		
		// TODO Auto-generated method stub
		if(user!=null){
			salesConsultantRepository.save(user);
		}
	}

	
	


	@Override
	public SalesConsultant foundByName(String name) {
		// TODO Auto-generated method stub
		return  salesConsultantRepository.findByName(name);
	}





	@Override
	public List<SalesConsultant> findAll() {
		// TODO Auto-generated method stub
		return salesConsultantRepository.findAll();
	}





	@Override
	public List<SalesConsultant> findByGroupId(long groupId) {
		// TODO Auto-generated method stub
		return salesConsultantRepository.findByGroupId(groupId);
	}





	@Override
	public SalesConsultant findByUid(long uid) {
		// TODO Auto-generated method stub
		return salesConsultantRepository.findByUid(uid);
	}

	
	

}
