package com.hrms.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hrms.entity.DataDictionary;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.DataDictionaryService;
import com.hrms.util.PrintWriteUtil;

@Controller
@Scope("prototype")
public class DataDictionaryAction extends ServletScopeAware{
	@Autowired
	private DataDictionaryService dataDictionaryService;
	private DataDictionary dataDictionary;
    private String toJsp;
    private String toAction;
    private String itemId;
    private Staff currStaff;
    
    //ÍøÒ³Êý¾Ý
    private Page page;
    
    public String getDateDictsByAjax(){
    	String info = JSONObject.toJSONString(dataDictionaryService.getDataDictionarys(dataDictionary));
    	PrintWriteUtil.write(response, info);
    	return null;
    }

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}
	public DataDictionary getDataDictionary() {
		return dataDictionary;
	}
	public void setDataDictionary(DataDictionary dataDictionary) {
		this.dataDictionary = dataDictionary;
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
