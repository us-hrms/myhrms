package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.PositionAdjustment;
import com.hrms.service.PositionAdjustmentService;

@Service
public class PositionAdjustmentServiceImpl implements PositionAdjustmentService {
	
	@Autowired
	private Dao dao;

	@Override
	public PositionAdjustment getPositionAdjustment(Serializable id) {
		// TODO Auto-generated method stub
		return (PositionAdjustment) dao.get(PositionAdjustment.class, id);
	}

	@Override
	public List<PositionAdjustment> getPositionAdjustment() {
		// TODO Auto-generated method stub
		return dao.find(new PositionAdjustment());
	}

	@Override
	public List<PositionAdjustment> getPositionAdjustment(
			PositionAdjustment positionAdjustment) {
		// TODO Auto-generated method stub
		return dao.find(positionAdjustment);
	}

	@Override
	public Boolean updatePositionAdjustment(
			PositionAdjustment positionAdjustment) {
		// TODO Auto-generated method stub
		try {
			dao.update(positionAdjustment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletePositionAdjustment(
			PositionAdjustment positionAdjustment) {
		// TODO Auto-generated method stub
		try {
			dao.delete(positionAdjustment);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}
    
	
}
