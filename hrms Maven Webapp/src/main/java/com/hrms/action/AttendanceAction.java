package com.hrms.action;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hrms.entity.Attendance;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.AttendanceService;
import com.hrms.util.MenuHelper;
import com.hrms.util.NavbarHelper;
import com.hrms.util.PrintWriteUtil;

@Controller
@Scope("prototype")
public class AttendanceAction extends ServletScopeAware {
	@Autowired
	private AttendanceService attendanceService;
    private String toJsp;
    private String toAction;
    //请求数据
    private String itemId;
    private Long navId;
    private Staff currStaff;
	private Attendance attendance;
	private Timestamp start;
	private Timestamp stop;
    //页面数据存储对象
    private List<Attendance> atteList;
    private Page page;
    

	public String attendance(){
		if(page == null)
			page = new Page();
		this.atteList = attendanceService.getAttendancesOfStaff(currStaff,page);
		//设置nvabar
		if(navId != null)
			NavbarHelper.changeNavbar(session, navId);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
		toJsp = "jsp/personnelManager/attendance";
		return "tojsp";
	}
	
	
	public String findAttendance(){
		if(page == null)
			page = new Page();
		this.atteList = attendanceService
				.getAttendancesOfStaff(currStaff, attendance, start, stop, page);
		toJsp = "jsp/personnelManager/attendance";
		return "tojsp";
	}
	
	
	public Timestamp getStart() {
		return start;
	}


	public void setStart(Timestamp start) {
		this.start = start;
	}


	public Timestamp getStop() {
		return stop;
	}


	public void setStop(Timestamp stop) {
		this.stop = stop;
	}


	public Staff getCurrStaff() {
		return currStaff;
	}


	public void setCurrStaff(Staff currStaff) {
		this.currStaff = currStaff;
	}


	public AttendanceService getAttendanceService() {
		return attendanceService;
	}


	public void setAttendanceService(AttendanceService attendanceService) {
		this.attendanceService = attendanceService;
	}


	public Page getPage() {
		return page;
	}


	public void setPage(Page page) {
		this.page = page;
	}


	public List<Attendance> getAtteList() {
		return atteList;
	}


	public void setAtteList(List<Attendance> atteList) {
		this.atteList = atteList;
	}


	public Attendance getAttendance() {
		return attendance;
	}

	public void setAttendance(Attendance attendance) {
		this.attendance = attendance;
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
