package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.StaffMobilization;
import com.hrms.service.StaffMobilizationService;

public class StaffMobilizationServiceTest {

	static StaffMobilizationService sms;
//	/@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		sms = context.getBean(StaffMobilizationService.class);
	}
//	@Test
	public void testGetStaffMobilizations() {
		List<StaffMobilization> list = sms.getStaffMobilizations();
		for (StaffMobilization staffMobilization : list) {
			System.out.println(staffMobilization.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
