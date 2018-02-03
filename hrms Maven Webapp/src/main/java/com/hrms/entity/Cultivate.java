package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Cultivate entity. @author MyEclipse Persistence Tools
 */

public class Cultivate implements java.io.Serializable {

	// Fields

	private Long id;
	private String name;
	private String discription;
	private Set certificates = new HashSet(0);
	private Set cultivateRecords = new HashSet(0);

	// Constructors

	/** default constructor */
	public Cultivate() {
	}

	/** minimal constructor */
	public Cultivate(String name) {
		this.name = name;
	}

	/** full constructor */
	public Cultivate(String name, String discription, Set certificates,
			Set cultivateRecords) {
		this.name = name;
		this.discription = discription;
		this.certificates = certificates;
		this.cultivateRecords = cultivateRecords;
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

	public Set getCertificates() {
		return this.certificates;
	}

	public void setCertificates(Set certificates) {
		this.certificates = certificates;
	}

	public Set getCultivateRecords() {
		return this.cultivateRecords;
	}

	public void setCultivateRecords(Set cultivateRecords) {
		this.cultivateRecords = cultivateRecords;
	}

}