package com.hfp.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.hrms.xml.entity.Company;
import com.hrms.xml.entity.Item;
import com.hrms.xml.entity.ListGroup;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Navbar;
import com.hrms.xml.entity.Role;
import com.hrms.xml.entity.RolePermissions;
import com.hrms.xml.uitl.Dom4jUtil;

public class Dom4UtilTest {

	public void getCompany(){
		Company com = Dom4jUtil.readCompany();
		System.out.println(com);
	}
	
	public void getCompany2(){
		Company com = Dom4jUtil.readCompany();
		com.setEmail("test");
		System.out.println(com);
		System.out.println(Dom4jUtil.readCompany());
	}

	public void writeCompany(){
		Company com = Dom4jUtil.readCompany();
		System.out.println(com);
		com.setEmail("hesmailbox@163.com");
		System.out.println(com);
		boolean result = Dom4jUtil.writeCompany(com);
		com = Dom4jUtil.readCompany();
		System.out.println(com);
		Assert.assertEquals(true, result);
	}
	

	public void getMenu(){
		Menu menu = Dom4jUtil.readMenu();
		List<ListGroup> lglist = menu.getListGroups();
		List<Item> items;
		for (ListGroup listGroup : lglist) {
			System.out.println(listGroup);
			items = listGroup.getItems();
			for (Item item : items) {
				System.out.println(item);
			}
		}
	}
	
	
	public void getRolePermissions(){
		RolePermissions rp = Dom4jUtil.readRolePermissions();
		for (Role role : rp.getRoles()) {
			System.out.println(role);
		}
	}

//	@Test
	public void getNavbar(){
		Navbar navbar= Dom4jUtil.readNavbar();
		System.out.println(navbar);
	}
	
	
}
