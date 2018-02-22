package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Certificate;
import com.hrms.entity.Cultivate;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.CultivateService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class CultivateAction extends ServletScopeAware {
	@Autowired
	private CultivateService cultivateService;
	private Cultivate cultivate;
	private Certificate certificate;
    private String toJsp;
    private String toAction;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<Cultivate> cultivates;
    
    public String cultivate(){
    	if(page == null)
    		this.page = new Page();
    	this.cultivates = cultivateService.getCultivates(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/cultivatePlan/cultivate";
    	return "tojsp";
    }
    
    public String findCultivate(){
    	if(page == null)
    		this.page = new Page();
    	this.cultivates = cultivateService.getCultivates(this.cultivate,this.certificate,page);
    	this.toJsp = "jsp/cultivatePlan/cultivate";
    	return "tojsp";
    }

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public List<Cultivate> getCultivates() {
		return cultivates;
	}

	public void setCultivates(List<Cultivate> cultivates) {
		this.cultivates = cultivates;
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
