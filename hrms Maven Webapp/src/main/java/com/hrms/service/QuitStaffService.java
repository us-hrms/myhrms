package com.hrms.service;

import java.util.List;

import com.hrms.entity.QuitStaff;
import com.hrms.page.Page;

public interface QuitStaffService {
      
	/**
	 * ������ְ��Ա
	 * @param quitStaff
	 * @return
	 */
	Boolean saveQuitStaff(QuitStaff quitStaff);
	/**
	 * ������ְ��Ա
	 * @param quitStaff
	 * @return
	 */
	Boolean updateQuitStaff(QuitStaff quitStaff);
	/**
	 * ɾ����ְ��Ա
	 * @param quitStaff
	 * @return
	 */
	Boolean deleteQuitStaff(QuitStaff quitStaff);
	/**
	 * ��ѯȫ����ְ��Ա
	 * @return
	 */
	List<QuitStaff> getQuitStaffs();
	List<QuitStaff> getQuitStaffs(Page page);
	/**
	 * ����������ѯ��ְ��Ա
	 * @param quitStaff
	 * @return
	 */
	List<QuitStaff> getQuitStaffs(QuitStaff quitStaff);
	List<QuitStaff> getQuitStaffs(QuitStaff quitStaff,Page page);
	/**
	 * ����id��ѯ������ְ��Ա
	 * @param id
	 * @return
	 */
	QuitStaff getQuitStaff(QuitStaff id);
}
