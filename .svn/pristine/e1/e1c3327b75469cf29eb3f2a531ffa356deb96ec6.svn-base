package com.papa.wx.web.service.impl;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.hash.Sha384Hash;
import org.apache.shiro.util.ByteSource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.util.RandomGenerate;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext-dev.xml"})
public class JxRestfulServiceTest {


	@Before
	public void setUp() throws Exception {
		
		//accountTestSupport.deleteByName(name);
	}
	
	@Autowired
	private BonusService bonusService;
	
	
	@Test
	public void setBonuslist() {
		
		String verCode = RandomGenerate.generateBonusCode();
				
		Bonuslist bonus = new Bonuslist();
		bonus.setUsername("test"+verCode);
		bonus.setPhonenum("1299222222");
		bonus.setAddress("北京");
		bonus.setBonusno(verCode);
		bonus.setCreattime(new Date());
		
		bonusService.save(bonus);
		
	}

}
