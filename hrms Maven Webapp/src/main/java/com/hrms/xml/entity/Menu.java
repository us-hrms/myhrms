package com.hrms.xml.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.hrms.xml.uitl.Dom4jUtil;

@Component
public class Menu implements Serializable {
	
	private String filePath = this.getClass().getClassLoader().getResource("com\\hrms\\xml\\entity\\menu.xml").getPath();//menu.xml文件路径
	private List<ListGroup> listGroups;

	public Menu() {
		this.listGroups = new ArrayList<ListGroup>();
	}

	public Menu(List<ListGroup> listGroups) {
		this.listGroups = listGroups;
	}
	
	/**
	 * 获得不同角色的Menus对象
	 * @param menu
	 * @return
	 */
	public static Map<Integer, Menu> getRoleMenuMap(){
		Map<Integer, Menu> rmMap = new HashMap<Integer, Menu>();
		//循环获得roleMenu
		for (Role role : RolePermissions.getRolePermissions().getRoles()) {
			rmMap.put(role.getId(), getRoleMenu(role));//获得后加入到Map;
		}
		return rmMap;
	}
	
	/**
	 * 获得无角色限制的menu
	 * @return
	 */
	public static Menu getMenu(){
		return Dom4jUtil.readMenu();
	}
	/**
	 * 获得角色限制的对象
	 * @return
	 */
	public static Menu getRoleMenu(Role role){
		return getRoleMenu(null,role);
	}
	public static Menu getRoleMenu(Integer roleId){
		return getRoleMenu(null,roleId);
	}
	public static Menu getRoleMenu(Menu menu,Role role){
		if(menu == null)
			menu = Dom4jUtil.readMenu();
		//判断是否有不可操作id
		if(role != null || role.getDisabledIds().length != 0)
			//循环判断所有listgroup
			for (ListGroup lg : menu.getListGroups()) {
				//循环判断所有item
				for (Item item : lg.getItems()) {
					//判断id是否包含在不可操作id列表中
					if(container(role.getDisabledIds(),item.getId()))
						item.setDisabled(true);//设置为不可操作
				}
			}
		return menu;
	}
	public static Menu getRoleMenu(Menu menu,Integer roleId){
		if(menu == null)
			menu = Dom4jUtil.readMenu();
		Role role = null;
		if(roleId != null)
			role = Role.getRole(roleId);
		//判断是否有不可操作id
		if(role != null || role.getDisabledIds().length != 0)
			//循环判断所有listgroup
			for (ListGroup lg : menu.getListGroups()) {
				//循环判断所有item
				for (Item item : lg.getItems()) {
					//判断id是否包含在不可操作id列表中
					if(container(role.getDisabledIds(),item.getId()))
						item.setDisabled(true);//设置为不可操作
				}
			}
		return menu;
	}
	/**
	 * 判断是否包含在数组中
	 * @param array
	 * @param targin
	 * @return
	 */
	private static boolean container(String[] array,String targin){
		for (String string : array) {
			if(string.equals(targin))
				return true;
		}
		return false;
	}
	
	
	/**
	 * 添加到listGroups集合
	 * @param listGroup
	 * @return
	 */
	public boolean addToListGroups(ListGroup listGroup){
		return listGroups.add(listGroup);
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public List<ListGroup> getListGroups() {
		return listGroups;
	}

	public void setListGroups(List<ListGroup> listGroups) {
		this.listGroups = listGroups;
	}

	@Override
	public String toString() {
		return "Menu [filePath=" + filePath + ", listGroups=" + listGroups.size()
				+ "]";
	}
	
	/**
	 * 设置选中的菜单
	 * @param id
	 * @return
	 */
	public boolean setSelected(String id){
		List<Item> items;
		boolean result,hasId = false;
		//循环对比
		for (ListGroup listGroup : listGroups) {
			//如果功能是禁用的 就不进行对比
			if(listGroup.isDisabled())
				continue;
			hasId = false;
			items = listGroup.getItems();
			for (Item item : items) {
				//如果功能是禁用的 就不进行对比
				if(item.isDisabled())
					continue;
				result = false;
				//如果相等 就设置结果为true;
				if(item.getId().equals(id)){
					result = true;
					hasId = true;
				}
				item.setSelected(result);
			}
			listGroup.setSelected(hasId);//设置到列表主组中
		}
		return hasId;
	}

	/**
	 * 克隆
	 */
	/*public Menu clone(){
		List<ListGroup> lgs = new ArrayList<ListGroup>();
		for (ListGroup listGroup : this.listGroups) {
			lgs.add(listGroup.clone());
		}
		return new Menu(lgs);
	}*/

	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		List<ListGroup> lgs = new ArrayList<ListGroup>();
		for (ListGroup listGroup : this.listGroups) {
			lgs.add((ListGroup)listGroup.clone());
		}
		return new Menu(lgs);
	}
	
	
	
}