package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Staff;
import com.hrms.entity.StaffCertificate;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.StaffCertificateService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class StaffCertificateAction extends ServletScopeAware {
	@Autowired
	private StaffCertificateService staffCertService;
    private String toJsp;
    private String toAction;
    private StaffCertificate staffCertificate;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<StaffCertificate> staffCertificates;
    
    
    public String staffCertificateManager(){
    	if(page == null){
    		page = new Page();
    	}
    	this.staffCertificates = staffCertService.getStaffCertificates(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/staffCertificateManager";
    	return "tojsp";
    }
    
    public String findStaffCertificateManager(){
    	if(page == null){
    		page = new Page();
    	}
    	this.staffCertificates = staffCertService.getStaffCertificates(this.staffCertificate,page);
    	this.toJsp = "jsp/staffInfoManager/staffCertificateManager";
    	return "tojsp";
    }

	public List<StaffCertificate> getStaffCertificates() {
		return staffCertificates;
	}

	public void setStaffCertificates(List<StaffCertificate> staffCertificates) {
		this.staffCertificates = staffCertificates;
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
	public StaffCertificate getStaffCertificate() {
		return staffCertificate;
	}
	public void setStaffCertificate(StaffCertificate staffCertificate) {
		this.staffCertificate = staffCertificate;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


}
