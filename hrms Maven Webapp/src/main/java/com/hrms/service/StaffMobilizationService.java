package com.hrms.service;

import java.util.List;

import com.hrms.entity.StaffMobilization;

public interface StaffMobilizationService {
	/**
	 * 保存
	 * @param staffMobilization
	 * @return
	 */
	Boolean  saveStaffMobilization(StaffMobilization staffMobilization);
	
	/**
	 * 更新
	 * @param staffMobilization
	 * @return
	 */
	Boolean updateStaffMobilization(StaffMobilization staffMobilization);
	
	/**
	 * 删除
	 * @return
	 */
	Boolean deleteStaffMobilization(StaffMobilization staffMobilization);

	/**
	 * 获得所有的对象
	 * @return
	 */
	List<StaffMobilization> getStaffMobilizations();
	
	/**
	 * 根据条件查
	 * @return
	 */
	List<StaffMobilization> getStaffMobilizations(StaffMobilization staffMobilization);
	
	/**
	 * 根据id获得单个对象
	 * @param id
	 * @return
	 */
	StaffMobilization getStaffMobilization(StaffMobilization id);
}
