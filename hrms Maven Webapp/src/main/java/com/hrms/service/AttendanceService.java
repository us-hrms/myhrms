package com.hrms.service;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.hrms.entity.Attendance;
import com.hrms.entity.Staff;
import com.hrms.page.Page;

public interface AttendanceService {
	
	/**
	 * 保存
	 * @param attendance
	 * @return
	 */
	Boolean  saveAttendance(Attendance attendance);
	
	/**
	 * 更新
	 * @param attendance
	 * @return
	 */
	Boolean updateAttendance(Attendance attendance);
	
	/**
	 * 删除
	 * @return
	 */
	Boolean deleteAttendance(Attendance attendance);

	/**
	 * 获得所有的对象
	 * @return
	 */
	List<Attendance> getAttendances();
	List<Attendance> getAttendancesOfStaff(Staff staff,Page page);
	
	/**
	 * 根据条件查
	 * @return
	 */
	List<Attendance> getAttendances(Attendance attendance);
	List<Attendance> getAttendancesOfStaff(Staff staff,Attendance attendance,Timestamp start,Timestamp stop,Page page);
	
	/**
	 * 根据id获得单个对象
	 * @param id
	 * @return
	 */
	Attendance getAttendance(Serializable id);
	
}
