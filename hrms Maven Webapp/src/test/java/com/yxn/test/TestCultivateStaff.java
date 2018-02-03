package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.CultivateStaff;
import com.hrms.service.CultivateStaffService;

public class TestCultivateStaff {
	
     static CultivateStaffService css;
//     @BeforeClass
 	 public static void inital(){
 		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
 		css = context.getBean(CultivateStaffService.class);
 	}
 	
// 	@Test
 	public void getCultivateStaffs(){
 		List<CultivateStaff> list = css.getCultivateStaffs();
 		for (CultivateStaff cultivateStaff : list) {
 			System.out.println(cultivateStaff.getId());
 		}
 		Assert.assertEquals(true, list.size()>0);
 	}
}
