package com.hrms.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hrms.entity.Staff;
import com.hrms.xml.entity.Menu;

public class MenuHelper {
	
	/**
	 * ����Ŀ��itemid
	 * ���ı䵱ǰѡ�е�item
	 * @param session
	 * @param itemId
	 */
	public static void changeMenu(HttpSession session,String itemId){
		Menu currMenu = (Menu) session.getAttribute("currMenu");//�õ���ǰmenu
		//�����ǰmenuΪ�� ���»��
		if(currMenu == null){
			//��õ�ǰԱ�� ǰ����Ա������ ���ǲ����ǲ����� ��Ϊ��������
			Staff currStaff = (Staff) session.getAttribute("currStaff");
			setStaffTypeOfMenu(session,currStaff.getDataDictionaryByTypeId().getId());//���õ�session
			currMenu = (Menu) session.getAttribute("currMenu");
		}
		currMenu.setSelected(itemId);
		//��ӻ�session
		session.setAttribute("currMenu", currMenu);
	}
	
	/**
	 * ����staff ��typeid
	 * ���staffȨ�����Ӧ�Ĳ˵�������
	 * @param session
	 * @param staffId
	 */
	public static void setStaffTypeOfMenu(HttpSession session,Long typeId){
	    //�ó����еĽ�ɫ�˵�
		Map<Integer, Menu> menu = (Map<Integer, Menu>)session.getServletContext().getAttribute("roleMenuMap");
	    //���뵱ǰstaff��ӦȨ�޵ĵĲ˵���
	    session.setAttribute("currMenu", menu.get(typeId.intValue()));
	}
	
	
}
