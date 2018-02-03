package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Holiday;
import com.hrms.service.HolidayService;

public class TestHoliday {
	
     static HolidayService hs;
//     @BeforeClass
  	 public static void inital(){
  		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  		hs = context.getBean(HolidayService.class);
      }
//     @Test
 	public void getDepartments(){
 		List<Holiday> list = hs.getHolidays();
 		for (Holiday holiday : list) {
 			System.out.println(holiday.getId());
 		}
 		Assert.assertEquals(true, list.size()>0);
 	}
 
}
