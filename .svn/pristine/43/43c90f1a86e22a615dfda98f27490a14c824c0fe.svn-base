package com.papa.wx.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

import com.papa.wx.web.model.Groups;
import com.papa.wx.web.model.Message;
import com.papa.wx.web.model.Poxy;
import com.papa.wx.web.model.SalesConsultant;
import com.papa.wx.web.result.JsonResult;
import com.papa.wx.web.service.MessageService;
import com.papa.wx.web.service.PoxyService;
import com.papa.wx.web.service.SalesConsultantService;
import com.papa.wx.web.util.CFConstants;
import com.papa.wx.web.util.JsonUtil;

/*
 * the controller is used to provide the page held by Jinxin

 2. 产品预约（预约 order，选择orderselect，完成ordercomplet）

 3. 绑定，解绑
 */

@Controller
public class PoxyJsonController {

	private static final Logger LOG = LoggerFactory
			.getLogger(PoxyJsonController.class);

	@Autowired
	private PoxyService poxyService;

	@RequestMapping(value = "/mobile/poxy")
	public ModelAndView poxy(HttpServletRequest request,
			HttpServletResponse response) {
		// http://localhost:8080/wxpapajohn/mobile/get?to=100000&from=4&message=bbbbbb777777&imageUrl=images/8.jpg&thumbnail=images/8.jpg&createTime=1413776734771&type=2
		String saleid = request.getParameter("saleid");
		String groupid = request.getParameter("groupid");

		groupid = groupid.split("_")[1];

		System.out.println("saleid:" + saleid);
		System.out.println("groupid:" + groupid);
		try {
			// long toId = 0;
			long saleId = 0;

			long groupId = 0;

			if (!"".equals(saleid) && saleid != null) {
				saleId = Long.parseLong(saleid);
			}
			if (!"".equals(groupid) && groupid != null) {
				groupId = Long.parseLong(groupid);
			}

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String datesring = sdf.format(new Date());
			Date date = sdf.parse(datesring);
			List<Poxy> list = poxyService.findByGroupidAndSaleidAndCreatetimeGreaterThan(groupId, saleId, date);

			JsonUtil json1 = new JsonUtil();
			for (int i = 0; i < list.size(); i++) {
				Poxy poxy = list.get(i);
				JsonUtil json_a = new JsonUtil();
				json_a.add("groupid", poxy.getGroupid() + "");
				json_a.add("poxyno", poxy.getPoxyno());
				json_a.add("saleid", poxy.getSaleid() + "");
				json_a.add("customerid", poxy.getCustomerid() + "");
				json_a.add("id", poxy.getId() + "");
				json1.add("data", json_a);
			}

			JSONObject arr1 = new JSONObject(json1.toString());
			// System.out.println("arr1:"+arr1);

			// 将查询出来的对象集合转换为json格式

			JSONArray array = arr1.getJSONArray("data");

			System.out.println("array:" + array);
			// 给请求作出响应
			response.getWriter().write(array.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
