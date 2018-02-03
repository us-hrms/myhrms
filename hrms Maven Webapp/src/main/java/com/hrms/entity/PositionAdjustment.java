package com.hrms.entity;

import java.util.Date;

/**
 * PositionAdjustment entity. @author MyEclipse Persistence Tools
 */

public class PositionAdjustment implements java.io.Serializable {

	// Fields

	private Long id;
	private DataDictionary dataDictionary;
	private Position positionByDefore;
	private Position positionByAfter;
	private Staff staff;
	private Date date;
	private String discription;

	// Constructors

	/** default constructor */
	public PositionAdjustment() {
	}

	/** minimal constructor */
	public PositionAdjustment(DataDictionary dataDictionary,
			Position positionByDefore, Position positionByAfter, Staff staff,
			Date date) {
		this.dataDictionary = dataDictionary;
		this.positionByDefore = positionByDefore;
		this.positionByAfter = positionByAfter;
		this.staff = staff;
		this.date = date;
	}

	/** full constructor */
	public PositionAdjustment(DataDictionary dataDictionary,
			Position positionByDefore, Position positionByAfter, Staff staff,
			Date date, String discription) {
		this.dataDictionary = dataDictionary;
		this.positionByDefore = positionByDefore;
		this.positionByAfter = positionByAfter;
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

	public Position getPositionByDefore() {
		return this.positionByDefore;
	}

	public void setPositionByDefore(Position positionByDefore) {
		this.positionByDefore = positionByDefore;
	}

	public Position getPositionByAfter() {
		return this.positionByAfter;
	}

	public void setPositionByAfter(Position positionByAfter) {
		this.positionByAfter = positionByAfter;
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