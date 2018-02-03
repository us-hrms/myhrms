package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Certificate;
import com.hrms.service.CertificateService;

@Service
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private Dao dao;
	@Override
	public Boolean updateCertificate(Certificate certificate) {
		// TODO Auto-generated method stub
		try {
			dao.update(certificate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCertificate(Certificate certificate) {
		// TODO Auto-generated method stub
		try {
			dao.delete(certificate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Certificate getCertificate(Serializable id) {
		// TODO Auto-generated method stub
		return (Certificate) dao.get(Certificate.class, id);
	}

	@Override
	public List<Certificate> getCertificates() {
		// TODO Auto-generated method stub
		return dao.find(new Certificate());
	}

	@Override
	public List<Certificate> getCertificates(Certificate certificate) {
		// TODO Auto-generated method stub
		return dao.find(certificate);
	}

}
