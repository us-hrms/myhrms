package com.hrms.service;

import java.util.List;

import com.hrms.entity.QuitStaff;
import com.hrms.page.Page;

public interface QuitStaffService {
      
	/**
	 * 保存离职人员
	 * @param quitStaff
	 * @return
	 */
	Boolean saveQuitStaff(QuitStaff quitStaff);
	/**
	 * 更新离职人员
	 * @param quitStaff
	 * @return
	 */
	Boolean updateQuitStaff(QuitStaff quitStaff);
	/**
	 * 删除离职人员
	 * @param quitStaff
	 * @return
	 */
	Boolean deleteQuitStaff(QuitStaff quitStaff);
	/**
	 * 查询全部离职人员
	 * @return
	 */
	List<QuitStaff> getQuitStaffs();
	List<QuitStaff> getQuitStaffs(Page page);
	/**
	 * 根据条件查询离职人员
	 * @param quitStaff
	 * @return
	 */
	List<QuitStaff> getQuitStaffs(QuitStaff quitStaff);
	List<QuitStaff> getQuitStaffs(QuitStaff quitStaff,Page page);
	/**
	 * 根据id查询单个离职人员
	 * @param id
	 * @return
	 */
	QuitStaff getQuitStaff(QuitStaff id);
}
