package com.hrms.xml.entity;

import java.io.Serializable;

import com.hrms.xml.uitl.Dom4jUtil;

public class Company implements Serializable {
	/*��˾���ƣ������ˣ����˴���������ҵ����˾��ַ���������룬���棬
	��˾��ַ����˾���䣬��˾�绰*/
	/*
	<company>
	 	<property name="name" value="HYH" />
	 	<property name="responsible" value="��Ф�" />
	 	<property name="legalPerson" value="������" />
	 	<property name="address" value="�����������" />
	 	<property name="postalCode" value="512000" />
	 	<property name="phone" value="020-66666666" />
	 	<property name="email" value="hesmailbox@163.com" />
	</company>
	*/
	
	private String name;//��˾����
	private String responsible;//������
	private String legalPerson;//���˴���
	private String address;//��˾��ַ
	private String postalCode;//��������
	private String phone;//�绰
	private String email;//����
	private String filepath = this.getClass().getClassLoader().getResource("com\\hrms\\xml\\entity\\company.xml").getPath();//company�ļ�·��
	
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
	 * ���Company����
	 * @return
	 */
	public static Company getCompany(){
		return Dom4jUtil.readCompany();
	}
	
	/**
	 * ����Company�������xml������Ϣ
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
	 * ��¡
	 */
	public Company clone(){
		return new Company(this.name,this.responsible,this.legalPerson,
				this.address,this.postalCode,this.phone,this.email);
	}
}
