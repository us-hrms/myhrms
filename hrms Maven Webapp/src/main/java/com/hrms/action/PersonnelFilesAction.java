package com.hrms.action;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.PersonnelFiles;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.PersonnelFilesService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class PersonnelFilesAction extends ServletScopeAware {
	@Autowired
	private PersonnelFilesService personnelFilesService;
    private String toJsp;
    private String toAction;
    private PersonnelFiles personnelFiles;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private Date start,end;
    private List<PersonnelFiles> personnelFiless;

    public String staffFile(){
    	if(page == null)
    		page = new Page();
    	this.personnelFiless = personnelFilesService.getPersonnelFiles(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/staffFile";
    	return "tojsp";
    }

    public String findStaffFile(){
    	if(page == null)
    		page = new Page();
    	this.personnelFiless = personnelFilesService.getPersonnelFiless(this.personnelFiles,start,end,page);
    	this.toJsp = "jsp/staffInfoManager/staffFile";
    	return "tojsp";
    }
    
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public List<PersonnelFiles> getPersonnelFiless() {
		return personnelFiless;
	}

	public void setPersonnelFiless(List<PersonnelFiles> personnelFiless) {
		this.personnelFiless = personnelFiless;
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
	public PersonnelFiles getPersonnelFiles() {
		return personnelFiles;
	}
	public void setPersonnelFiles(PersonnelFiles personnelFiles) {
		this.personnelFiles = personnelFiles;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    

}
