package com.hrms.util;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.hrms.entity.Staff;
import com.hrms.xml.entity.Menu;

public class MenuHelper {
	
	/**
	 * 根据目标itemid
	 * 来改变当前选中的item
	 * @param session
	 * @param itemId
	 */
	public static void changeMenu(HttpSession session,String itemId){
		if(itemId == null)
			return;
		Menu currMenu = (Menu) session.getAttribute("currMenu");//拿到当前menu
		//如果当前menu为空 重新获得
		if(currMenu == null){
			//获得当前员工 前提是员工存在 但是不考虑不存在 因为有拦截器
			Staff currStaff = (Staff) session.getAttribute("currStaff");
			setStaffTypeOfMenu(session,currStaff.getDataDictionaryByTypeId().getId());//设置到session
			currMenu = (Menu) session.getAttribute("currMenu");
		}
		currMenu.setSelected(itemId);
		//添加回session
		session.setAttribute("currMenu", currMenu);
	}
	
	/**
	 * 根据staff 的typeid
	 * 获得staff权限相对应的菜单操作项
	 * @param session
	 * @param staffId
	 */
	public static void setStaffTypeOfMenu(HttpSession session,Long typeId){
	    //拿出所有的角色菜单
		Map<Integer, Menu> menu = (Map<Integer, Menu>)session.getServletContext().getAttribute("roleMenuMap");
	    //放入当前staff对应权限的的菜单栏
	    session.setAttribute("currMenu", menu.get(typeId.intValue()));
	}
	
	
}
