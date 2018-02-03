package com.hrms.listener;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.hrms.xml.entity.Menu;

public class HRMSHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		//假设一个用户登录
		HttpSession session = sessionEvent.getSession();
		Map<Integer,Menu> map = (Map<Integer, Menu>) session.getServletContext().getAttribute("roleMenuMap");
		session.setAttribute("menu6", map.get(6));
		session.setAttribute("menu7", map.get(7));
		session.setAttribute("menu9", map.get(9));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		// TODO Auto-generated method stub
		
	}

}
