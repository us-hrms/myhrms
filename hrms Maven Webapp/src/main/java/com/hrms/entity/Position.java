package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Position entity. @author MyEclipse Persistence Tools
 */

public class Position implements java.io.Serializable {

	// Fields

	private Long id;
	private Department department;
	private String name;
	@JSONField(serialize=false)
	private Set staffs = new HashSet(0);
	@JSONField(serialize=false)
	private Set positionAdjustmentsForAfter = new HashSet(0);
	@JSONField(serialize=false)
	private Set positionAdjustmentsForDefore = new HashSet(0);

	// Constructors

	/** default constructor */
	public Position() {
	}

	/** minimal constructor */
	public Position(String name) {
		this.name = name;
	}

	/** full constructor */
	public Position(Department department, String name, Set staffs,
			Set positionAdjustmentsForAfter, Set positionAdjustmentsForDefore) {
		this.department = department;
		this.name = name;
		this.staffs = staffs;
		this.positionAdjustmentsForAfter = positionAdjustmentsForAfter;
		this.positionAdjustmentsForDefore = positionAdjustmentsForDefore;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getStaffs() {
		return this.staffs;
	}

	public void setStaffs(Set staffs) {
		this.staffs = staffs;
	}

	public Set getPositionAdjustmentsForAfter() {
		return this.positionAdjustmentsForAfter;
	}

	public void setPositionAdjustmentsForAfter(Set positionAdjustmentsForAfter) {
		this.positionAdjustmentsForAfter = positionAdjustmentsForAfter;
	}

	public Set getPositionAdjustmentsForDefore() {
		return this.positionAdjustmentsForDefore;
	}

	public void setPositionAdjustmentsForDefore(Set positionAdjustmentsForDefore) {
		this.positionAdjustmentsForDefore = positionAdjustmentsForDefore;
	}

}