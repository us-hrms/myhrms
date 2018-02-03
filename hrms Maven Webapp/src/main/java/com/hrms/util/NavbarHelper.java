package com.hrms.util;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.hrms.entity.Staff;
import com.hrms.xml.entity.Nav;
import com.hrms.xml.entity.Navbar;

public class NavbarHelper {

	/**
	 * navbar
	 * 根据navid改变为当前选中的nav
	 * @param session
	 * @param navId
	 */
	public static void changeNavbar(HttpSession session,Long navId){
		List<Nav> currNavbar = (List<Nav>) session.getAttribute("currNavbar");
		if(currNavbar == null){
			//获得当前员工 前提是员工存在 但是不考虑不存在 因为有拦截器
			Staff currStaff = (Staff) session.getAttribute("currStaff");
			setStaffOfNavbar(session,currStaff.getId());
			currNavbar = (List<Nav>) session.getAttribute("currNavbar");
		}
		//设置选中项
		Nav.setSelected(navId, currNavbar);
		//放回session中
		session.setAttribute("currNavbar", currNavbar);
	}
	
	/**
	 * 根据staffid获得相应的navbar菜单
	 * 并放入session
	 * @param session
	 * @param staffId
	 */
	public static void setStaffOfNavbar(HttpSession session,Long staffId){
		//获得所有的navbar
		Navbar navbar = (Navbar)session.getServletContext().getAttribute("navbar");
		//放入当前staff对应的导航菜单栏
		session.setAttribute("currNavbar", navbar.getCommonAndCustomizeNavsClone(staffId));
	}
}
