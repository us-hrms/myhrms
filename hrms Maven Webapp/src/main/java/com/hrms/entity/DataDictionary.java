package com.hrms.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * DataDictionary entity. @author MyEclipse Persistence Tools
 */

public class DataDictionary implements java.io.Serializable {

	// Fields

	private Long id;
	private String tableColumn;
	private String value;
	private String discription;
	private Set staffMobilizations = new HashSet(0);
	private Set staffsForEducationId = new HashSet(0);
	private Set staffsForAcademicdegreeId = new HashSet(0);
	private Set cultivateRecords = new HashSet(0);
	private Set cultivateStaffs = new HashSet(0);
	private Set quitStaffs = new HashSet(0);
	private Set holidaies = new HashSet(0);
	private Set staffsForStatus = new HashSet(0);
	private Set positionAdjustments = new HashSet(0);
	private Set attendances = new HashSet(0);
	private Set staffsForTypeId = new HashSet(0);

	// Constructors

	/** default constructor */
	public DataDictionary() {
	}

	/** minimal constructor */
	public DataDictionary(String tableColumn, String value) {
		this.tableColumn = tableColumn;
		this.value = value;
	}

	/** full constructor */
	public DataDictionary(String tableColumn, String value, String discription,
			Set staffMobilizations, Set staffsForEducationId,
			Set staffsForAcademicdegreeId, Set cultivateRecords,
			Set cultivateStaffs, Set quitStaffs, Set holidaies,
			Set staffsForStatus, Set positionAdjustments, Set attendances,
			Set staffsForTypeId) {
		this.tableColumn = tableColumn;
		this.value = value;
		this.discription = discription;
		this.staffMobilizations = staffMobilizations;
		this.staffsForEducationId = staffsForEducationId;
		this.staffsForAcademicdegreeId = staffsForAcademicdegreeId;
		this.cultivateRecords = cultivateRecords;
		this.cultivateStaffs = cultivateStaffs;
		this.quitStaffs = quitStaffs;
		this.holidaies = holidaies;
		this.staffsForStatus = staffsForStatus;
		this.positionAdjustments = positionAdjustments;
		this.attendances = attendances;
		this.staffsForTypeId = staffsForTypeId;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTableColumn() {
		return this.tableColumn;
	}

	public void setTableColumn(String tableColumn) {
		this.tableColumn = tableColumn;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDiscription() {
		return this.discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Set getStaffMobilizations() {
		return this.staffMobilizations;
	}

	public void setStaffMobilizations(Set staffMobilizations) {
		this.staffMobilizations = staffMobilizations;
	}

	public Set getStaffsForEducationId() {
		return this.staffsForEducationId;
	}

	public void setStaffsForEducationId(Set staffsForEducationId) {
		this.staffsForEducationId = staffsForEducationId;
	}

	public Set getStaffsForAcademicdegreeId() {
		return this.staffsForAcademicdegreeId;
	}

	public void setStaffsForAcademicdegreeId(Set staffsForAcademicdegreeId) {
		this.staffsForAcademicdegreeId = staffsForAcademicdegreeId;
	}

	public Set getCultivateRecords() {
		return this.cultivateRecords;
	}

	public void setCultivateRecords(Set cultivateRecords) {
		this.cultivateRecords = cultivateRecords;
	}

	public Set getCultivateStaffs() {
		return this.cultivateStaffs;
	}

	public void setCultivateStaffs(Set cultivateStaffs) {
		this.cultivateStaffs = cultivateStaffs;
	}

	public Set getQuitStaffs() {
		return this.quitStaffs;
	}

	public void setQuitStaffs(Set quitStaffs) {
		this.quitStaffs = quitStaffs;
	}

	public Set getHolidaies() {
		return this.holidaies;
	}

	public void setHolidaies(Set holidaies) {
		this.holidaies = holidaies;
	}

	public Set getStaffsForStatus() {
		return this.staffsForStatus;
	}

	public void setStaffsForStatus(Set staffsForStatus) {
		this.staffsForStatus = staffsForStatus;
	}

	public Set getPositionAdjustments() {
		return this.positionAdjustments;
	}

	public void setPositionAdjustments(Set positionAdjustments) {
		this.positionAdjustments = positionAdjustments;
	}

	public Set getAttendances() {
		return this.attendances;
	}

	public void setAttendances(Set attendances) {
		this.attendances = attendances;
	}

	public Set getStaffsForTypeId() {
		return this.staffsForTypeId;
	}

	public void setStaffsForTypeId(Set staffsForTypeId) {
		this.staffsForTypeId = staffsForTypeId;
	}

}