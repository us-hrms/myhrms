package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Cultivate;
import com.hrms.service.CultivateService;

public class TestCultivate {

	static CultivateService cs;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		cs = context.getBean(CultivateService.class);
	}
	
//	@Test
	public void getCertificates(){
		List<Cultivate> list = cs.getCultivates();
		for (Cultivate cultivate : list) {
			System.out.println(cultivate.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
