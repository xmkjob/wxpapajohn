package com.papa.wx.web.result;

public class JsonResult {
	
	private int code;
	private String msg;
	private Object data;
	
	public int getCode(){
		return this.code;
	}
	
	public void setCode(int code){
		this.code = code;
	}
	
	public String getMsg(){
		return this.msg;
	}
	
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public Object getData(){
		return this.data;
	}
	
	public void setData(Object data){
		this.data = data;
	}

}
