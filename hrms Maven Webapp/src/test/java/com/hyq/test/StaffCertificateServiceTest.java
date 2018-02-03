package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.StaffCertificate;
import com.hrms.service.StaffCertificateService;

public class StaffCertificateServiceTest {

	static StaffCertificateService scs;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		scs = context.getBean(StaffCertificateService.class);
	}
//	@Test
	public void testGetStaffCertificates() {
		List<StaffCertificate> list = scs.getStaffCertificates();
		for (StaffCertificate staffCertificate : list) {
			System.out.println(staffCertificate.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
