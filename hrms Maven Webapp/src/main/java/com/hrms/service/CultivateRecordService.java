package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.CultivateRecord;

public interface CultivateRecordService {
	
	/**
	 * ����
	 * @param cultivateRecord
	 * @return
	 */
	Boolean update(CultivateRecord cultivateRecord);
	
	/**
	 * ɾ��
	 * @param cultivateRecord
	 */
	Boolean deleteCultivateRecord(CultivateRecord cultivateRecord);
	
	/**
	 * ����id���һ��CultivateRecord
	 * @param id
	 * @return
	 */
	CultivateRecord getCultivateRecord(Serializable id);
	
	
	/**
	 * �������CultivateRecord
	 * @return
	 */
	List<CultivateRecord> getCultivateRecords();
	
	
	/**
	 * ��������ѯ
	 * @param cultivateRecord
	 * @return
	 */
	List<CultivateRecord> getCultivateRecords(CultivateRecord cultivateRecord);
}
