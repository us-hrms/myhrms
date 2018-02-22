package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Staff;
import com.hrms.entity.StaffContract;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.StaffContractService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class StaffContractAction extends ServletScopeAware {
	@Autowired
	private StaffContractService contractService;
    private String toJsp;
    private String toAction;
    private StaffContract staffContract;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<StaffContract> contracts;

    public String staffContract(){
    	if(page == null)
    		page = new Page();
    	this.contracts = contractService.getStaffContracts(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	this.toJsp = "jsp/staffInfoManager/staffContract";
    	return "tojsp";
    }

    public String findStaffContract(){
    	if(page == null)
    		page = new Page();
    	this.contracts = contractService.getStaffContracts(this.staffContract,page);
    	this.toJsp = "jsp/staffInfoManager/staffContract";
    	return "tojsp";
    }

	public List<StaffContract> getContracts() {
		return contracts;
	}

	public void setContracts(List<StaffContract> contracts) {
		this.contracts = contracts;
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
