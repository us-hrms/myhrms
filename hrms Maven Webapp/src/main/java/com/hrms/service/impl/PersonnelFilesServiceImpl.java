package com.hrms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Department;
import com.hrms.entity.PersonnelFiles;
import com.hrms.entity.Position;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.PersonnelFilesService;
import com.hrms.util.HQLHelper;

@Service
public class PersonnelFilesServiceImpl implements PersonnelFilesService {
    
	@Autowired
	private Dao dao;

	@Override
	public PersonnelFiles getPersonnelFiles(Serializable id) {
		// TODO Auto-generated method stub
		return (PersonnelFiles) dao.get(PersonnelFiles.class, id);
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiles() {
		// TODO Auto-generated method stub
		return dao.find(new PersonnelFiles());
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		return dao.find(personnelFiles);
	}

	@Override
	public Boolean updatePersonnelFiles(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		try {
			dao.update(personnelFiles);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletePersonnelFiles(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		try {
			dao.delete(personnelFiles);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiles(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from PersonnelFiles order by date desc ",page);
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiless(
			PersonnelFiles personnelFiles, Page page) {
		return getPersonnelFiless(personnelFiles,null,null,page);
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiless(
			PersonnelFiles personnelFiles, Date start, Date end, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		//动态参数录入
		if(personnelFiles!=null){
			if(personnelFiles.getNo()!=null){
				params.add(" no like :no ");
				map.put("no", "%"+personnelFiles.getNo()+"%");
			}
			Staff staff = personnelFiles.getStaff();
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
				//状态
				if(staff.getDataDictionaryByStatus().getId() != null && staff.getDataDictionaryByStatus().getId() != -1){
					params.add(" staff.dataDictionaryByStatus.id = :sdid ");
					map.put("sdid", staff.getDataDictionaryByStatus().getId());
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
		if(start != null){
			params.add(" date >= :start ");
			map.put("start", start);
		}
		if(end != null){
			params.add(" data <= :end ");
			map.put("end", end);
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from PersonnelFiles "+(params.size()>0?" where " + param.toString():"")+" order by date desc ", map, page);
	}
	
	
}
