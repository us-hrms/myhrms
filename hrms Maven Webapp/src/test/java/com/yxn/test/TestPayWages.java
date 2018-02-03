package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.PayWages;
import com.hrms.service.PayWagesService;

public class TestPayWages {
    
	static PayWagesService ps;
//	@BeforeClass
 	 public static void inital(){
 		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 		ps = context.getBean(PayWagesService.class);
     }
//    @Test
	public void getDepartments(){
		List<PayWages> list = ps.getPayWagess();
		for (PayWages payWages : list) {
			System.out.println(payWages.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
