package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.Department;
import com.hrms.page.Page;

public interface DepartmentService {
	   /**
	    * ����ID��ѯ
	    */
		Department getDepartment(Serializable id);
	   /**
	    * ��������ѯ
	    * @return
	    */
       List<Department> getDepartments(Department department);
       List<Department> getDepartments(Department department,Page page);
       List<Department> getDepartments(Department department,Integer count,Page page);
       /**
        * ��ѯȫ��
        */
       List<Department> getDepartments();
       List<Department> getDepartments(Page page);
       /**
        * ����
        */
       Boolean updateDepartment(Department department);
       /**
        * ɾ��
        */
       Boolean deleteDepartment(Department department);
}
