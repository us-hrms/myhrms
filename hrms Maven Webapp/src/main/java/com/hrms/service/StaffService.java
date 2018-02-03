package com.hrms.service;

import java.util.List;

import com.hrms.entity.Staff;

public interface StaffService {
	
	/**
	 * Ա����¼
	 * @param staff
	 * @return staff 
	 * 		�����ݵ�ʵ��  ��¼�ɹ� ����Ա����Ϣ��䵽staff��
	 * 		�����ݵ�ʵ�� ��¼ʧ��  
	 * 		null �����
	 */
	Staff login(Staff staff);
	
	/**
	 * ����
	 * @param staff
	 * @return
	 */
	Boolean saveStaff(Staff staff);
	
	/**
	 * ����
	 * @param staff
	 * @return
	 */
	Boolean updateStaff(Staff staff);
	
	/**
	 * �������Ա��
	 * @return Ա������
	 */
	List<Staff> getStaffs();
	

	/**
	 * ��Ա�������ڵ�����
	 * ��ѯ����Ա��
	 * @return Ա������
	 */
	List<Staff> getStaffs(Staff staff);
	
	
}
