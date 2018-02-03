package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.StaffContract;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class StaffContractAction extends ServletScopeAware {
    private String toJsp;
    private String toAction;
    private StaffContract staffContract;
    private String itemId;

    public String staffContract(){

		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/staffContract";
    	return "tojsp";
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
	public StaffContract getStaffContract() {
		return staffContract;
	}
	public void setStaffContract(StaffContract staffContract) {
		this.staffContract = staffContract;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    

}
