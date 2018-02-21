package com.hrms.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hrms.entity.PersonnelFiles;
import com.hrms.page.Page;

public interface PersonnelFilesService {
	 /**
     * 根据ID查询
     */
	PersonnelFiles getPersonnelFiles(Serializable id);
    /**
     * 查询全部
     */
	List<PersonnelFiles> getPersonnelFiles();
	List<PersonnelFiles> getPersonnelFiles(Page page);
	/**
	 * 根据条件查询
	 */
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles);
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles,Page page);
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles,Date start,Date end,Page page);
    /**
    * 更新
    */
    Boolean updatePersonnelFiles(PersonnelFiles personnelFiles);
    /**
    * 删除
    */
    Boolean deletePersonnelFiles(PersonnelFiles personnelFiles);
}
