package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.QuitStaff;
import com.hrms.service.QuitStaffService;

@Service
public class QuitStaffServiceImpl implements QuitStaffService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean saveQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.save(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.update(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.delete(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<QuitStaff> getQuitStaffs() {
		// TODO Auto-generated method stub
		return dao.find(new QuitStaff());
	}

	@Override
	public List<QuitStaff> getQuitStaffs(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		return dao.find(quitStaff);
	}

	@Override
	public QuitStaff getQuitStaff(QuitStaff id) {
		// TODO Auto-generated method stub
		return (QuitStaff) dao.get(QuitStaff.class, id);
	}
	
}
