package com.hrms.entity;

import java.util.Date;

/**
 * PunishmentReward entity. @author MyEclipse Persistence Tools
 */

public class PunishmentReward implements java.io.Serializable {

	// Fields

	private Long id;
	private Staff staff;
	private Boolean type;
	private String title;
	private String content;
	private Double amount;
	private Date date;

	// Constructors

	/** default constructor */
	public PunishmentReward() {
	}

	/** minimal constructor */
	public PunishmentReward(Staff staff, String title, String content,
			Double amount, Date date) {
		this.staff = staff;
		this.title = title;
		this.content = content;
		this.amount = amount;
		this.date = date;
	}

	/** full constructor */
	public PunishmentReward(Staff staff, Boolean type, String title,
			String content, Double amount, Date date) {
		this.staff = staff;
		this.type = type;
		this.title = title;
		this.content = content;
		this.amount = amount;
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

	public Boolean getType() {
		return this.type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Double getAmount() {
		return this.amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}