package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.Department;
import com.hrms.service.DepartmentService;

public class TestDepartment {
	
    static DepartmentService ds;
//    @BeforeClass
	 public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ds = context.getBean(DepartmentService.class);
	}
	
//	@Test
	public void getDepartments(){
		List<Department> list = ds.getDepartments();
		for (Department department : list) {
			System.out.println(department.getId());
		}
		Assert.assertEquals(true, list.size()>0);
	}
}
