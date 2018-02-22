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
import com.hrms.entity.StaffContract;
import com.hrms.page.Page;
import com.hrms.service.StaffContractService;
import com.hrms.util.HQLHelper;

@Service
public class StaffContractServiceImpl implements StaffContractService {
	@Autowired
	private Dao dao;
	@Override
	public Boolean saveStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.save(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.update(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteStaffContract(StaffContract staffContract) {
		// TODO Auto-generated method stub
		try {
			dao.delete(staffContract);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<StaffContract> getStaffContracts() {
		// TODO Auto-generated method stub
		return dao.find(new StaffContract());
	}
	@Override
	public List<StaffContract> getStaffContracts(StaffContract staffContract) {
		// TODO Auto-generated method stub
		return dao.find(staffContract);
	}
	@Override
	public StaffContract getStaffContract(StaffContract id) {
		// TODO Auto-generated method stub
		return (StaffContract) dao.get(StaffContract.class,id);
	}

	@Override
	public List<StaffContract> getStaffContracts(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from StaffContract order by date desc ",page);
	}

	@Override
	public List<StaffContract> getStaffContracts(StaffContract staffContract,
			Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		//动态参数拼接
		if(staffContract != null){
			if(staffContract.getNo() != null){
				params.add(" no like :no ");
				map.put("no", "%"+staffContract.getNo()+"%");
			}
			Staff staff = staffContract.getStaff();
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
		StringBuffer param = HQLHelper.toHqlWhere(params);

		return dao.find("from StaffContract "+(params.size()>0?" where " + param.toString():"")+" order by date desc ", map, page);
	}
}
