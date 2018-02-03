package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.WagesStandard;
import com.hrms.service.WagesStandardService;

public class WagesStandardServiceTest {

	static WagesStandardService wss;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		wss = context.getBean(WagesStandardService.class);
	}
//	@Test
	public void testGetWagesStandards() {
		List<WagesStandard> list = wss.getWagesStandards();
		for (WagesStandard sagesStandard : list) {
			System.out.println(sagesStandard.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
