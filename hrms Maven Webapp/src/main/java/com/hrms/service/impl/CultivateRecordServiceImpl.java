package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.CultivateRecord;
import com.hrms.service.CultivateRecordService;

@Service
public class CultivateRecordServiceImpl  implements CultivateRecordService{
	
	@Autowired
	private Dao dao;

	@Override
	public Boolean update(CultivateRecord cultivateRecord) {
		// TODO Auto-generated method stub
		try {
			dao.update(cultivateRecord);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public Boolean deleteCultivateRecord(CultivateRecord cultivateRecord) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cultivateRecord);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public CultivateRecord getCultivateRecord(Serializable id) {
		// TODO Auto-generated method stub
		return (CultivateRecord) dao.get(CultivateRecord.class, id);
	}

	@Override
	public List<CultivateRecord> getCultivateRecords() {
		// TODO Auto-generated method stub
		return dao.find(new CultivateRecord());
	}

	@Override
	public List<CultivateRecord> getCultivateRecords(
			CultivateRecord cultivateRecord) {
		// TODO Auto-generated method stub
		return dao.find(cultivateRecord);
	}
	
	
	
}
