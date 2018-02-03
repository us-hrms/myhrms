package com.hrms.entity;

import java.util.Date;

/**
 * PersonnelFiles entity. @author MyEclipse Persistence Tools
 */

public class PersonnelFiles implements java.io.Serializable {

	// Fields

	private Long id;
	private Staff staff;
	private String no;
	private String name;
	private String content;
	private Date date;

	// Constructors

	/** default constructor */
	public PersonnelFiles() {
	}

	/** full constructor */
	public PersonnelFiles(Staff staff, String no, String name, String content,
			Date date) {
		this.staff = staff;
		this.no = no;
		this.name = name;
		this.content = content;
		this.date = date;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}