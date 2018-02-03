package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffCertificate;

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
	/**
	 * ����������ѯ
	 * @param staffCertificate
	 * @return
	 */
	List<StaffCertificate> getStaffCertificates(StaffCertificate staffCertificate);
	/**
	 * ����id��õ�������
	 * @param id
	 * @return
	 */
	StaffCertificate getStaffCertificate(StaffCertificate id);
	

} 
