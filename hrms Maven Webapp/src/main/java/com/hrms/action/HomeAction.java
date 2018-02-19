package com.hrms.action;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.xml.entity.Nav;

@Controller
@Scope("prototype")
public class HomeAction extends ServletScopeAware{
	
    private String toJsp;
    private String toAction;
    private Long navId;
    private Staff currStaff;
    
    //ÍøÒ³Êý¾Ý
    private Page page;
	
	public String toHome(){
    	List<Nav> currNav = (List<Nav>) session.getAttribute("currNavbar");
    	if(currNav == null)
    		currNav = (List<Nav>) application.getAttribute("commonNavbar");
		Nav.setSelected(1l, currNav);
    	session.setAttribute("currNavbar", currNav);
		this.toJsp = "jsp/home";
		return "success";
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

	public Long getNavId() {
		return navId;
	}

	public void setNavId(Long navId) {
		this.navId = navId;
	}

	

	
	
}
