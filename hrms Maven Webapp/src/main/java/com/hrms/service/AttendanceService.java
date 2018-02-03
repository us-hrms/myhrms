package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Attendance;

public interface AttendanceService {
	
	/**
	 * ����
	 * @param attendance
	 * @return
	 */
	Boolean  saveAttendance(Attendance attendance);
	
	/**
	 * ����
	 * @param attendance
	 * @return
	 */
	Boolean updateAttendance(Attendance attendance);
	
	/**
	 * ɾ��
	 * @return
	 */
	Boolean deleteAttendance(Attendance attendance);

	/**
	 * ������еĶ���
	 * @return
	 */
	List<Attendance> getAttendances();
	
	/**
	 * ����������
	 * @return
	 */
	List<Attendance> getAttendances(Attendance attendance);
	
	/**
	 * ����id��õ�������
	 * @param id
	 * @return
	 */
	Attendance getAttendance(Serializable id);
	
}
