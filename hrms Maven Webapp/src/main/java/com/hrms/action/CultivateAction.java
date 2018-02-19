package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Cultivate;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class CultivateAction extends ServletScopeAware {
	private Cultivate cultivate;
    private String toJsp;
    private String toAction;
    private String itemId;
    private Staff currStaff;
    
    //��ҳ����
    private Page page;
    
    public String cultivate(){

		//���ò˵�ѡ��
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/cultivatePlan/cultivate";
    	return "tojsp";
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public Cultivate getCultivate() {
		return cultivate;
	}
	public void setCultivate(Cultivate cultivate) {
		this.cultivate = cultivate;
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
