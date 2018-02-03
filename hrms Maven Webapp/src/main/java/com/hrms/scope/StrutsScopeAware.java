package com.hrms.scope;

import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

public class StrutsScopeAware implements SessionAware,ApplicationAware,RequestAware {

   //解耦的方式获得 request session 和 applicaition
	protected Map<String, Object> request;  
	protected Map<String, Object> session;  
	protected Map<String, Object> application;
	@Override
	public void setRequest(Map<String, Object> request) {
		// TODO Auto-generated method stub
		this.request = request;
	}
	@Override
	public void setApplication(Map<String, Object> application) {
		// TODO Auto-generated method stub
		this.application = application;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}  
	
	
}
