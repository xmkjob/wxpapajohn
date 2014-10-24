package com.papa.wx.web.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.papa.wx.web.model.Bonuslist;
import com.papa.wx.web.result.JsonResult;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.util.CFConstants;



@Controller
public class PaPaController {
	
	private static final Logger LOG = LoggerFactory.getLogger(PaPaController.class);

	@Autowired
	private BonusService bonusService;
	
	
	
	@RequestMapping(value="/mobile/index")
	public String showIndex(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/index";
	
    }
	
	@RequestMapping(value="/mobile/02")
	public String show02(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/02";
	
    }
	
	@RequestMapping(value="/mobile/03")
	public String show03(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/03";
	
    }
	
	@RequestMapping(value="/mobile/04")
	public String show04(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/04";
	
    }
	
	@RequestMapping(value="/mobile/05")
	public String show05(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/05";
	
    }
	
	@RequestMapping(value="/mobile/06")
	public String show06(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/06";
	
    }
	
	@RequestMapping(value="/mobile/07")
	public String show07(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/07";
	
    }

	@RequestMapping(value="/mobile/08")
	public String show08(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/08";
	
    }

	@RequestMapping(value="/mobile/09")
	public String show09(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/09";
	
    }
	
	@RequestMapping(value="/mobile/10")
	public String show10(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/10";
	
    }

	@RequestMapping(value="/mobile/11")
	public String show11(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/11";
	
    }
	
	@RequestMapping(value="/mobile/12")
	public String show12(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/12";
	
    }
	
	@RequestMapping(value="/mobile/calculator")
	public String showCalculatepage(Model model, HttpServletRequest request, HttpServletResponse response) {
	
		
		/*
		List<JinxinProductItem> productList =  jinxinService.getProductList();
		
		if(productList!=null){
			model.addAttribute("list", productList);
		}
		 */
        return "/mobile/calculator";
       
    }

	
}
