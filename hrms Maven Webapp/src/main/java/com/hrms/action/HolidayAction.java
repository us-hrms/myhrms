package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Holiday;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.HolidayService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class HolidayAction extends ServletScopeAware {
	@Autowired
	private HolidayService holidayService;
    private String toJsp;
    private String toAction;
    private Holiday holiday;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<Holiday> holidays;
    
    public String holiday(){
    	if(page == null)
    		page = new Page();
    	this.holidays = holidayService.getHolidays(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/holiday";
    	return "tojsp";
    }
    
    public String findHoliday(){
    	if(page == null)
    		page = new Page();
    	this.holidays = holidayService.getHolidays(holiday,page);
    	toJsp = "jsp/personnelManager/holiday";
    	return "tojsp";
    }

	public List<Holiday> getHolidays() {
		return holidays;
	}

	public void setHolidays(List<Holiday> holidays) {
		this.holidays = holidays;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
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
	public Holiday getHoliday() {
		return holiday;
	}
	public void setHoliday(Holiday holiday) {
		this.holiday = holiday;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    

}
