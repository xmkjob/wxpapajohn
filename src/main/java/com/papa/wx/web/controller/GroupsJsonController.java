package com.papa.wx.web.controller;






import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.papa.wx.web.model.SalesConsultant;
import com.papa.wx.web.service.PoxyService;
import com.papa.wx.web.service.SalesConsultantService;
import com.papa.wx.web.util.JsonUtil;



/*
 * the controller is used to provide the page held by Jinxin

2. 产品预约（预约 order，选择orderselect，完成ordercomplet）

3. 绑定，解绑
 */


@Controller
public class GroupsJsonController {
	
	private static final Logger LOG = LoggerFactory.getLogger(GroupsJsonController.class);

	@Autowired
	private SalesConsultantService salesConsultantService;
	
	@Autowired
	private PoxyService poxyService;
	

	@RequestMapping(value="/mobile/ajax1")
	public ModelAndView  ajax1( HttpServletRequest request, HttpServletResponse response) {
		
		String groupId = request.getParameter("groupId");
		groupId = groupId.split("_")[1];
		long groupid = Long.parseLong(groupId);
        response.setContentType("text/Xml;charset=UTF-8"); 
       
        try {

			//获取置业顾问
	       //String conurl = "http://xinfangim-qa.sohusce.com/auto/consultants?groupId="+groupid;
        	String conurl = "http://xinfangim.sohusce.com/auto/consultants?groupId="+groupid;
	       JSONObject salejson = new JsonUtil().getJSONObjectByGet(conurl);
	       JSONObject salejsonobj;
	       salejsonobj = new JSONObject(salejson.toString());
	       JSONArray salearr = salejsonobj.getJSONArray("data");
			
            System.out.println("array:"+salearr);
            
            if(salearr!=null&&salearr.length()>0){
            	for(int i = 0 ; i<salearr.length() ; i++){
            		JSONObject sjson = salearr.getJSONObject(i);
            		SalesConsultant sc = new SalesConsultant();
            		
            		sc.setBuildName(sjson.getString("buildName"));
            		sc.setGroupId(sjson.getLong("groupId"));
            		sc.setName(sjson.getString("name"));
            	
            		sc.setOnline(sjson.getBoolean("online")==true?1:0);
            		sc.setPhone400(sjson.getString("phone400"));
            		sc.setPicUrl(sjson.getString("picUrl"));
            		sc.setUid(sjson.getLong("uid"));
            		
            		
            		SalesConsultant esixt = salesConsultantService.findByUid(sjson.getLong("uid"));
            		if(esixt==null){
            			salesConsultantService.save(sc);
            		}
            	}
            	
            }
            //给请求作出响应
            response.getWriter().write(salearr.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return null;
	
    }
	

}
