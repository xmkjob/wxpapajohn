package com.papa.wx.web.controller;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;


















import java.util.Random;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.session.Session;
import org.json.JSONArray;
import org.json.JSONObject;
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
import com.papa.wx.web.model.Customer;
import com.papa.wx.web.model.Groups;
import com.papa.wx.web.model.Message;
import com.papa.wx.web.model.Poxy;
import com.papa.wx.web.model.SalesConsultant;
import com.papa.wx.web.result.JsonResult;
import com.papa.wx.web.service.BonusService;
import com.papa.wx.web.service.CustomerService;
import com.papa.wx.web.service.MessageService;
import com.papa.wx.web.service.PoxyService;
import com.papa.wx.web.service.SalesConsultantService;
import com.papa.wx.web.util.CFConstants;
import com.papa.wx.web.util.JsonUtil;




@Controller
public class CustomerController {
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
	static Random random = new Random();
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SalesConsultantService salesConsultantService;
	
	@Autowired
	private MessageService messageService;
	
	@Autowired
	private PoxyService poxyService;
	
	@RequestMapping(value="/mobile/login")
	public String showIndex(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/login";
	
    }
	
	@RequestMapping(value="/mobile/Noname1")
	public String showtest(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/Noname1";
	
    }
	
	@RequestMapping(value="/mobile/top")
	public String showtop(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/top";
	
    }
	@RequestMapping(value="/mobile/right_top")
	public String showright(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/right_top";
	
    }
	
	@RequestMapping(value="/mobile/left")
	public String showrleft(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/left";
	
    }
	@RequestMapping(value="/mobile/main")
	public String showadmin(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "/mobile/main";
	
    }
	
	
	@RequestMapping(value="/mobile/floorl")
	public String show02(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		
		Customer c = (Customer) request.getSession().getAttribute("customer");
		String un = request.getParameter("userName");
		if(c==null&&"".equals(un)){
				return "/mobile/login";
		}else{
				
			String username = request.getParameter("userName");
			String password = request.getParameter("passWord");
			String cityId = request.getParameter("cityId");
			List<Object>  objlist = new ArrayList<Object>();
			
		if(!"".equals(username)&&"admin".equals(username)){
			Customer customer = customerService.foundByUsername(username);
			
			List<Customer> culist = customerService.foundAll();
		
			if(culist!=null&&culist.size()>0){
				
				for(int i = 0 ; i<culist.size() ; i++){
					List<String> itemlist = new ArrayList<String>();
					Customer cu = culist.get(i);
					List<Message> messagelist = messageService.foundByCustomerId(cu.getId());
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String today = sdf.format(new Date());
					List<Message> todaymessagelist = new ArrayList<Message>();
					//List<Message> distinctlist = new ArrayList<Message>();
					try {
						Date date = sdf.parse(today);
						
						System.out.println("today:"+today);
						todaymessagelist = messageService.findByCustomerIdAndCreatetimeGreaterThan(cu.getId(),date);
						
						
						
						//todaymessagelist = messageService.findByCustomerIdAndSalesConsultantIdDistinct(cu.getId(), )
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					long mecount = 0;
					String cuname = cu.getUsername();
					long cucity = cu.getCityid();
					long todaycount = 0;
					long salecount = 0;
					long poxycount = 0;
					if(messagelist!=null&&messagelist.size()>0){
						mecount = messagelist.size();
					}if(todaymessagelist!=null&&todaymessagelist.size()>0){
						todaycount = todaymessagelist.size();
						
						Set<String> saleidList = new HashSet<String>();
						
						for(int j = 0; j<todaymessagelist.size() ;j++){
							String saleid = todaymessagelist.get(j).getSalesConsultantId()+"";
							saleidList.add(saleid);
						}
						
						salecount=saleidList.size();
						
						Set<String>poxyidList = new HashSet<String>();
						
						for(int k = 0; k<todaymessagelist.size() ;k++){
							String poxyid = todaymessagelist.get(k).getPoxyId()+"";
							System.out.println("poxyId:"+poxyid);
							poxyidList.add(poxyid);
						}
						
						salecount=saleidList.size();
						poxycount = poxyidList.size();
						
					}
					
					itemlist.add(cuname);
					itemlist.add(mecount+"");
					itemlist.add(cucity+"");
					itemlist.add(todaycount+"");
					itemlist.add(salecount+"");
					itemlist.add(poxycount+"");
					objlist.add(itemlist);
					
				}
				
			}
			
			
			//System.out.println("aaaaaaaaaaaaaaaaaaaaaa:"+objlist.size());
			model.addAttribute("objlist", objlist);
			model.addAttribute("cusotmer", customer);
			return "/mobile/main";
		}
		else{
			Customer customer = customerService.foundByUsername(username);
			cityId = customer.getCityid()+"";
			if("".equals(cityId)||cityId==null){
				cityId="1";
			}
			
			String psd = customer.getPassword();
			
			//获取楼盘
			//String url = "http://xinfangim-qa.sohusce.com/auto/groups?cityId="+cityId;
			String url = "http://xinfangim.sohusce.com/auto/groups?cityId="+cityId;
			JSONObject json = new JsonUtil().getJSONObjectByGet(url);
			JSONObject jsonobj;
			List<Groups> list = new ArrayList<Groups>();
			List<SalesConsultant> salelist = new ArrayList<SalesConsultant>();
			try {
				
				
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date = sdf.format(new Date());
				Date today = sdf.parse(date);
				
				jsonobj = new JSONObject(json.toString());
				JSONArray groups = jsonobj.getJSONArray("data");  
				
				for (int i = 0; i < groups.length(); i++) {  
				       JSONObject group = new JSONObject(groups.getString(i));
						String gid = group.getString("groupId"); 
				      
						//获取置业顾问
				      // String conurl = "http://xinfangim-qa.sohusce.com/auto/consultants?groupId="+gid;
						String conurl = "http://xinfangim.sohusce.com/auto/consultants?groupId="+gid;
				       JSONObject salejson = new JsonUtil().getJSONObjectByGet(conurl);
				       JSONObject salejsonobj;
				       salejsonobj = new JSONObject(salejson.toString());
				       JSONArray salearr = salejsonobj.getJSONArray("data");
						
						if(salearr!=null&&salearr.length()>0){
							for(int k = 0 ;k<salearr.length();k++){
								JSONObject sale = new JSONObject(salearr.getString(k));
								SalesConsultant sc = new SalesConsultant();
								sc.setBuildName(sale.getString("buildName"));
								sc.setGroupId(sale.getLong("groupId"));
								sc.setName(sale.getString("name"));
								
								//String online = sale.getString("online");
								sc.setOnline(sale.getString("online").equals("true")?1:0);
								sc.setPhone400(sale.getString("phone400"));
								sc.setPicUrl(sale.getString("picUrl"));
								sc.setUid(sale.getLong("uid"));
								salelist.add(sc);
							}
							for(int j = 0 ;j<salearr.length();j++){
								JSONObject sale = new JSONObject(salearr.getString(j));
								
								List<Poxy> poxyl = poxyService.findByCustomeridAndSaleidAndCreatetimeGreaterThan(customer.getId(),sale.getLong("uid"), today);
								System.out.println("ccccccccccccccccccc:"+customer.getId());
								System.out.println("ppppppppppp:"+poxyl.size());
								if(poxyl==null||poxyl.size()<=0){
									
									for(int m = 0;m<4;m++){
										long min = 1000000001L;
								    	long max = 1001000000L;
								    	long num = max - min;
								        long poxyno =  min + (long) (random.nextDouble()*num);
										Poxy poxy = new Poxy();
										
										poxy.setCreatetime(new Date());
										poxy.setCustomerid(customer.getId());
										poxy.setPoxyno(poxyno+"");
										poxy.setGroupid(group.getLong("groupId"));
										poxy.setSaleid(sale.getLong("uid"));
										poxyService.save(poxy);
									}
								}
							}
						}
			       Groups g = new Groups();
			       
			       g.setGroupId(group.getLong("groupId"));
			       g.setBuildName(group.getString("buildName"));
			       g.setUrl(group.getString("url"));
				
				    list.add(g);
				}  
				
				System.out.println("list:"+list.size());  
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(!"".equals(password)&&password.equals(psd)){
				
				HttpSession session = request.getSession();
				
				session.setAttribute("user", customer);
				model.addAttribute("customer", customer);
				//model.addAttribute("customers", customers);
				//System.out.println("customers:"+customers.size());
				model.addAttribute("sales", salelist);
				model.addAttribute("groups", list);
				
				
				return "/mobile/floorl";
			}else{
				return "/mobile/login";
			}
		
		}
		}
    }
	
	
	@RequestMapping(value="/mobile/webchat")
	public String showWebchat(Model model, HttpServletRequest request, HttpServletResponse response) {
		
			return "/mobile/webchat";
		
	
    }
	
	
}
