package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.StaffMobilization;
import com.hrms.service.StaffMobilizationService;

@Service
public class StaffMobilizationServiceImpl implements StaffMobilizationService {

	@Autowired
	private Dao dao;
	@Override
	public Boolean saveStaffMobilization(StaffMobilization staffMobilization) {
		// TODO Auto-generated method stub
		try {
			dao.save(staffMobilization);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaffMobilization(StaffMobilization staffMobilization) {
		// TODO Auto-generated method stub
		try {
			dao.update(staffMobilization);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteStaffMobilization(StaffMobilization staffMobilization) {
		// TODO Auto-generated method stub
		try {
			dao.delete(staffMobilization);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<StaffMobilization> getStaffMobilizations() {
		// TODO Auto-generated method stub
		return dao.find(new StaffMobilization());
	}

	@Override
	public List<StaffMobilization> getStaffMobilizations(
			StaffMobilization staffMobilization) {
		// TODO Auto-generated method stub
		return dao.find(staffMobilization);
	}

	@Override
	public StaffMobilization getStaffMobilization(StaffMobilization id) {
		// TODO Auto-generated method stub
		return (StaffMobilization) dao.get(StaffMobilization.class, id);
	}

}
