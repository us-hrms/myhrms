package com.hrms.xml.entity;

import java.io.Serializable;

import com.hrms.xml.uitl.Dom4jUtil;

public class Company implements Serializable {
	/*公司名称，负责人，法人代表，所属行业，公司地址，邮政编码，传真，
	公司网址，公司邮箱，公司电话*/
	/*
	<company>
	 	<property name="name" value="HYH" />
	 	<property name="responsible" value="岳肖楠" />
	 	<property name="legalPerson" value="韩永琪" />
	 	<property name="address" value="广州市天河区" />
	 	<property name="postalCode" value="512000" />
	 	<property name="phone" value="020-66666666" />
	 	<property name="email" value="hesmailbox@163.com" />
	</company>
	*/
	
	private String name;//公司名称
	private String responsible;//负责人
	private String legalPerson;//法人代表
	private String address;//公司地址
	private String postalCode;//邮政编码
	private String phone;//电话
	private String email;//邮箱
	private String filepath = this.getClass().getClassLoader().getResource("com\\hrms\\xml\\entity\\company.xml").getPath();//company文件路径
	
	public Company() {}
	
	public static Company readCompany() {
		return Dom4jUtil.readCompany();
	}
	
	public Company(String name, String responsible, String legalPerson,
			String address, String postalCode, String phone, String email) {
		super();
		this.name = name;
		this.responsible = responsible;
		this.legalPerson = legalPerson;
		this.address = address;
		this.postalCode = postalCode;
		this.phone = phone;
		this.email = email;
		this.filepath = filepath;
	}
	
	/**
	 * 获得Company对象
	 * @return
	 */
	public static Company getCompany(){
		return Dom4jUtil.readCompany();
	}
	
	/**
	 * 根据Company对象更新xml配置信息
	 * @param company
	 * @return
	 */
	public static boolean updateCompany(Company company){
		return Dom4jUtil.writeCompany(company);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getResponsible() {
		return responsible;
	}
	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}
	public String getLegalPerson() {
		return legalPerson;
	}
	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", responsible=" + responsible
				+ ", legalPerson=" + legalPerson + ", address=" + address
				+ ", postalCode=" + postalCode + ", phone=" + phone
				+ ", email=" + email + ", filepath=" + filepath + "]";
	}
	
	/**
	 * 克隆
	 */
	public Company clone(){
		return new Company(this.name,this.responsible,this.legalPerson,
				this.address,this.postalCode,this.phone,this.email);
	}
}
