package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Attendance;
import com.hrms.entity.CultivateRecord;
import com.hrms.service.CultivateRecordService;

public class TestCultivateRecord {

	static CultivateRecordService crs;
	
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		crs = context.getBean(CultivateRecordService.class);
	}
	
//	@Test
	public void getCultivateRecords(){
		List<CultivateRecord> list = crs.getCultivateRecords();
		for (CultivateRecord cultivateRecord : list) {
			System.out.println(cultivateRecord.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
