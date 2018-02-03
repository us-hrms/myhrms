package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * CultivateStaff entity. @author MyEclipse Persistence Tools
 */

public class CultivateStaff implements java.io.Serializable {

	// Fields

	private Long id;
	private DataDictionary dataDictionary;
	private CultivateRecord cultivateRecord;
	private Staff staff;
	private Certificate certificate;
	private Integer score;
	private Set staffCertificates = new HashSet(0);

	// Constructors

	/** default constructor */
	public CultivateStaff() {
	}

	/** minimal constructor */
	public CultivateStaff(DataDictionary dataDictionary,
			CultivateRecord cultivateRecord, Staff staff,
			Certificate certificate) {
		this.dataDictionary = dataDictionary;
		this.cultivateRecord = cultivateRecord;
		this.staff = staff;
		this.certificate = certificate;
	}

	/** full constructor */
	public CultivateStaff(DataDictionary dataDictionary,
			CultivateRecord cultivateRecord, Staff staff,
			Certificate certificate, Integer score, Set staffCertificates) {
		this.dataDictionary = dataDictionary;
		this.cultivateRecord = cultivateRecord;
		this.staff = staff;
		this.certificate = certificate;
		this.score = score;
		this.staffCertificates = staffCertificates;
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

	public CultivateRecord getCultivateRecord() {
		return this.cultivateRecord;
	}

	public void setCultivateRecord(CultivateRecord cultivateRecord) {
		this.cultivateRecord = cultivateRecord;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Certificate getCertificate() {
		return this.certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Set getStaffCertificates() {
		return this.staffCertificates;
	}

	public void setStaffCertificates(Set staffCertificates) {
		this.staffCertificates = staffCertificates;
	}

}