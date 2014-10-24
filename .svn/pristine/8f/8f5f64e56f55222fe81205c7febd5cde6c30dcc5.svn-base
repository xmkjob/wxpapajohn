package com.papa.wx.web.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class PatchcaUsernamePasswordToken extends UsernamePasswordToken {

	private static final long serialVersionUID = 1L;
	private String verifyCode;
    
    public PatchcaUsernamePasswordToken(String username, char[] password,
                                      boolean rememberMe, String host, String verifyCode) {
      super(username,password,rememberMe,host);
      this.verifyCode = verifyCode;
    } 

    public String getVerifyCode() {
       return verifyCode;
    }

   public void setVerifyCode(String verifyCode) {
      this.verifyCode = verifyCode;
   }	
}
