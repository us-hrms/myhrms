package com.hrms.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.hrms.entity.Attendance;
import com.hrms.entity.Staff;
import com.hrms.page.Page;

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
	List<Attendance> getAttendancesOfStaff(Staff staff,Page page);
	
	/**
	 * ����������
	 * @return
	 */
	List<Attendance> getAttendances(Attendance attendance);
	List<Attendance> getAttendancesOfStaff(Staff staff,Attendance attendance,Timestamp start,Timestamp stop,Page page);
	
	/**
	 * ����id��õ�������
	 * @param id
	 * @return
	 */
	Attendance getAttendance(Serializable id);
	
}
