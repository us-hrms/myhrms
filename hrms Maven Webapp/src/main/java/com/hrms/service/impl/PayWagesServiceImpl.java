package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.PayWages;
import com.hrms.service.PayWagesService;

@Service
public class PayWagesServiceImpl implements PayWagesService {
    
	@Autowired
	private Dao dao;

	@Override
	public PayWages getPayWages(Serializable id) {
		// TODO Auto-generated method stub
		return (PayWages) dao.get(PayWages.class, id);
	}

	@Override
	public List<PayWages> getPayWagess() {
		// TODO Auto-generated method stub
		return dao.find(new PayWages());
	}

	@Override
	public List<PayWages> getPayWagess(PayWages payWages) {
		// TODO Auto-generated method stub
		return dao.find(payWages);
	}

	@Override
	public Boolean updatePayWages(PayWages payWages) {
		// TODO Auto-generated method stub
		try {
			dao.update(payWages);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletepayWages(PayWages payWages) {
		// TODO Auto-generated method stub
		try {
			dao.find(payWages);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}
	
}
