package com.hrms.entity;

import java.util.Date;

/**
 * StaffCertificate entity. @author MyEclipse Persistence Tools
 */

public class StaffCertificate implements java.io.Serializable {

	// Fields

	private Long id;
	private Certificate certificate;
	private CultivateStaff cultivateStaff;
	private Staff staff;
	private String no;
	private Date date;
	private String photo;

	// Constructors

	/** default constructor */
	public StaffCertificate() {
	}

	/** minimal constructor */
	public StaffCertificate(Staff staff, String no, Date date) {
		this.staff = staff;
		this.no = no;
		this.date = date;
	}

	/** full constructor */
	public StaffCertificate(Certificate certificate,
			CultivateStaff cultivateStaff, Staff staff, String no, Date date) {
		this.certificate = certificate;
		this.cultivateStaff = cultivateStaff;
		this.staff = staff;
		this.no = no;
		this.date = date;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Certificate getCertificate() {
		return this.certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public CultivateStaff getCultivateStaff() {
		return this.cultivateStaff;
	}

	public void setCultivateStaff(CultivateStaff cultivateStaff) {
		this.cultivateStaff = cultivateStaff;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
	

}