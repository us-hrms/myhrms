package com.hfp.test;

import java.util.List;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrms.info.ApplicationInfo;
import com.hrms.xml.entity.Item;
import com.hrms.xml.entity.ListGroup;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Role;
import com.hrms.xml.entity.RolePermissions;
import com.hrms.xml.uitl.Dom4jUtil;


public class ApplicationInfoTest {

	static ApplicationInfo appInfo;
	
//	@BeforeClass
	public static void inital(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		appInfo = context.getBean(ApplicationInfo.class);
	}
	
//	@Test
	public void info(){
		RolePermissions rp = Dom4jUtil.readRolePermissions();
		Map<Integer, Menu> rmMap = appInfo.getMenuMap();
		for (Role role : rp.getRoles()) {
			System.out.println(role);
			System.out.println("==========roleMenu=============");
			List<ListGroup> lgs = rmMap.get(role.getId()).getListGroups();
			for (ListGroup listGroup : lgs) {
				List<Item> items = listGroup.getItems();
				for (Item item : items) {
					if(item.isDisabled())
						System.out.println("id:"+item.getId()+"   disabled:" + item.isDisabled());
				}
			}
		}
		System.out.println("=============eles===========");
		for (ListGroup lg : Menu.getMenu().getListGroups()) {
			List<Item> items = lg.getItems();
			for (Item item : items) {
				if(item.isDisabled())
					System.out.println("id:"+item.getId()+"   disabled:" + item.isDisabled());
			}
		}
		System.out.println(appInfo.getCompany());
	}
}
