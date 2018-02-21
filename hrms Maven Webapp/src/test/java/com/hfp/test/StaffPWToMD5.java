package com.hfp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Staff;
import com.hrms.service.AttendanceService;
import com.hrms.service.StaffService;
import com.hrms.util.MD5Util;

public class StaffPWToMD5 {
	static AttendanceService as;

	static StaffService staffService;
	
	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		staffService = context.getBean(StaffService.class);
	}
	
	@Test
	public void toMd5(){
		List<Staff> list = staffService.getStaffs();
		boolean result =true;
		for (Staff staff : list) {
			if(staff.getPassword().length() != 32){
				staff.setPassword(MD5Util.getMD5(staff.getPassword()));
				result = result&&staffService.updateStaff(staff);
			}
		}
		Assert.assertEquals(true, result);
	}
}
