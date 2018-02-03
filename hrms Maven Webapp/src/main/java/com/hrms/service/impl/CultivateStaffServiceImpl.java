package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.CultivateStaff;
import com.hrms.service.CultivateStaffService;

@Service
public class CultivateStaffServiceImpl implements CultivateStaffService {
    
	@Autowired
	private Dao dao;
	
	@Override
	public List<CultivateStaff> getCultivateStaffs(CultivateStaff cultivateStaff) {
		// TODO Auto-generated method stub
		return dao.find(cultivateStaff);
	}
	
	@Override
	public Boolean updateCultivateStaff(CultivateStaff cultivateStaff) {
		// TODO Auto-generated method stub
		try {
			dao.update(cultivateStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCultivateStaff(CultivateStaff cultivateStaff) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cultivateStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CultivateStaff getCultivateStaff(Serializable id) {
		// TODO Auto-generated method stub
		return (CultivateStaff) dao.get(CultivateStaff.class, id);
	}

	@Override
	public List<CultivateStaff> getCultivateStaffs() {
		// TODO Auto-generated method stub
		return dao.find(new CultivateStaff());
	}
    
}
