package com.hrms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Department;
import com.hrms.entity.Position;
import com.hrms.entity.PositionAdjustment;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.PositionAdjustmentService;
import com.hrms.util.HQLHelper;

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
	public List<PositionAdjustment> getPositionAdjustments() {
		// TODO Auto-generated method stub
		return dao.find(new PositionAdjustment());
	}

	@Override
	public List<PositionAdjustment> getPositionAdjustments(
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

	@Override
	public List<PositionAdjustment> getPositionAdjustments(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from PositionAdjustment order by date desc ",page);
	}

	@Override
	public List<PositionAdjustment> getPositionAdjustments(
			PositionAdjustment positionAdjustment, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		//动态条件语句集合
		if(positionAdjustment != null){//判空
			Position position = positionAdjustment.getPositionByAfter();
			if(position!=null){
				Department department = position.getDepartment();
				//部门id
				if(department != null && department.getId() != null && department.getId() != -1){
					params.add(" positionByAfter.department.id = :did ");
					map.put("did", department.getId());
				}
				//职位名称
				if(position.getName() != null){
					params.add(" positionByAfter.name like :pname ");
					map.put("pname", "%"+position.getName()+"%");
				}
				//职位id
				if(position.getId() != null && position.getId() != -1){
					params.add(" positionByAfter.id = :pid ");
					map.put("pid", position.getId());
				}
			}
			Staff staff = positionAdjustment.getStaff();
			if(staff != null){
				//姓名
				if(staff.getName() != null){
					params.add(" staff.name like :sname ");
					map.put("sname", "%"+staff.getName()+"%");
				}
				//工号
				if(staff.getNo() != null){
					params.add(" staff.no like :sno ");
					map.put("sno", "%"+staff.getNo()+"%");
				}
			}
		}
		//拼接条件语句
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from PositionAdjustment "+(params.size()>0?" where "+param.toString():"")+" order by date desc ", map, page);
	}
    
	
}
