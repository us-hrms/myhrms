package com.yxn.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.entity.PersonnelFiles;
import com.hrms.service.PersonnelFilesService;

public class TestPersonnelFiles {
	
     static PersonnelFilesService pfs;
//     @BeforeClass
   	 public static void inital(){
   		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
   		pfs = context.getBean(PersonnelFilesService.class);
       }
//      @Test
  	public void getDepartments(){
  		List<PersonnelFiles> list = pfs.getPersonnelFiles();
  		for (PersonnelFiles personnelFiles : list) {
  			System.out.println(personnelFiles.getId());
  		}
  		Assert.assertEquals(true, list.size()>0);
  	}
}
