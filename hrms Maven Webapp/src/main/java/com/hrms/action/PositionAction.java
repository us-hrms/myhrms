package com.hrms.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hrms.entity.Position;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.PositionService;
import com.hrms.util.MenuHelper;
import com.hrms.util.PrintWriteUtil;

@Controller
@Scope("prototype")
public class PositionAction extends ServletScopeAware {
	@Autowired
	private PositionService positionService;
    private String toJsp;
    private String toAction;
    private Position position;
    private String itemId;
    private Staff currStaff;
    
    //网页数据
    private Page page;
    private List<Position> positions;
    
    
    public String position(){
    	if(page == null)
    		page = new  Page();
    	this.positions = positionService.getPositions(page);
		//设置菜单选项
		if(itemId != null)
			MenuHelper.changeMenu(session, itemId);
    	toJsp = "jsp/personnelManager/position";
    	return "tojsp";
    }
    
    public String findPosition(){
    	this.positions = positionService.getPositions(position, page);
    	toJsp = "jsp/personnelManager/position";
    	return "tojsp";
    }
    
    
    public String ajaxPositions(){
    	if(this.position == null)
    		this.position = new Position();
    	this.positions = positionService.getPositions(this.position);
    	String info = JSONObject.toJSONString(this.positions);
    	PrintWriteUtil.write(response, info);
    	return null;
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
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}

	public String getItemId() {
		return itemId;
	}


	public List<Position> getPositions() {
		return positions;
	}
	public void setPositions(List<Position> positions) {
		this.positions = positions;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

    

}
