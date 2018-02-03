package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.StaffMobilization;
import com.hrms.scope.ServletScopeAware;

@Controller
@Scope("prototype")
public class StaffMobilizationAction extends ServletScopeAware {
    private String toJsp;
    private String toAction;
    private StaffMobilization staffMobi;
    private String itemId;
    
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
	public StaffMobilization getStaffMobi() {
		return staffMobi;
	}
	public void setStaffMobi(StaffMobilization staffMobi) {
		this.staffMobi = staffMobi;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    
}
