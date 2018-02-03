package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Staff;
import com.hrms.service.StaffService;
import com.hrms.util.MD5Util;

@Service
public class StaffServiceImpl implements StaffService {
    
	@Autowired
	private Dao dao;
	
	@Override
	public Staff login(Staff staff) {
		// TODO Auto-generated method stub
		try {
			//MD5º”√‹
			staff.setPassword(MD5Util.getMD5(staff.getPassword()));
			List<Staff> finds = dao.find(staff);
			//≈–∂œ «∑ÒŒ™ø’
			if(!finds.isEmpty())
				return finds.get(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Staff> getStaffs() {
		// TODO Auto-generated method stub
		String hql = "from Staff";
		List<Staff> list  = dao.find(hql);
		return list.size()>0?list:null;
	}

	@Override
	public List<Staff> getStaffs(Staff staff) {
		// TODO Auto-generated method stub
		List<Staff> list = dao.find(staff);
		return list.size()>0?list:null;
	}

	@Override
	public Boolean saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		try {
			staff.setId(Long.valueOf(dao.save(staff).toString()));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		try {
			dao.update(staff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
