package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.CultivateStaff;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class CultivateStaffAction extends ServletScopeAware {
	private CultivateStaff cultivateStaff;
    private String toJsp;
    private String toAction;
    private String itemId;
    
    public String cultivateStaff(){

		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/cultivatePlan/cultivateStaff";
    	return "tojsp";
    }
    
	public CultivateStaff getCultivateStaff() {
		return cultivateStaff;
	}
	public void setCultivateStaff(CultivateStaff cultivateStaff) {
		this.cultivateStaff = cultivateStaff;
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

}
