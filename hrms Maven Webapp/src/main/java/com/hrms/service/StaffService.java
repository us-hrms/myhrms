package com.hrms.service;

import java.util.List;

import com.hrms.entity.Staff;

public interface StaffService {
	
	/**
	 * 员工登录
	 * @param staff
	 * @return staff 
	 * 		有数据的实例  登录成功 并将员工信息填充到staff中
	 * 		无数据的实例 登录失败  
	 * 		null 或出错
	 */
	Staff login(Staff staff);
	
	/**
	 * 保存
	 * @param staff
	 * @return
	 */
	Boolean saveStaff(Staff staff);
	
	/**
	 * 更新
	 * @param staff
	 * @return
	 */
	Boolean updateStaff(Staff staff);
	
	/**
	 * 获得所有员工
	 * @return 员工集合
	 */
	List<Staff> getStaffs();
	

	/**
	 * 按员工对象内的条件
	 * 查询所有员工
	 * @return 员工集合
	 */
	List<Staff> getStaffs(Staff staff);
	
	
}
