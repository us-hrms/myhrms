package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.PositionAdjustment;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.PositionAdjustmentService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class PositionAdjustmentAction extends ServletScopeAware {
	@Autowired
	private PositionAdjustmentService posiAdjuService;
    private String toJsp;
    private String toAction;
    private PositionAdjustment posiAdju;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<PositionAdjustment> posiAdjus;
    
    public String posiAdju(){
    	if(page==null)
    		page = new Page();
    	this.posiAdjus = posiAdjuService.getPositionAdjustments(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/posiAdju";
    	return "tojsp";
    }
    
    public String findPosiAdju(){
    	if(page==null)
    		page = new Page();
    	this.posiAdjus = posiAdjuService.getPositionAdjustments(this.posiAdju,page);

    	toJsp = "jsp/personnelManager/posiAdju";
    	return "tojsp";
    }
    
    public String posiAdjuInfo(){
    	if(page==null)
    		page = new Page();
    	this.posiAdjus = posiAdjuService.getPositionAdjustments(page);

		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/posiAdjuInfo";
    	return "tojsp";
    }
    
    public String findPosiAdjuInfo(){
    	if(page==null)
    		page = new Page();
    	this.posiAdjus = posiAdjuService.getPositionAdjustments(this.posiAdju,page);

    	toJsp = "jsp/personnelManager/posiAdjuInfo";
    	return "tojsp";
    }

    
    
	public List<PositionAdjustment> getPosiAdjus() {
		return posiAdjus;
	}

	public void setPosiAdjus(List<PositionAdjustment> posiAdjus) {
		this.posiAdjus = posiAdjus;
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
