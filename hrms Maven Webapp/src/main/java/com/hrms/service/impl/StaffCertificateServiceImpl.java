package com.hrms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.StaffCertificate;
import com.hrms.service.StaffCertificateService;

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
    
}
