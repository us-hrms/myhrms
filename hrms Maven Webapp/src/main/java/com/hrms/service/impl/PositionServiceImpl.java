package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Position;
import com.hrms.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean savePosition(Position position) {
		// TODO Auto-generated method stub
		try {
			dao.save(position);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updatePosition(Position position) {
		// TODO Auto-generated method stub
		try {
			dao.update(position);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deletePosition(Position position) {
		// TODO Auto-generated method stub
		try {
			dao.delete(position);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Position> getPositions() {
		// TODO Auto-generated method stub
		return dao.find(new Position());
	}

	@Override
	public List<Position> getPositions(Position position) {
		// TODO Auto-generated method stub
		return dao.find(position);
	}

	@Override
	public Position getPosition(Position id) {
		// TODO Auto-generated method stub
		return (Position) dao.get(Position.class, id);
	} 
    
	
}
