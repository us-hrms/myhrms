package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.DataDictionary;

public interface DataDictionaryService {
	
	DataDictionary getDataDictionary(Serializable id);
	
	List<DataDictionary> getDataDictionarys();
	
	List<DataDictionary> getDataDictionarys(DataDictionary entity);
	
}
