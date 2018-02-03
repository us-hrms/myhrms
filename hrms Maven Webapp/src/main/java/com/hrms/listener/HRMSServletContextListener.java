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
		//��ȡservletContext
		ServletContext context = scEvent.getServletContext();
		//��ȡspring�������bean
		ApplicationInfo appInfo =  WebApplicationContextUtils
				.getWebApplicationContext(context).getBean(ApplicationInfo.class);
		//��ʼ����˾��Ϣ��context
		context.setAttribute("company", appInfo.getCompany());
		//��ʼ����ɫ�˵���context
		context.setAttribute("roleMenuMap", appInfo.getMenuMap());
		//��ʼ���û������˵���context
		context.setAttribute("navbar", appInfo.getNavbar());
		//��ʼ�������������˵���context
		context.setAttribute("commonNavbar", appInfo.getNavbar().getCommon());
	}

}
