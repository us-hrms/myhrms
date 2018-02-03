package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.StaffContract;
import com.hrms.service.StaffContractService;

public class StaffContractServiceTest {

	static StaffContractService ss;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ss = context.getBean(StaffContractService.class);
	}
//	@Test
	public void testGetStaffContractServices() {
		List<StaffContract> list = ss.getStaffContracts();
		for (StaffContract staffContract : list) {
			System.out.println(staffContract.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
