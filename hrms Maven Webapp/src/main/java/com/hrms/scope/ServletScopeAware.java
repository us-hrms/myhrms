package com.hrms.scope;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;

public class ServletScopeAware implements ServletRequestAware,ServletContextAware,ServletResponseAware {
	
	//非解耦的方式获得 request session he  application
	protected HttpServletRequest request;
	protected ServletContext application;
	protected HttpSession session;
	protected HttpServletResponse response;

	@Override
	public void setServletContext(ServletContext context) {
		// TODO Auto-generated method stub
		this.application = context;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.session = request.getSession();
		this.request = request;
	}

	@Override
	public void setServletResponse(HttpServletResponse response) {
		// TODO Auto-generated method stub
		this.response = response;
	}

}
