package com.hyq.test;


import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Position;
import com.hrms.service.PositionService;

public class PositionServiceTest {

	static PositionService ps;
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ps = context.getBean(PositionService.class);
	}
//	@Test
	public void testGetPositions() {
		List<Position> list = ps.getPositions();
		for (Position position : list) {
			System.out.println(position.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}

}
