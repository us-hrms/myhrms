package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Department;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.DepartmentService;
import com.hrms.util.MenuHelper;

@Controller
@Scope("prototype")
public class DepartmentAction extends ServletScopeAware {
	@Autowired
	private DepartmentService departmentService;
	private Department department;
    private String toJsp;
    private String toAction;
    private String itemId;
    private Staff currStaff;
    //传参数据
    private Integer count;
    
    //网页数据
    private Page page;
    private List<Department> deptList;
    
    
    public String department(){
    	if(page == null)
    		page = new Page();
    	deptList = departmentService.getDepartments(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/department";
    	return "tojsp";
    }
    
    public String getDept(){
    	if(page == null)
    		page = new Page();
    	deptList = departmentService.getDepartments(department,count,page);
    	toJsp = "jsp/personnelManager/department";
    	return "tojsp";
    }
    
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public DepartmentService getDepartmentService() {
		return departmentService;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public List<Department> getDeptList() {
		return deptList;
	}

	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
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


	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getItemId() {
		return itemId;
	}


	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    

}
