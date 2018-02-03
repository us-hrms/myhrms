package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Attendance;
import com.hrms.service.AttendanceService;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.update(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.delete(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Attendance> getAttendances() {
		// TODO Auto-generated method stub
		return dao.find(new Attendance());
	}

	@Override
	public List<Attendance> getAttendances(Attendance attendance) {
		// TODO Auto-generated method stub
		return dao.find(attendance);
	}

	@Override
	public Attendance getAttendance(Serializable id) {
		// TODO Auto-generated method stub
		return (Attendance) dao.get(Attendance.class, id);
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public Boolean saveAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.save(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
	
	
}
