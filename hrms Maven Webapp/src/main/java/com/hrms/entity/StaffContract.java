package com.hrms.entity;

import java.util.Date;

/**
 * StaffContract entity. @author MyEclipse Persistence Tools
 */

public class StaffContract implements java.io.Serializable {

	// Fields

	private Long id;
	private Staff staff;
	private String no;
	private Date start;
	private Date stop;
	private String post;
	private String content;
	private Date date;

	// Constructors

	/** default constructor */
	public StaffContract() {
	}

	/** full constructor */
	public StaffContract(Staff staff, String no, Date start, Date stop,
			String post, String content, Date date) {
		this.staff = staff;
		this.no = no;
		this.start = start;
		this.stop = stop;
		this.post = post;
		this.content = content;
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

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getStop() {
		return this.stop;
	}

	public void setStop(Date stop) {
		this.stop = stop;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}