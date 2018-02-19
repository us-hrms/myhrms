package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * WagesStandard entity. @author MyEclipse Persistence Tools
 */

public class WagesStandard implements java.io.Serializable {

	// Fields

	private Long id;
	private Double basicWages;
	private Double transportationAllowance;
	private Double communicationAllowance;
	private Double lunchAllowance;
	@JSONField(serialize=false)
	private Set payWageses = new HashSet(0);
	@JSONField(serialize=false)
	private Set staffs = new HashSet(0);

	// Constructors

	/** default constructor */
	public WagesStandard() {
	}

	/** minimal constructor */
	public WagesStandard(Double basicWages, Double transportationAllowance,
			Double communicationAllowance, Double lunchAllowance) {
		this.basicWages = basicWages;
		this.transportationAllowance = transportationAllowance;
		this.communicationAllowance = communicationAllowance;
		this.lunchAllowance = lunchAllowance;
	}

	/** full constructor */
	public WagesStandard(Double basicWages, Double transportationAllowance,
			Double communicationAllowance, Double lunchAllowance,
			Set payWageses, Set staffs) {
		this.basicWages = basicWages;
		this.transportationAllowance = transportationAllowance;
		this.communicationAllowance = communicationAllowance;
		this.lunchAllowance = lunchAllowance;
		this.payWageses = payWageses;
		this.staffs = staffs;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getBasicWages() {
		return this.basicWages;
	}

	public void setBasicWages(Double basicWages) {
		this.basicWages = basicWages;
	}

	public Double getTransportationAllowance() {
		return this.transportationAllowance;
	}

	public void setTransportationAllowance(Double transportationAllowance) {
		this.transportationAllowance = transportationAllowance;
	}

	public Double getCommunicationAllowance() {
		return this.communicationAllowance;
	}

	public void setCommunicationAllowance(Double communicationAllowance) {
		this.communicationAllowance = communicationAllowance;
	}

	public Double getLunchAllowance() {
		return this.lunchAllowance;
	}

	public void setLunchAllowance(Double lunchAllowance) {
		this.lunchAllowance = lunchAllowance;
	}

	public Set getPayWageses() {
		return this.payWageses;
	}

	public void setPayWageses(Set payWageses) {
		this.payWageses = payWageses;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

}