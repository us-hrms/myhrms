package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Certificate;
import com.hrms.service.CertificateService;

public class TestCertificate {
	
	static CertificateService cs;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cs = context.getBean(CertificateService.class);
	}
	
//	@Test
	public void getCertificates(){
		List<Certificate> list = cs.getCertificates();
		for (Certificate certificate : list) {
			System.out.println(certificate.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
