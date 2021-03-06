package com.papa.wx.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.papa.wx.web.model.Message;
import com.papa.wx.web.model.Poxy;
import com.papa.wx.web.model.SalesConsultant;
import com.papa.wx.web.result.JsonMessage;
import com.papa.wx.web.result.JsonResult;
import com.papa.wx.web.service.MessageService;
import com.papa.wx.web.service.PoxyService;
import com.papa.wx.web.service.SalesConsultantService;
import com.papa.wx.web.util.HttpUtil;
import com.papa.wx.web.util.JsonUtil;

/*
 * the controller is used to provide the page held by Jinxin

 2. 产品预约（预约 order，选择orderselect，完成ordercomplet）

 3. 绑定，解绑
 */

@Controller
public class MessageJsonController {

	private static final Logger LOG = LoggerFactory
			.getLogger(MessageJsonController.class);

	@Autowired
	private MessageService messageService;

	@Autowired
	private PoxyService poxyService;

	@Autowired
	private SalesConsultantService salesConsultantService;

	@RequestMapping(value = "/mobile/send")
	public ModelAndView ajax1(HttpServletRequest request,
			HttpServletResponse response) {

		String poxyId = request.getParameter("poxyId");
		String customerId = request.getParameter("customerId");
		String salesConsultantId = request.getParameter("salesConsultantId");
		String details = request.getParameter("details");

		try {
			details = URLEncoder.encode(details, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String groupId = request.getParameter("groupId");
		groupId = groupId.split("_")[1];

		//String urlStr = "http://xinfangim-qa.sohusce.com/auto/message/send";
		String urlStr = "http://xinfangim.sohusce.com/auto/message/send";
		String param = "consultantUid=" + salesConsultantId + "&clientUid="
				+ poxyId + "&groupId=" + groupId + "&content=" + details;
		System.out.println("param:"+param);
		URL url;
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";
		try {
			url = new URL(urlStr);
			HttpURLConnection URLconnection = (HttpURLConnection) url
					.openConnection();
			URLconnection.setRequestMethod("POST");
			// 璁剧疆閫氱敤鐨勮姹傚睘鎬�
			URLconnection.setRequestProperty("accept", "*/*");
			URLconnection.setRequestProperty("connection", "Keep-Alive");
			URLconnection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 鍙戦�丳OST璇锋眰蹇呴』璁剧疆濡備笅涓よ
			URLconnection.setDoOutput(true);
			URLconnection.setDoInput(true);

			// 鑾峰彇URLConnection瀵硅薄瀵瑰簲鐨勮緭鍑烘祦
			out = new PrintWriter(URLconnection.getOutputStream());
			// 鍙戦�佽姹傚弬鏁�
			out.print(param);
			// flush杈撳嚭娴佺殑缂撳啿
			out.flush();

			// 瀹氫箟BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
			in = new BufferedReader(new InputStreamReader(
					URLconnection.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				result += "/n" + line;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch blockeb
			e.printStackTrace();
			//System.out.println("鍙戦�丳OST璇锋眰鍑虹幇寮傚父锛�" + e);
		}

		long sid = 0;
		long cid = 0;

		if (!"".equals(customerId) && customerId != null) {

			cid = Long.parseLong(customerId);
		}
		if (!"".equals(salesConsultantId) && salesConsultantId != null) {
			sid = Long.parseLong(salesConsultantId);
		}

		Message message = new Message();

		message.setCustomerId(cid);
		message.setPoxyId(poxyId);
		message.setSalesConsultantId(sid);
		try {
			details = URLDecoder.decode(details, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("save details:" + details);
		message.setDetails(details);
		message.setType(1);
		message.setCreatetime(new Date());
		message.setImgurl("");
		message.setThumbnail("");
		message.setStatus(1);
		message.setSendtype(1);
		messageService.save(message);

		return null;

	}

	@RequestMapping(value = "/mobile/tech")
	public ModelAndView tech(HttpServletRequest request,
			HttpServletResponse response) {

		String groupid = request.getParameter("groupId");
		String saleid = request.getParameter("saleid");
		String poxyid = request.getParameter("poxyid");
		String customerid = request.getParameter("customerid");
		
		
		List<Message> messagelist = messageService.findByPoxyId(poxyid);
		if(messagelist==null||messagelist.size()<=0){
			groupid = groupid.split("_")[1];
			//String urlStr = "http://xinfangim-qa.sohusce.com/auto/message/touch";
			String urlStr = "http://xinfangim.sohusce.com/auto/message/touch";
			//System.out.println("URL:" + urlStr);
			String param = "consultantUid=" + saleid + "&clientUid=" + poxyid
					+ "&groupId=" + groupid;
			
			Message message = new Message();
			long customerId = Long.parseLong(customerid);
			//long poxyId = Long.parseLong(poxyid);
			Long saleId = Long.parseLong(saleid);
			//Long groupId = Long.parseLong(groupid);
			
			if(!"".equals(poxyid)&&poxyid!=null){
				message.setImgurl("");
				message.setDetails("首次创建对话");
				message.setPoxyId(poxyid);
				message.setSendtype(1);
				message.setStatus(1);
				message.setSalesConsultantId(saleId);
				message.setCreatetime(new Date());
				message.setCustomerId(customerId);
				message.setThumbnail("");
				message.setType(1);
				messageService.save(message);
			}
			
			message.setCustomerId(customerId);
			URL url;
			PrintWriter out = null;
			BufferedReader in = null;
			String result = "";
			try {
				url = new URL(urlStr);
				HttpURLConnection URLconnection = (HttpURLConnection) url
						.openConnection();
				URLconnection.setRequestMethod("POST");
				// 璁剧疆閫氱敤鐨勮姹傚睘鎬�
				URLconnection.setRequestProperty("accept", "*/*");
				URLconnection.setRequestProperty("connection", "Keep-Alive");
				URLconnection.setRequestProperty("user-agent",
						"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
				// 鍙戦�丳OST璇锋眰蹇呴』璁剧疆濡備笅涓よ
				URLconnection.setDoOutput(true);
				URLconnection.setDoInput(true);

				// 鑾峰彇URLConnection瀵硅薄瀵瑰簲鐨勮緭鍑烘祦
				out = new PrintWriter(URLconnection.getOutputStream());
				// 鍙戦�佽姹傚弬鏁�
				out.print(param);
				// flush杈撳嚭娴佺殑缂撳啿
				out.flush();

				// 瀹氫箟BufferedReader杈撳叆娴佹潵璇诲彇URL鐨勫搷搴�
				in = new BufferedReader(new InputStreamReader(
						URLconnection.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					result += "/n" + line;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch blockeb
				e.printStackTrace();
				//System.out.println("鍙戦�丳OST璇锋眰鍑虹幇寮傚父锛�" + e);
			}

		}
		return null;
	}

	@RequestMapping(value = "/mobile/ref")
	public ModelAndView ref(HttpServletRequest request,
			HttpServletResponse response) {

		String poxyId = request.getParameter("poxyId");
		String salesConsultantId = request.getParameter("salesConsultantId");
		// System.out.println("salesConsultantId:"+salesConsultantId);
		// String url =
		// "http://pmtest.feiliu.com/api/wanpu.php?time=2014-03-05&type=1&page=2";
		System.out.println("poxyId:" + poxyId);
		System.out.println("salesConsultantId:" + salesConsultantId);

		try {
			long saleid = 0;
			if (!"".equals(salesConsultantId) && salesConsultantId != null) {
				saleid = Long.parseLong(salesConsultantId);
			}

			List<Message> list = messageService
					.findByPoxyIdAndSalesConsultantIdOrderByCreatetimeDesc(
							poxyId, saleid);
			if (list != null && list.size() > 0) {
				int lsize = list.size();
				if (lsize <10) {
					lsize = list.size();
				} else {
					lsize = 10;
				}
				
				System.out.println("lsize:"+lsize);
				JsonUtil json1 = new JsonUtil();
				for (int i = lsize-1; i >=0; i--) {
					Message msg = list.get(i);
					JsonUtil json_a = new JsonUtil();
					json_a.add("customerId", msg.getCustomerId() + "");
					json_a.add("salesConsultantId", msg.getSalesConsultantId()
							+ "");
					json_a.add("details", msg.getDetails() + "");
					json_a.add("type", msg.getType() + "");
					json_a.add("poxyId", msg.getPoxyId() + "");
					json_a.add("status", msg.getStatus() + "");
					json_a.add("createtime", msg.getCreatetime() + "");
					json_a.add("imgurl", msg.getImgurl() + "");
					json_a.add("thumbnail", msg.getThumbnail() + "");
					json_a.add("sendtype", msg.getSendtype() + "");
					json_a.add("id", msg.getId() + "");

					json1.add("data", json_a);

					msg.setStatus(1);

					messageService.save(msg);
				}

				JSONObject arr1 = null;
				try {
					arr1 = new JSONObject(json1.toString());
					// System.out.println("arr1:"+arr1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 将查询出来的对象集合转换为json格式

				JSONArray array = arr1.getJSONArray("data");

				// System.out.println("array:"+array);
				// 给请求作出响应
				response.getWriter().write(array.toString());
			} else {
				response.getWriter().write("");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/mobile/findsale")
	public ModelAndView findsale(HttpServletRequest request,
			HttpServletResponse response) {

		String saleid = request.getParameter("saleid");

		try {
			long saleId = 0;
			if (!"".equals(saleid) && saleid != null) {
				saleId = Long.parseLong(saleid);
			}

			SalesConsultant sale = salesConsultantService.findByUid(saleId);
			JsonUtil json1 = new JsonUtil();
			if (sale != null) {
				JsonUtil json_a = new JsonUtil();
				json_a.add("uid", sale.getUid() + "");
				json_a.add("name", sale.getName() + "");
				json_a.add("buildname", sale.getBuildName() + "");
				json_a.add("online", sale.getOnline() + "");
				json_a.add("groupid", sale.getGroupId() + "");
				json_a.add("picurl", sale.getPicUrl());
				json_a.add("id", sale.getId() + "");

				json1.add("data", json_a);

				JSONObject arr1 = null;
				try {
					arr1 = new JSONObject(json1.toString());
					// System.out.println("arr1:"+arr1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 将查询出来的对象集合转换为json格式

				JSONArray array = arr1.getJSONArray("data");

				// System.out.println("array:"+array);
				// 给请求作出响应
				response.getWriter().write(array.toString());
			} else {
				response.getWriter().write("");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/sendMsg",method = RequestMethod.POST )
	public  String get(@RequestBody JsonMessage req_message,HttpServletRequest request, HttpServletResponse response) {

		
		long to = req_message.getTo();
		long createTime = req_message.getCreateTime();
		String message = req_message.getMessage();
	
		long from = req_message.getFrom();
	
		int type = req_message.getType();
	
		  Message msg = new Message();
		try {
			// long toId = 0;
			//long fromId = 0;
			//int typeId = 0;
			long customerId = 0;
			Date date = new Date();
			// long toId = 0;
		
				
				// toId = Long.parseLong(to);
				List<Message> list = messageService.findByPoxyId(to+"");
				if (list != null && list.size() > 0) {
					msg = list.get(0);
					customerId = msg.getCustomerId();
				}

		
				date = new Date(createTime);
				// String sDateTime = sdf.format(dt); //得到精确到秒的表示：08/31/2006
				// 21:08:00
			Message obj = new Message();
			obj.setCustomerId(customerId);
			obj.setDetails(message);
			obj.setImgurl("");
			obj.setPoxyId(to+"");
			obj.setSalesConsultantId(from);
			obj.setStatus(0);
			obj.setThumbnail("");
			obj.setType(type);
			obj.setCreatetime(date);
			obj.setSendtype(2);

			messageService.save(obj);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	@RequestMapping(value = "/mobile/noread")
	public ModelAndView noread(HttpServletRequest request,
			HttpServletResponse response) {

		String customerId = (String) request.getParameter("customerId");
		long customerid = 0;
		if (!"".equals(customerId) && customerId != null) {
			customerid = Long.parseLong(customerId);
		}
		List<Message> list = messageService.findByCustomerIdAndStatus(
				customerid, 0);
		//System.out.println("before remove.............:" + list.size());

		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Message message = list.get(i);

				System.out.println("poxyid:" + message.getPoxyId());
				System.out.println("status:" + message.getStatus());
				Date d = new Date();
				Date md = message.getCreatetime();
				long day = 24L * 60L * 60L * 1000L;
				long time = d.getTime();
				long time1 = md.getTime();
				long da = (time - time1) / day;
				int sendtype = message.getSendtype();

				if (da > 2 || sendtype == 1) {
					list.remove(message);
				}

			}
		}
	//	System.out.println("after remove.............:" + list.size());

		Set<String> set = new HashSet<String>();
		if (list != null && list.size() > 0) {
			for (int k = 0; k < list.size(); k++) {
				set.add(list.get(k).getPoxyId());
			}
		}

		//System.out.println("set size:............." + set.size());

		Iterator<String> it = set.iterator();
		List<Poxy> poxylist = new ArrayList<Poxy>();
		while (it.hasNext()) {
			String poxyno = it.next();
			List<Poxy> poxyl = poxyService.foundByCustomeridAndPoxyno(customerid,
					poxyno);
			Poxy poxy = new Poxy();
			if(poxyl!=null&&poxyl.size()>0){
				poxy = poxyl.get(0);
			}
			poxylist.add(poxy);
		}

		try {
			if (poxylist != null && poxylist.size() > 0) {

				JsonUtil json1 = new JsonUtil();
				for (int i = 0; i < poxylist.size(); i++) {
					Poxy poxy = poxylist.get(i);
					JsonUtil json_a = new JsonUtil();
					json_a.add("id", poxy.getId() + "");
					json_a.add("poxyno", poxy.getPoxyno() + "");
					json_a.add("saleid", poxy.getSaleid() + "");
					json_a.add("groupid", poxy.getGroupid() + "");
					json1.add("data", json_a);
				}

				JSONObject poxyobj = null;
				try {
					poxyobj = new JSONObject(json1.toString());
					// System.out.println("arr1:"+arr1);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				// 将查询出来的对象集合转换为json格式

				JSONArray poxyarray = poxyobj.getJSONArray("data");

				// System.out.println("array:"+array);
				// 给请求作出响应
				response.getWriter().write(poxyarray.toString());
			} else {
				response.getWriter().write("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

}
