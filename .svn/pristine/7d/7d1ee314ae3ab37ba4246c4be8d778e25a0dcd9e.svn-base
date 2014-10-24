package com.papa.wx.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.repository.BonuslistRepository;
import com.papa.wx.web.repository.CustomerRepository;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.service.CustomerService;



@Service
public class JpaCustomerService implements CustomerService {

	
	@Autowired
	CustomerRepository customerRepository;

	
	public void save(Customer user) {
		
		// TODO Auto-generated method stub
		if(user!=null){
			customerRepository.save(user);
		}
	}

	
	


	@Override
	public Customer foundByUsername(String username) {
		// TODO Auto-generated method stub
		return  customerRepository.findByUsername(username);
	}





	@Override
	public List<Customer> foundAll() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	
	

}
