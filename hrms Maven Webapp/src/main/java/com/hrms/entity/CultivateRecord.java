package com.hrms.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * CultivateRecord entity. @author MyEclipse Persistence Tools
 */

public class CultivateRecord implements java.io.Serializable {

	// Fields

	private Long id;
	private Cultivate cultivate;
	private Staff staff;
	private DataDictionary dataDictionary;
	private Double cost;
	private Date start;
	private Date stop;
	private String discription;
	private Set cultivateStaffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public CultivateRecord() {
	}

	/** minimal constructor */
	public CultivateRecord(Cultivate cultivate, Staff staff,
			DataDictionary dataDictionary, Double cost, Date start, Date stop) {
		this.cultivate = cultivate;
		this.staff = staff;
		this.dataDictionary = dataDictionary;
		this.cost = cost;
		this.start = start;
		this.stop = stop;
	}

	/** full constructor */
	public CultivateRecord(Cultivate cultivate, Staff staff,
			DataDictionary dataDictionary, Double cost, Date start, Date stop,
			String discription, Set cultivateStaffs) {
		this.cultivate = cultivate;
		this.staff = staff;
		this.dataDictionary = dataDictionary;
		this.cost = cost;
		this.start = start;
		this.stop = stop;
		this.discription = discription;
		this.cultivateStaffs = cultivateStaffs;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cultivate getCultivate() {
		return this.cultivate;
	}

	public void setCultivate(Cultivate cultivate) {
		this.cultivate = cultivate;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public DataDictionary getDataDictionary() {
		return this.dataDictionary;
	}

	public void setDataDictionary(DataDictionary dataDictionary) {
		this.dataDictionary = dataDictionary;
	}

	public Double getCost() {
		return this.cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Set getCultivateStaffs() {
		return this.cultivateStaffs;
	}

	public void setCultivateStaffs(Set cultivateStaffs) {
		this.cultivateStaffs = cultivateStaffs;
	}

}