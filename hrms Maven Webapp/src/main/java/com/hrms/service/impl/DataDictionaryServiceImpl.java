package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.DataDictionary;
import com.hrms.service.DataDictionaryService;

@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	@Autowired
	private Dao dao;
	
	

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public DataDictionary getDataDictionary(Serializable id) {
		// TODO Auto-generated method stub
		return (DataDictionary) dao.get(DataDictionary.class, id);
	}

	@Override
	public List<DataDictionary> getDataDictionarys() {
		// TODO Auto-generated method stub
		return dao.find(new DataDictionary());
	}

	@Override
	public List<DataDictionary> getDataDictionarys(DataDictionary entity) {
		// TODO Auto-generated method stub
		return dao.find(entity);
	}
	
	
}
