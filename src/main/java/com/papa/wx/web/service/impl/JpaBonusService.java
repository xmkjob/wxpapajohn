package com.papa.wx.web.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.repository.BonuslistRepository;
import com.papa.wx.web.service.BonusService;



@Service
public class JpaBonusService implements BonusService {

	
	@Autowired
	BonuslistRepository bonuslistRepository;

	
	public void save(Bonuslist user) {
		
		// TODO Auto-generated method stub
		if(user!=null){
			bonuslistRepository.save(user);
		}
	}

	
	public List<Bonuslist> foundAll() {
		// TODO Auto-generated method stub
		return bonuslistRepository.findAll();
	}

	
	public List<Bonuslist> foundByCreattime(Date start, Date end) {
		// TODO Auto-generated method stub
		return bonuslistRepository.findByCreattime(start, end);
	}


}
