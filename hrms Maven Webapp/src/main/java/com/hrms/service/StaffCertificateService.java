package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffCertificate;
import com.hrms.page.Page;

public interface StaffCertificateService {

	/**
	 * ����
	 * @param staffCertificate
	 * @return
	 */
	Boolean saveStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * ����
	 * @param staffCertificate
	 * @return
	 */
	Boolean updateStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * ɾ��
	 * @param staffCertificate
	 * @return
	 */
	Boolean deleteStaffCertificate(StaffCertificate staffCertificate);
	/**
	 * ������еĶ���
	 * @return
	 */
	List<StaffCertificate> getStaffCertificates();
	List<StaffCertificate> getStaffCertificates(Page page);
	/**
	 * ����������ѯ
	 * @param staffCertificate
	 * @return
	 */
	List<StaffCertificate> getStaffCertificates(StaffCertificate staffCertificate);
	List<StaffCertificate> getStaffCertificates(StaffCertificate staffCertificate,Page page);
	/**
	 * ����id��õ�������
	 * @param id
	 * @return
	 */
	StaffCertificate getStaffCertificate(StaffCertificate id);
	

} 
