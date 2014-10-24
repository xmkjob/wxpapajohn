package com.papa.wx.web.util;

import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;



public class HttpUtil {

 
	public static void sendPost(String url,String param){
		
		URL u;
		PrintWriter out = null;
		try{
			u = new URL(url);
			HttpURLConnection URLconnection = (HttpURLConnection) u
					.openConnection();
			URLconnection.setRequestMethod("POST");
			// 设置通用的请求属性
			URLconnection.setRequestProperty("accept", "*/*");
			URLconnection.setRequestProperty("connection", "Keep-Alive");
			URLconnection.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)");
			// 发送POST请求必须设置如下两行
			URLconnection.setDoOutput(true);
			URLconnection.setDoInput(true);

			// 获取URLConnection对象对应的输出流
			out = new PrintWriter(URLconnection.getOutputStream());
			// 发送请求参数
			out.print(param);
			// flush输出流的缓冲
			out.flush();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	

	public static void sendGet(String url){
		
		URL u;
		try{
			u = new URL(url);
			u.openConnection();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	
}
