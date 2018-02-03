package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.CultivateRecord;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class CultivateRecordAction extends ServletScopeAware {
	private CultivateRecord cultivateRecord;
    private String toJsp;
    private String toAction;
    private String itemId;
    
    public String cultivateRecord(){

		//���ò˵�ѡ��
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/cultivatePlan/cultivateRecord";
    	return "tojsp";
    }
    
	public CultivateRecord getCultivateRecord() {
		return cultivateRecord;
	}
	public void setCultivateRecord(CultivateRecord cultivateRecord) {
		this.cultivateRecord = cultivateRecord;
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
