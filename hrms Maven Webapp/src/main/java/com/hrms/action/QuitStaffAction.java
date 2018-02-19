package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.QuitStaff;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class QuitStaffAction extends ServletScopeAware {
    private String toJsp;
    private String toAction;
    private QuitStaff quitStaff;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    
    public String quitStaff(){

		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/personnelManager/quitStaff";
    	return "tojsp";
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
	public QuitStaff getQuitStaff() {
		return quitStaff;
	}
	public void setQuitStaff(QuitStaff quitStaff) {
		this.quitStaff = quitStaff;
	}


	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


}
