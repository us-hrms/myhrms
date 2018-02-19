package com.hfp.test;

import java.lang.reflect.Field;

import org.junit.Test;

import com.hrms.entity.Department;

public class FieldTest {
	
	@Test
	public void field() throws NoSuchFieldException, SecurityException{
		Field field = Department.class.getDeclaredField("name");
		Class clazz = new Department().getClass();
		
		System.out.println(clazz.getPackage().equals(Package.getPackage("com.hrms.entity")));
	}
}
