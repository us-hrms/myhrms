package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffCertificate;
import com.hrms.page.Page;

public interface StaffCertificateService {

	/**
	 * 保存
	 * @param staffCertificate
	 * @return
	 */
	Boolean saveStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * 更新
	 * @param staffCertificate
	 * @return
	 */
	Boolean updateStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * 删除
	 * @param staffCertificate
	 * @return
	 */
	Boolean deleteStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * 获得所有的对象
	 * @return
	 */
	List<StaffCertificate> getStaffCertificates();
	List<StaffCertificate> getStaffCertificates(Page page);
	/**
	 * 根据条件查询
	 * @param staffCertificate
	 * @return
	 */
	List<StaffCertificate> getStaffCertificates(StaffCertificate staffCertificate);
	List<StaffCertificate> getStaffCertificates(StaffCertificate staffCertificate,Page page);
	/**
	 * 根据id获得单个对象
	 * @param id
	 * @return
	 */
	StaffCertificate getStaffCertificate(StaffCertificate id);
	

} 
