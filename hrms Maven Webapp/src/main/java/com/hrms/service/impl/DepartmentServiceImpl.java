package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Department;
import com.hrms.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements  DepartmentService{
    
	@Autowired
	private Dao dao;
	
	@Override
	public Department getDepartment(Serializable id) {
		// TODO Auto-generated method stub
		return (Department) dao.get(Department.class, id);
	}

	@Override
	public List<Department> getDepartments(Department department) {
		// TODO Auto-generated method stub
		return dao.find(department);
	}

	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return dao.find(new Department());
	}

	@Override
	public Boolean updateDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			dao.update(department);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteDepartment(Department department) {
		// TODO Auto-generated method stub
		try {
			dao.delete(department);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}
    
}
