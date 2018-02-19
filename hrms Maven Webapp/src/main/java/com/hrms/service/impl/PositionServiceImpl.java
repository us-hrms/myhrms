package com.hrms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Position;
import com.hrms.page.Page;
import com.hrms.service.PositionService;
import com.hrms.util.HQLHelper;

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

	@Override
	public List<Position> getPositions(Position position, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(position != null){
			if(position.getName() != null){
				params.add(" name like :name ");
				map.put("name", "%"+position.getName()+"%");
			}
			if(position.getDepartment()!=null && position.getDepartment().getId()!=null){
				params.add(" department.id = :id ");
				map.put("id", position.getId());
			}
		}
		//合成条件语句
		StringBuffer param = HQLHelper.toHqlWhere(params);
		dao.find("from Position "+(params.size()>0?" where "+param.toString():""), map,page);
		return null;
	} 
    
	
}
