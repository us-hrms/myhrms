package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Department;
import com.hrms.page.Page;

public interface DepartmentService {
	   /**
	    * 根据ID查询
	    */
		Department getDepartment(Serializable id);
	   /**
	    * 按条件查询
	    * @return
	    */
       List<Department> getDepartments(Department department);
       List<Department> getDepartments(Department department,Page page);
       List<Department> getDepartments(Department department,Integer count,Page page);
       /**
        * 查询全部
        */
       List<Department> getDepartments();
       List<Department> getDepartments(Page page);
       /**
        * 更新
        */
       Boolean updateDepartment(Department department);
       /**
        * 删除
        */
       Boolean deleteDepartment(Department department);
}
