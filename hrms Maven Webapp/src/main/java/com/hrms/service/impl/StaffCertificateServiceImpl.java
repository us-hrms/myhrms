package com.hrms.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Certificate;
import com.hrms.entity.Department;
import com.hrms.entity.Position;
import com.hrms.entity.Staff;
import com.hrms.entity.StaffCertificate;
import com.hrms.page.Page;
import com.hrms.service.StaffCertificateService;
import com.hrms.util.HQLHelper;

@Service
public class StaffCertificateServiceImpl implements StaffCertificateService {
	@Autowired
	private Dao dao;

	@Override
	public Boolean saveStaffCertificate(StaffCertificate staffCertificate) {
		// TODO Auto-generated method stub
		try {
			dao.save(staffCertificate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean updateStaffCertificate(StaffCertificate staffCertificate) {
		// TODO Auto-generated method stub
		try {
			dao.update(staffCertificate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public Boolean deleteStaffCertificate(StaffCertificate staffCertificate) {
		// TODO Auto-generated method stub
		try {
			dao.delete(staffCertificate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<StaffCertificate> getStaffCertificates() {
		// TODO Auto-generated method stub
		return dao.find(new StaffCertificate());
	}

	@Override
	public List<StaffCertificate> getStaffCertificates(
			StaffCertificate staffCertificate) {
		// TODO Auto-generated method stub
		return dao.find(staffCertificate);
	}

	@Override
	public StaffCertificate getStaffCertificate(StaffCertificate id) {
		// TODO Auto-generated method stub
		return (StaffCertificate) dao.get(StaffCertificate.class, id);
	}

	@Override
	public List<StaffCertificate> getStaffCertificates(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from StaffCertificate order by date desc ",page);
	}

	@Override
	public List<StaffCertificate> getStaffCertificates(
			StaffCertificate staffCertificate, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//存储hql条件语句
		Map<String, Object> map = new HashMap<String, Object>();//存储hql中要填入的值
		if(staffCertificate != null){
			if(staffCertificate.getNo() != null){
				params.add(" no like :no ");
				map.put("no", "%"+staffCertificate.getNo()+"%");
			}
			Staff staff = staffCertificate.getStaff();
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
			Certificate certificate = staffCertificate.getCertificate();
			if(certificate != null){
				if(certificate.getId() != null && certificate.getId() != -1){
					params.add(" certificate.id = :cid ");
					map.put("cid", certificate.getId());
				}
			}
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from StaffCertificate "+(params.size()>0?" where " + param.toString():"")+" order by date desc ", map, page);
	}
    
}
