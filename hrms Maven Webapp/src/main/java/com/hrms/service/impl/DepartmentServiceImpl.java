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
import com.hrms.page.Page;
import com.hrms.service.DepartmentService;
import com.hrms.util.HQLHelper;

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

	@Override
	public List<Department> getDepartments(Department department, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		//参数拼接
		if(department!=null){
			if(department.getId()!=null){
				params.add(" id = :id ");
				map.put("id", department.getId());
			}
			if(department.getName()!=null){
				params.add(" name like :name ");
				map.put("name", "%"+department.getName()+"%");
			}
		}
		//合成string
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from Department "+(params.size()>0?" where "+param.toString():""),map,page);
	}

	@Override
	public List<Department> getDepartments(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from Department where name != '无部门'", page);
	}

	@Override
	public List<Department> getDepartments(Department department,
			Integer count, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		//参数拼接
		if(department!=null){
			if(department.getId()!=null){
				params.add(" id = :id ");
				map.put("id", department.getId());
			}
			if(department.getName()!=null){
				params.add(" name like :name ");
				map.put("name", "%"+department.getName()+"%");
			}
			if(count != null && count != -1){
				//params.add(" id in (select department.id from Staff group by department.id having count(*) between 5 and 50 ");
				params.add(" staffs.size between :min and :max ");
				map.put("min", (count-1)*50 + 1);
				map.put("max",count==4?Integer.MAX_VALUE:count*50);
			}
		}
		//合成string
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from Department where name != '无部门' "+(params.size()>0?" and "+param.toString():""),map,page);
	}
    
}
