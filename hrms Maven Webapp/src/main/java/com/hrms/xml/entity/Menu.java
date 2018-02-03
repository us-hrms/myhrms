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
	
	private String filePath = this.getClass().getClassLoader().getResource("com\\hrms\\xml\\entity\\menu.xml").getPath();//menu.xml�ļ�·��
	private List<ListGroup> listGroups;

	public Menu() {
		this.listGroups = new ArrayList<ListGroup>();
	}

	public Menu(List<ListGroup> listGroups) {
		this.listGroups = listGroups;
	}
	
	/**
	 * ��ò�ͬ��ɫ��Menus����
	 * @param menu
	 * @return
	 */
	public static Map<Integer, Menu> getRoleMenuMap(){
		Map<Integer, Menu> rmMap = new HashMap<Integer, Menu>();
		//ѭ�����roleMenu
		for (Role role : RolePermissions.getRolePermissions().getRoles()) {
			rmMap.put(role.getId(), getRoleMenu(role));//��ú���뵽Map;
		}
		return rmMap;
	}
	
	/**
	 * ����޽�ɫ���Ƶ�menu
	 * @return
	 */
	public static Menu getMenu(){
		return Dom4jUtil.readMenu();
	}
	/**
	 * ��ý�ɫ���ƵĶ���
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
		//�ж��Ƿ��в��ɲ���id
		if(role != null || role.getDisabledIds().length != 0)
			//ѭ���ж�����listgroup
			for (ListGroup lg : menu.getListGroups()) {
				//ѭ���ж�����item
				for (Item item : lg.getItems()) {
					//�ж�id�Ƿ�����ڲ��ɲ���id�б���
					if(container(role.getDisabledIds(),item.getId()))
						item.setDisabled(true);//����Ϊ���ɲ���
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
		//�ж��Ƿ��в��ɲ���id
		if(role != null || role.getDisabledIds().length != 0)
			//ѭ���ж�����listgroup
			for (ListGroup lg : menu.getListGroups()) {
				//ѭ���ж�����item
				for (Item item : lg.getItems()) {
					//�ж�id�Ƿ�����ڲ��ɲ���id�б���
					if(container(role.getDisabledIds(),item.getId()))
						item.setDisabled(true);//����Ϊ���ɲ���
				}
			}
		return menu;
	}
	/**
	 * �ж��Ƿ������������
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
	 * ��ӵ�listGroups����
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
	 * ����ѡ�еĲ˵�
	 * @param id
	 * @return
	 */
	public boolean setSelected(String id){
		List<Item> items;
		boolean result,hasId = false;
		//ѭ���Ա�
		for (ListGroup listGroup : listGroups) {
			//��������ǽ��õ� �Ͳ����жԱ�
			if(listGroup.isDisabled())
				continue;
			hasId = false;
			items = listGroup.getItems();
			for (Item item : items) {
				//��������ǽ��õ� �Ͳ����жԱ�
				if(item.isDisabled())
					continue;
				result = false;
				//������ �����ý��Ϊtrue;
				if(item.getId().equals(id)){
					result = true;
					hasId = true;
				}
				item.setSelected(result);
			}
			listGroup.setSelected(hasId);//���õ��б�������
		}
		return hasId;
	}

	/**
	 * ��¡
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