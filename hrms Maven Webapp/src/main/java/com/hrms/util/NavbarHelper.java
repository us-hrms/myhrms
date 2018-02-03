package com.hrms.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hrms.entity.Staff;
import com.hrms.xml.entity.Nav;
import com.hrms.xml.entity.Navbar;

public class NavbarHelper {

	/**
	 * navbar
	 * ����navid�ı�Ϊ��ǰѡ�е�nav
	 * @param session
	 * @param navId
	 */
	public static void changeNavbar(HttpSession session,Long navId){
		List<Nav> currNavbar = (List<Nav>) session.getAttribute("currNavbar");
		if(currNavbar == null){
			//��õ�ǰԱ�� ǰ����Ա������ ���ǲ����ǲ����� ��Ϊ��������
			Staff currStaff = (Staff) session.getAttribute("currStaff");
			setStaffOfNavbar(session,currStaff.getId());
			currNavbar = (List<Nav>) session.getAttribute("currNavbar");
		}
		//����ѡ����
		Nav.setSelected(navId, currNavbar);
		//�Ż�session��
		session.setAttribute("currNavbar", currNavbar);
	}
	
	/**
	 * ����staffid�����Ӧ��navbar�˵�
	 * ������session
	 * @param session
	 * @param staffId
	 */
	public static void setStaffOfNavbar(HttpSession session,Long staffId){
		//������е�navbar
		Navbar navbar = (Navbar)session.getServletContext().getAttribute("navbar");
		//���뵱ǰstaff��Ӧ�ĵ����˵���
		session.setAttribute("currNavbar", navbar.getCommonAndCustomizeNavsClone(staffId));
	}
}
