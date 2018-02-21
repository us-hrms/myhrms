package com.hrms.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hrms.entity.DataDictionary;
import com.hrms.entity.Department;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.StaffService;
import com.hrms.util.MenuHelper;
import com.hrms.util.NavbarHelper;
import com.hrms.util.PrintWriteUtil;
import com.hrms.xml.entity.Menu;
import com.hrms.xml.entity.Nav;
import com.hrms.xml.entity.Navbar;

@Controller
@Scope("prototype")
public class StaffAction extends ServletScopeAware {

    @Autowired
    private StaffService staffService;
    private Staff staff;
    private String toJsp;
    private String toAction;
    private String itemId;
    private Long navId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<Staff> staffList;
    
    /**
     * 去登录页面
     * @return
     */
    public String toLogin(){
//    	List<Nav> currNav = (List<Nav>) session.getAttribute("currNavbar");
//    	if(currNav == null)
//    		currNav = (List<Nav>) application.getAttribute("commonNavbar");
//		Nav.setSelected(0l, currNav);
		NavbarHelper.changeNavbar(session, 0l);
	    toJsp = "jsp/login";
	    return "toLoginSuccess";
    }
   
    /**
     * 登录
     * @return
     */
    public String loginAjax(){
	    staff = staffService.login(staff);
	    if(staff != null){
	    	/*
	     	Long id = staff.getDataDictionaryByTypeId().getId();
		    //从application拿出参数
		    //拿出所有的角色菜单
		    Map<Integer, Menu> menu = (Map<Integer, Menu>)application.getAttribute("roleMenuMap");
		    Navbar navbar = (Navbar)application.getAttribute("navbar");
		    //放入当前staff对应权限的的菜单栏
		    session.setAttribute("currMenu", menu.get(id.intValue()));
		    //放入当前staff对应的导航菜单栏
		    session.setAttribute("currNavbar", navbar.getCommonAndCustomizeNavsClone(id));
	    	}
	    	*/
		    session.setAttribute("currStaff", staff);
		    //设置导航栏项
		    NavbarHelper.setStaffOfNavbar(session, staff.getId());
		    //设置菜单栏项
		    MenuHelper.setStaffTypeOfMenu(session, staff.getDataDictionaryByTypeId().getId());
	    }
   	    PrintWriteUtil.write(response, staff!=null?"true":"false");
	    return null;
    }
    
    public String newStaffManager(){

		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/newStaffManager";
    	return "tojsp";
    }
    
    public String loginOut(){
    	//销毁session
    	session.invalidate();
    	this.toAction = "home";
    	return "toAction";
    }
    
    public String staffBaseInfo(){
    	if(page == null)
    		page = new Page();
    	this.staffList = staffService.getStaffs(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/staffBaseInfo";
    	return "tojsp";
    }
    
    public String findStaffBaseInfo(){
    	if(page == null)
    		page = new Page();
    	this.staffList = staffService.getStaffs(this.staff,page);
    	this.toJsp = "jsp/staffInfoManager/staffBaseInfo";
    	return "tojsp";
    }
    
    public String getDeptStaffByAjax(){
    	Long [] arr = {6l,7l,8l,10l};
    	int i = 0;
    	while (i<arr.length) {
    		if(staffList == null)
    			staffList = new ArrayList<Staff>();
    		staff.setDataDictionaryByTypeId(new DataDictionary(arr[i]));
    		List<Staff> results = staffService.getStaffsByHql(staff);
        	staffList.addAll(staffService.getStaffsByHql(staff));
        	i++;
		}
		PrintWriteUtil.write(response,staffList.size()>0?JSONObject.toJSONString(staffList):"暂无");
    	return null;
    }

	public List<Staff> getStaffList() {
		return staffList;
	}

	public void setStaffList(List<Staff> staffList) {
		this.staffList = staffList;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public StaffService getStaffService() {
		return staffService;
	}
	
	public void setStaffService(StaffService staffService) {
		this.staffService = staffService;
	}
	
	public Staff getStaff() {
		return staff;
	}
	
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	
	public String getToJsp() {
		return toJsp;
	}
	
	public void setToJsp(String toJsp) {
		this.toJsp = toJsp;
	}
	
	public String getToAction() {
		return toAction;
	}
	
	public void setToAction(String toAction) {
		this.toAction = toAction;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Long getNavId() {
		return navId;
	}

	public void setNavId(Long navId) {
		this.navId = navId;
	}
	
   
}
