package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.PositionAdjustment;
import com.hrms.service.PositionAdjustmentService;

public class TestPositionAdjustment {
       
	static PositionAdjustmentService pas;
//	@BeforeClass
  	public static void inital(){
  		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
  		pas = context.getBean(PositionAdjustmentService.class);
    }
//    @Test
 	public void getDepartments(){
 		List<PositionAdjustment> list = pas.getPositionAdjustments();
 		for (PositionAdjustment positionAdjustment : list) {
 			System.out.println(positionAdjustment.getId());
 		}
 		Assert.assertEquals(true, list.size()>0);
 	}
}
