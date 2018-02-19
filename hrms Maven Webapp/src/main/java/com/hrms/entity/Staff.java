package com.hrms.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */

public class Staff implements java.io.Serializable {

	// Fields

	private Long id;
	private DataDictionary dataDictionaryByAcademicdegreeId;
	private DataDictionary dataDictionaryByStatus;
	private DataDictionary dataDictionaryByEducationId;
	private DataDictionary dataDictionaryByTypeId;
	private WagesStandard wagesStandard;
	private Position position;
	private Department department;
	private String no;
	private String name;
	private String password;
	private String sex;
	private Date bornDate;
	private String address;
	private String phone;
	private String email;
	private String photo;
	@JSONField(serialize=false)
	private Set positionAdjustments = new HashSet(0);
	@JSONField(serialize=false)
	private Set payWageses = new HashSet(0);
	@JSONField(serialize=false)
	private Set cultivateRecords = new HashSet(0);
	@JSONField(serialize=false)
	private Set attendances = new HashSet(0);
	@JSONField(serialize=false)
	private Set staffMobilizations = new HashSet(0);
	@JSONField(serialize=false)
	private Set cultivateStaffs = new HashSet(0);
	@JSONField(serialize=false)
	private Set staffCertificates = new HashSet(0);
	@JSONField(serialize=false)
	private Set quitStaffs = new HashSet(0);
	@JSONField(serialize=false)
	private Set holidaies = new HashSet(0);
	@JSONField(serialize=false)
	private Set personnelFileses = new HashSet(0);
	@JSONField(serialize=false)
	private Set punishmentRewards = new HashSet(0);
	@JSONField(serialize=false)
	private Set staffContracts = new HashSet(0);

	// Constructors

	/** default constructor */
	public Staff() {
	}
	public Staff(Department department,DataDictionary dataDictionaryByTypeId) {
		this.department = department;
		this.dataDictionaryByTypeId = dataDictionaryByTypeId;
	}

	/** minimal constructor */
	public Staff(DataDictionary dataDictionaryByStatus,
			DataDictionary dataDictionaryByTypeId, WagesStandard wagesStandard,
			String no, String name, String password, Date bornDate) {
		this.dataDictionaryByStatus = dataDictionaryByStatus;
		this.dataDictionaryByTypeId = dataDictionaryByTypeId;
		this.wagesStandard = wagesStandard;
		this.no = no;
		this.name = name;
		this.password = password;
		this.bornDate = bornDate;
	}

	/** full constructor */
	public Staff(DataDictionary dataDictionaryByAcademicdegreeId,
			DataDictionary dataDictionaryByStatus,
			DataDictionary dataDictionaryByEducationId,
			DataDictionary dataDictionaryByTypeId, WagesStandard wagesStandard,
			Position position, Department department, String no, String name,
			String password, String sex, Date bornDate, String address,
			String phone, String email, Set positionAdjustments,
			Set payWageses, Set cultivateRecords, Set attendances,
			Set staffMobilizations, Set cultivateStaffs, Set staffCertificates,
			Set quitStaffs, Set holidaies, Set personnelFileses,
			Set punishmentRewards, Set staffContracts) {
		this.dataDictionaryByAcademicdegreeId = dataDictionaryByAcademicdegreeId;
		this.dataDictionaryByStatus = dataDictionaryByStatus;
		this.dataDictionaryByEducationId = dataDictionaryByEducationId;
		this.dataDictionaryByTypeId = dataDictionaryByTypeId;
		this.wagesStandard = wagesStandard;
		this.position = position;
		this.department = department;
		this.no = no;
		this.name = name;
		this.password = password;
		this.sex = sex;
		this.bornDate = bornDate;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.positionAdjustments = positionAdjustments;
		this.payWageses = payWageses;
		this.cultivateRecords = cultivateRecords;
		this.attendances = attendances;
		this.staffMobilizations = staffMobilizations;
		this.cultivateStaffs = cultivateStaffs;
		this.staffCertificates = staffCertificates;
		this.quitStaffs = quitStaffs;
		this.holidaies = holidaies;
		this.personnelFileses = personnelFileses;
		this.punishmentRewards = punishmentRewards;
		this.staffContracts = staffContracts;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DataDictionary getDataDictionaryByAcademicdegreeId() {
		return this.dataDictionaryByAcademicdegreeId;
	}

	public void setDataDictionaryByAcademicdegreeId(
			DataDictionary dataDictionaryByAcademicdegreeId) {
		this.dataDictionaryByAcademicdegreeId = dataDictionaryByAcademicdegreeId;
	}

	public DataDictionary getDataDictionaryByStatus() {
		return this.dataDictionaryByStatus;
	}

	public void setDataDictionaryByStatus(DataDictionary dataDictionaryByStatus) {
		this.dataDictionaryByStatus = dataDictionaryByStatus;
	}

	public DataDictionary getDataDictionaryByEducationId() {
		return this.dataDictionaryByEducationId;
	}

	public void setDataDictionaryByEducationId(
			DataDictionary dataDictionaryByEducationId) {
		this.dataDictionaryByEducationId = dataDictionaryByEducationId;
	}

	public DataDictionary getDataDictionaryByTypeId() {
		return this.dataDictionaryByTypeId;
	}

	public void setDataDictionaryByTypeId(DataDictionary dataDictionaryByTypeId) {
		this.dataDictionaryByTypeId = dataDictionaryByTypeId;
	}

	public WagesStandard getWagesStandard() {
		return this.wagesStandard;
	}

	public void setWagesStandard(WagesStandard wagesStandard) {
		this.wagesStandard = wagesStandard;
	}

	public Position getPosition() {
		return this.position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBornDate() {
		return this.bornDate;
	}

	public void setBornDate(Date bornDate) {
		this.bornDate = bornDate;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set getPositionAdjustments() {
		return this.positionAdjustments;
	}

	public void setPositionAdjustments(Set positionAdjustments) {
		this.positionAdjustments = positionAdjustments;
	}

	public Set getPayWageses() {
		return this.payWageses;
	}

	public void setPayWageses(Set payWageses) {
		this.payWageses = payWageses;
	}

	public Set getCultivateRecords() {
		return this.cultivateRecords;
	}

	public void setCultivateRecords(Set cultivateRecords) {
		this.cultivateRecords = cultivateRecords;
	}

	public Set getAttendances() {
		return this.attendances;
	}

	public void setAttendances(Set attendances) {
		this.attendances = attendances;
	}

	public Set getStaffMobilizations() {
		return this.staffMobilizations;
	}

	public void setStaffMobilizations(Set staffMobilizations) {
		this.staffMobilizations = staffMobilizations;
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

	public Set getPersonnelFileses() {
		return this.personnelFileses;
	}

	public void setPersonnelFileses(Set personnelFileses) {
		this.personnelFileses = personnelFileses;
	}

	public Set getPunishmentRewards() {
		return this.punishmentRewards;
	}

	public void setPunishmentRewards(Set punishmentRewards) {
		this.punishmentRewards = punishmentRewards;
	}

	public Set getStaffContracts() {
		return this.staffContracts;
	}

	public void setStaffContracts(Set staffContracts) {
		this.staffContracts = staffContracts;
	}

}