package com.hrms.entity;

import java.util.Date;

/**
 * Holiday entity. @author MyEclipse Persistence Tools
 */

public class Holiday implements java.io.Serializable {

	// Fields

	private Long id;
	private DataDictionary dataDictionary;
	private Staff staff;
	private Date startDate;
	private Date stopDate;

	// Constructors

	/** default constructor */
	public Holiday() {
	}

	/** full constructor */
	public Holiday(DataDictionary dataDictionary, Staff staff, Date startDate,
			Date stopDate) {
		this.dataDictionary = dataDictionary;
		this.staff = staff;
		this.startDate = startDate;
		this.stopDate = stopDate;
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

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Date getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getStopDate() {
		return this.stopDate;
	}

	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

}