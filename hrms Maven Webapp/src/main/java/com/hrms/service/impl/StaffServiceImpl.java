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
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.StaffService;
import com.hrms.util.HQLHelper;
import com.hrms.util.MD5Util;

@Service
public class StaffServiceImpl implements StaffService {
    
	@Autowired
	private Dao dao;
	
	@Override
	public Staff login(Staff staff) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		//MD5加密
		staff.setPassword(MD5Util.getMD5(staff.getPassword()));
		params.add(" no = :no ");
		params.add(" password = :password ");
		params.add(" dataDictionaryByStatus.id != 14 ");
		StringBuffer param = HQLHelper.toHqlWhere(params);
		List<Staff> finds = dao.find("from Staff where "+param.toString(),staff);
		//判断是否为空
		if(!finds.isEmpty())
			return finds.get(0);
		return null;
	}

	@Override
	public List<Staff> getStaffs() {
		// TODO Auto-generated method stub
		String hql = "from Staff";
		List<Staff> list  = dao.find(hql);
		return list.size()>0?list:null;
	}

	@Override
	public List<Staff> getStaffs(Staff staff) {
		// TODO Auto-generated method stub
		List<Staff> list = dao.find(staff);
		return list.size()>0?list:null;
	}

	@Override
	public Boolean saveStaff(Staff staff) {
		// TODO Auto-generated method stub
		try {
			staff.setId(Long.valueOf(dao.save(staff).toString()));
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaff(Staff staff) {
		// TODO Auto-generated method stub
		try {
			dao.update(staff);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Staff> getStaffsByHql(Staff staff) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(staff!=null){
			if(staff.getDepartment().getId()!=null){
				params.add(" department.id = :did ");
				map.put("did", staff.getDepartment().getId());
			}
			if(staff.getDataDictionaryByTypeId().getId()!=null){
				params.add(" dataDictionaryByTypeId.id = :tid ");
				map.put("tid", staff.getDataDictionaryByTypeId().getId());
			}
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from Staff"+(params.size()>0?" where "+param.toString():""),map);
	}

	@Override
	public List<Staff> getStaffs(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from Staff",page);
	}

	@Override
	public List<Staff> getStaffs(Staff staff, Page page) {
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		//动态参数
		if(staff != null){
			//姓名
			if(staff.getName() != null){
				params.add(" name like :sname ");
				map.put("sname", "%"+staff.getName()+"%");
			}
			//工号
			if(staff.getNo() != null){
				params.add(" no like :sno ");
				map.put("sno", "%"+staff.getNo()+"%");
			}
			//状态
			if(staff.getDataDictionaryByStatus().getId() != null && staff.getDataDictionaryByStatus().getId() != -1){
				params.add(" dataDictionaryByStatus.id = :sdid ");
				map.put("sdid", staff.getDataDictionaryByStatus().getId());
			}
			Department department = staff.getDepartment();
			//部门id
			if(department != null && department.getId() != null && department.getId() != -1){
				params.add(" department.id = :did ");
				map.put("did", department.getId());
			}
			Position position = staff.getPosition();
			//职位id
			if(position != null && position.getId() != null && position.getId() != -1){
				params.add(" position.id = :pid ");
				map.put("pid", position.getId());
			}
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);

		return dao.find("from Staff "+(params.size()>0?" where " + param.toString():""), map, page);
	}
}
