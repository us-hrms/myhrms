package com.hrms.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hrms.info.ApplicationInfo;

@Component
public class HRMSServletContextListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent scEvent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent scEvent) {
		// TODO Auto-generated method stub
		//获取servletContext
		ServletContext context = scEvent.getServletContext();
		//获取spring容器里的bean
		ApplicationInfo appInfo =  WebApplicationContextUtils
				.getWebApplicationContext(context).getBean(ApplicationInfo.class);
		//初始化公司信息到context
		context.setAttribute("company", appInfo.getCompany());
		//初始化角色菜单到context
		context.setAttribute("roleMenuMap", appInfo.getMenuMap());
		//初始化用户导航菜单到context
		context.setAttribute("navbar", appInfo.getNavbar());
		//初始化公共导航栏菜单到context
		context.setAttribute("commonNavbar", appInfo.getNavbar().getCommon());
	}

}
