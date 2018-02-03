package com.hrms.entity;

import java.sql.Timestamp;

/**
 * QuitStaff entity. @author MyEclipse Persistence Tools
 */

public class QuitStaff implements java.io.Serializable {

	// Fields

	private Long sid;
	private DataDictionary dataDictionary;
	private Staff staff;
	private String reason;
	private Timestamp time;

	// Constructors

	/** default constructor */
	public QuitStaff() {
	}

	/** minimal constructor */
	public QuitStaff(DataDictionary dataDictionary, Staff staff, Timestamp time) {
		this.dataDictionary = dataDictionary;
		this.staff = staff;
		this.time = time;
	}

	/** full constructor */
	public QuitStaff(DataDictionary dataDictionary, Staff staff, String reason,
			Timestamp time) {
		this.dataDictionary = dataDictionary;
		this.staff = staff;
		this.reason = reason;
		this.time = time;
	}

	// Property accessors

	public Long getSid() {
		return this.sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
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

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Timestamp getTime() {
		return this.time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

}