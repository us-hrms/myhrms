package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.WagesStandard;
import com.hrms.service.WagesStandardService;

@Service
public class WagesStandardServiceImpl implements WagesStandardService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean saveWagesStandard(WagesStandard wagesStandard) {
		// TODO Auto-generated method stub
		try {
			dao.save(wagesStandard);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateWagesStandard(WagesStandard wagesStandard) {
		// TODO Auto-generated method stub
		try {
			dao.update(wagesStandard);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteWagesStandard(WagesStandard wagesStandard) {
		// TODO Auto-generated method stub
		try {
			dao.delete(wagesStandard);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<WagesStandard> getWagesStandards() {
		// TODO Auto-generated method stub
		return dao.find(new WagesStandard());
	}

	@Override
	public List<WagesStandard> getWagesStandards(WagesStandard wagesStandard) {
		// TODO Auto-generated method stub
		return dao.find(wagesStandard);
	}

	@Override
	public WagesStandard getWagesStandard(WagesStandard id) {
		// TODO Auto-generated method stub
		return (WagesStandard) dao.get(WagesStandard.class, id);
	}
	
}
