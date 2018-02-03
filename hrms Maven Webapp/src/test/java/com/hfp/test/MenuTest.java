package com.hfp.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.hrms.xml.entity.Item;
import com.hrms.xml.entity.ListGroup;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Role;
import com.hrms.xml.entity.RolePermissions;
import com.hrms.xml.uitl.Dom4jUtil;

public class MenuTest {

	public void menu(){
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
		menu.setSelected("20");
		System.out.println("==========¸ü¸Äºó==============");
		for (ListGroup listGroup : lglist) {
			System.out.println(listGroup);
			items = listGroup.getItems();
			for (Item item : items) {
				System.out.println(item);
			}
		}
	}
	
//	@Test
	public void getRoleMenu(){
		RolePermissions rp = Dom4jUtil.readRolePermissions();
		Map<Integer, Menu> rmMap = Menu.getRoleMenuMap();
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
		
	}

	public void getMenu(){
		Menu menu = Menu.getMenu();
		
		for (ListGroup lg : menu.getListGroups()) {
			List<Item> items = lg.getItems();
			for (Item item : items) {
				if(item.getId().equals("12")){
					item.setDisabled(true);
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
	}
}
