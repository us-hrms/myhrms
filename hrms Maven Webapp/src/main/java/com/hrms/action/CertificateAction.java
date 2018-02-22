package com.hrms.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSONObject;
import com.hrms.entity.Certificate;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.scope.ServletScopeAware;
import com.hrms.service.CertificateService;
import com.hrms.util.PrintWriteUtil;

@Controller
@Scope("prototype")
public class CertificateAction extends ServletScopeAware {
	@Autowired
	private CertificateService certificateService;
    private String toJsp;
    private String toAction;
    private Certificate certificate;
    private String itemId;
    private Staff currStaff;
    
    //ÍøÒ³Êý¾Ý
    private Page page;
    private List<Certificate> certificates;
    
    public String ajaxGetCertificates(){
    	this.certificates = certificateService.getCertificates();
    	List<Certificate> temp = new ArrayList<Certificate>();
    	String info = JSONObject.toJSONString(this.certificates);
    	PrintWriteUtil.write(response, info);
    	return null;
    }
    
    
	public List<Certificate> getCertificates() {
		return certificates;
	}
	public void setCertificates(List<Certificate> certificates) {
		this.certificates = certificates;
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
	public Certificate getCertificate() {
		return certificate;
	}
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
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
