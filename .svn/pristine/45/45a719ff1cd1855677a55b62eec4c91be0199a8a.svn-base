package com.papa.wx.web.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginAuthenticationFilter extends FormAuthenticationFilter {
    private static final Logger LOG = LoggerFactory.getLogger(LoginAuthenticationFilter.class);
    public static final String DEFAULT_PATCHCA_PARAM = "verifyCode";
    private String patchcaParam = DEFAULT_PATCHCA_PARAM;
    
    
    public String getPatchcaParam() {
        return patchcaParam;
    }
    
    protected String getPatchca(ServletRequest request) {
        return WebUtils.getCleanParam(request, getPatchcaParam());
    }
    
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String username = getUsername(request);
        String password = getPassword(request);
        String patchca  = getPatchca(request);
        boolean rememberMe = isRememberMe(request);
        String host = getHost(request);

        return new PatchcaUsernamePasswordToken(
                username, password.toCharArray(), rememberMe, host, patchca);
    }
    
    @Override
    protected boolean isLoginSubmission(ServletRequest request, ServletResponse response) {
        return super.isLoginSubmission(request, response) && pathsMatch(getLoginUrl(), request);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
            ServletRequest request, ServletResponse response) {
        LOG.warn("login failed, with token {}", token);

        //这里处理登录失败的情景，返回Json
        if (!"XMLHttpRequest".equalsIgnoreCase(((HttpServletRequest) request)
				.getHeader("X-Requested-With"))) {
        	// 不是ajax请求
        	return super.onLoginFailure(token, e, request, response);
		}else{
			//aJax请求
			try {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				String message = e.getClass().getSimpleName();
				if ("ExpiredCredentialsException".equals(message)) {
					out.println("{\"code\":0,\"reason\":2,\"redirectUrl\":\"\"}");
				} else if ("UnknownAccountException".equals(message)) {
					out.println("{\"code\":0,\"reason\":0,\"redirectUrl\":\"\"}");
				} else {
					out.println("{\"code\":0,\"reason\":1,\"redirectUrl\":\"\"}");
				}
				out.flush();
				out.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return false;
		}
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject,
            ServletRequest request, ServletResponse response) throws Exception {
        LOG.info("login success, with token {}", token);
                
			return true;
		}

    @Override
    protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
        WebUtils.issueRedirect(request, response, decideSuccessUrl(request), null, false);
    }

    private String decideSuccessUrl(ServletRequest request) {
        String context = WebUtils.getContextPath(WebUtils.toHttp(request));

        SavedRequest savedRequest = WebUtils.getAndClearSavedRequest(request);
        if (savedRequest != null && savedRequest.getMethod().equalsIgnoreCase(AccessControlFilter.GET_METHOD)) {
            String recentUrl = savedRequest.getRequestUrl();
            if (!isRootUrl(context, recentUrl)) {
                return recentUrl;
            }
        }

        return context + getSuccessUrl();
    }

    private boolean isRootUrl(String context, String url) {
        return context.equalsIgnoreCase(url) || (context + "/").equalsIgnoreCase(url);
    }
}
