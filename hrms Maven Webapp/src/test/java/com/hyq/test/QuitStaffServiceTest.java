package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.QuitStaff;
import com.hrms.service.QuitStaffService;

public class QuitStaffServiceTest {

	static QuitStaffService qss;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		qss = context.getBean(QuitStaffService.class);
	}
//	@Test
	public void testGetQuitStaffs() {
		List<QuitStaff> list = qss.getQuitStaffs();
		for (QuitStaff quitStaff : list) {
			System.out.println(quitStaff.getSid());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
