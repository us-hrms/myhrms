package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Certificate entity. @author MyEclipse Persistence Tools
 */

public class Certificate implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String discription;

	@JSONField(serialize=false)
	private Set cultivateStaffs = new HashSet(0);
	@JSONField(serialize=false)
	private Set staffCertificates = new HashSet(0);
	@JSONField(serialize=false)
	private Set cultivates = new HashSet(0);

	// Constructors

	/** default constructor */
	public Certificate() {
	}

	/** minimal constructor */
	public Certificate(String name) {
		this.name = name;
	}
	

	public Certificate(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Certificate(String name, String discription, Set cultivateStaffs,
			Set staffCertificates, Set cultivates) {
		this.name = name;
		this.discription = discription;
		this.cultivateStaffs = cultivateStaffs;
		this.staffCertificates = staffCertificates;
		this.cultivates = cultivates;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set getStaffCertificates() {
		return this.staffCertificates;
	}

	public void setStaffCertificates(Set staffCertificates) {
		this.staffCertificates = staffCertificates;
	}

	public Set getCultivates() {
		return this.cultivates;
	}

	public void setCultivates(Set cultivates) {
		this.cultivates = cultivates;
	}

}