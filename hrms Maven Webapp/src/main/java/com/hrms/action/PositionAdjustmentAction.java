package com.hrms.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.PositionAdjustment;
import com.hrms.scope.ServletScopeAware;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class PositionAdjustmentAction extends ServletScopeAware {
    private String toJsp;
    private String toAction;
    private PositionAdjustment posiAdju;
    private String itemId;
    
    public String posiAdju(){

		//���ò˵�ѡ��
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/posiAdju";
    	return "tojsp";
    }
    
    public String posiAdjuInfo(){

		//���ò˵�ѡ��
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/posiAdjuInfo";
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
	public PositionAdjustment getPosiAdju() {
		return posiAdju;
	}
	public void setPosiAdju(PositionAdjustment posiAdju) {
		this.posiAdju = posiAdju;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    
    

}
