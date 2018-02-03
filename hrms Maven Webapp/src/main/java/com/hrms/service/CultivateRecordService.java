package com.hrms.service;

import java.io.Serializable;
import java.util.List;

import com.hrms.entity.CultivateRecord;

public interface CultivateRecordService {
	
	/**
	 * 更新
	 * @param cultivateRecord
	 * @return
	 */
	Boolean update(CultivateRecord cultivateRecord);
	
	/**
	 * 删除
	 * @param cultivateRecord
	 */
	Boolean deleteCultivateRecord(CultivateRecord cultivateRecord);
	
	/**
	 * 根据id获得一个CultivateRecord
	 * @param id
	 * @return
	 */
	CultivateRecord getCultivateRecord(Serializable id);
	
	
	/**
	 * 获得所有CultivateRecord
	 * @return
	 */
	List<CultivateRecord> getCultivateRecords();
	
	
	/**
	 * 按条件查询
	 * @param cultivateRecord
	 * @return
	 */
	List<CultivateRecord> getCultivateRecords(CultivateRecord cultivateRecord);
}
