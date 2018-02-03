package com.hrms.entity;

import java.sql.Timestamp;

/**
 * PayWages entity. @author MyEclipse Persistence Tools
 */

public class PayWages implements java.io.Serializable {

	// Fields

	private Long id;
	private Staff staff;
	private WagesStandard wagesStandard;
	private Double shouldPay;
	private Double actualPay;
	private Double reward;
	private Double deduct;
	private Timestamp date;
	private String dscription;

	// Constructors

	/** default constructor */
	public PayWages() {
	}

	/** minimal constructor */
	public PayWages(Staff staff, WagesStandard wagesStandard, Double shouldPay,
			Double actualPay, Double reward, Double deduct, Timestamp date) {
		this.staff = staff;
		this.wagesStandard = wagesStandard;
		this.shouldPay = shouldPay;
		this.actualPay = actualPay;
		this.reward = reward;
		this.deduct = deduct;
		this.date = date;
	}

	/** full constructor */
	public PayWages(Staff staff, WagesStandard wagesStandard, Double shouldPay,
			Double actualPay, Double reward, Double deduct, Timestamp date,
			String dscription) {
		this.staff = staff;
		this.wagesStandard = wagesStandard;
		this.shouldPay = shouldPay;
		this.actualPay = actualPay;
		this.reward = reward;
		this.deduct = deduct;
		this.date = date;
		this.dscription = dscription;
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

	public WagesStandard getWagesStandard() {
		return this.wagesStandard;
	}

	public void setWagesStandard(WagesStandard wagesStandard) {
		this.wagesStandard = wagesStandard;
	}

	public Double getShouldPay() {
		return this.shouldPay;
	}

	public void setShouldPay(Double shouldPay) {
		this.shouldPay = shouldPay;
	}

	public Double getActualPay() {
		return this.actualPay;
	}

	public void setActualPay(Double actualPay) {
		this.actualPay = actualPay;
	}

	public Double getReward() {
		return this.reward;
	}

	public void setReward(Double reward) {
		this.reward = reward;
	}

	public Double getDeduct() {
		return this.deduct;
	}

	public void setDeduct(Double deduct) {
		this.deduct = deduct;
	}

	public Timestamp getDate() {
		return this.date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public String getDscription() {
		return this.dscription;
	}

	public void setDscription(String dscription) {
		this.dscription = dscription;
	}

}