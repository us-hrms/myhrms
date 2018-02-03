package com.hfp.test;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;
import com.opensymphony.xwork2.interceptor.annotations.Before;

public class AttendanceServiceTest {
	
	static AttendanceService as;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		as = context.getBean(AttendanceService.class);
	}
//	@Test
	public void get(){
		List<Attendance> list = as.getAttendances();
		for (Attendance attendance : list) {
			System.out.println(attendance.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
