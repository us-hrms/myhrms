package com.hrms.entity;

import java.util.Date;

/**
 * StaffMobilization entity. @author MyEclipse Persistence Tools
 */

public class StaffMobilization implements java.io.Serializable {

	// Fields

	private Long id;
	private DataDictionary dataDictionary;
	private Department departmentByDefore;
	private Department departmentByAfter;
	private Staff staff;
	private Date date;
	private String discription;

	// Constructors

	/** default constructor */
	public StaffMobilization() {
	}

	/** minimal constructor */
	public StaffMobilization(DataDictionary dataDictionary,
			Department departmentByDefore, Department departmentByAfter,
			Staff staff, Date date) {
		this.dataDictionary = dataDictionary;
		this.departmentByDefore = departmentByDefore;
		this.departmentByAfter = departmentByAfter;
		this.staff = staff;
		this.date = date;
	}

	/** full constructor */
	public StaffMobilization(DataDictionary dataDictionary,
			Department departmentByDefore, Department departmentByAfter,
			Staff staff, Date date, String discription) {
		this.dataDictionary = dataDictionary;
		this.departmentByDefore = departmentByDefore;
		this.departmentByAfter = departmentByAfter;
		this.staff = staff;
		this.date = date;
		this.discription = discription;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataDictionary getDataDictionary() {
		return this.dataDictionary;
	}

	public void setDataDictionary(DataDictionary dataDictionary) {
		this.dataDictionary = dataDictionary;
	}

	public Department getDepartmentByDefore() {
		return this.departmentByDefore;
	}

	public void setDepartmentByDefore(Department departmentByDefore) {
		this.departmentByDefore = departmentByDefore;
	}

	public Department getDepartmentByAfter() {
		return this.departmentByAfter;
	}

	public void setDepartmentByAfter(Department departmentByAfter) {
		this.departmentByAfter = departmentByAfter;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

}