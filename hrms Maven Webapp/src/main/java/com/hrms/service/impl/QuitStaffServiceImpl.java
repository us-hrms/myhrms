package com.hrms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Department;
import com.hrms.entity.Position;
import com.hrms.entity.QuitStaff;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.QuitStaffService;
import com.hrms.util.HQLHelper;

@Service
public class QuitStaffServiceImpl implements QuitStaffService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean saveQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.save(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.update(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteQuitStaff(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		try {
			dao.delete(quitStaff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<QuitStaff> getQuitStaffs() {
		// TODO Auto-generated method stub
		return dao.find(new QuitStaff());
	}

	@Override
	public List<QuitStaff> getQuitStaffs(QuitStaff quitStaff) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		if(quitStaff != null){
			Staff staff = quitStaff.getStaff();
			if(staff!=null){
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
				Department department = staff.getDepartment();
				//部门id
				if(department != null && department.getId() != null && department.getId() != -1){
					params.add(" staff.department.id = :did ");
					map.put("did", department.getId());
				}
				Position position = staff.getPosition();
				//职位id
				if(position != null && position.getId() != null && position.getId() != -1){
					params.add(" staff.position.id = :pid ");
					map.put("pid", position.getId());
				}
			}
		}
		if(quitStaff.getDataDictionary()!=null && quitStaff.getDataDictionary().getId() != -1){
			params.add(" dataDictionary.id = :ddid ");
			map.put("ddid", quitStaff.getDataDictionary().getId());
			
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		if(params.size()>0)
			return dao.find("from QuitStaff where "+params.toString(), map);
		else
			return dao.find(quitStaff);
	}

	@Override
	public QuitStaff getQuitStaff(QuitStaff id) {
		// TODO Auto-generated method stub
		return (QuitStaff) dao.get(QuitStaff.class, id);
	}

	@Override
	public List<QuitStaff> getQuitStaffs(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from QuitStaff order by time desc ", page);
	}

	@Override
	public List<QuitStaff> getQuitStaffs(QuitStaff quitStaff, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		if(quitStaff != null){
			Staff staff = quitStaff.getStaff();
			if(staff!=null){
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
				Department department = staff.getDepartment();
				//部门id
				if(department != null && department.getId() != null && department.getId() != -1){
					params.add(" staff.department.id = :did ");
					map.put("did", department.getId());
				}
				Position position = staff.getPosition();
				//职位id
				if(position != null && position.getId() != null && position.getId() != -1){
					params.add(" staff.position.id = :pid ");
					map.put("pid", position.getId());
				}
			}
			if(quitStaff.getDataDictionary()!=null && quitStaff.getDataDictionary().getId() != -1){
				params.add(" dataDictionary.id = :ddid ");
				map.put("ddid", quitStaff.getDataDictionary().getId());
				
			}
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from QuitStaff "+(params.size()>0?" where " + param.toString():"")+" order by time desc ", map, page);
	}
	
}
