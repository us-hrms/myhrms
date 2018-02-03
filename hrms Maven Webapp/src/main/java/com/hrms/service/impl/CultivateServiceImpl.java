package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Cultivate;
import com.hrms.entity.CultivateRecord;
import com.hrms.service.CultivateService;

@Service
public class CultivateServiceImpl implements  CultivateService{
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean updateCultivate(Cultivate cultivate) {
		// TODO Auto-generated method stub
		try {
			dao.update(cultivate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCultivate(Cultivate cultivate) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cultivate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cultivate getCultivate(Serializable id) {
		// TODO Auto-generated method stub
		return (Cultivate) dao.get(Cultivate.class, id);
	}

	@Override
	public List<Cultivate> getCultivates() {
		// TODO Auto-generated method stub
		return dao.find(new Cultivate());
	}

	@Override
	public List<Cultivate> getCultivates(Cultivate cultivate) {
		// TODO Auto-generated method stub
		return dao.find(cultivate);
	}
}
