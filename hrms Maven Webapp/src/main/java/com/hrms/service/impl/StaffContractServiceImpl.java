package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.StaffContract;
import com.hrms.service.StaffContractService;

@Service
public class StaffContractServiceImpl implements StaffContractService {
	@Autowired
	private Dao dao;
	@Override
	public Boolean saveStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.save(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.update(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.delete(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<StaffContract> getStaffContracts() {
		// TODO Auto-generated method stub
		return dao.find(new StaffContract());
	}
	@Override
	public List<StaffContract> getStaffContracts(StaffContract staffContract) {
		// TODO Auto-generated method stub
		return dao.find(staffContract);
	}
	@Override
	public StaffContract getStaffContract(StaffContract id) {
		// TODO Auto-generated method stub
		return (StaffContract) dao.get(StaffContract.class,id);
	}
}
