package com.hrms.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.hrms.entity.PersonnelFiles;
import com.hrms.page.Page;

public interface PersonnelFilesService {
	 /**
     * ����ID��ѯ
     */
	PersonnelFiles getPersonnelFiles(Serializable id);
    /**
     * ��ѯȫ��
     */
	List<PersonnelFiles> getPersonnelFiles();
	List<PersonnelFiles> getPersonnelFiles(Page page);
	/**
	 * ����������ѯ
	 */
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles);
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles,Page page);
    List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles,Date start,Date end,Page page);
    /**
    * ����
    */
    Boolean updatePersonnelFiles(PersonnelFiles personnelFiles);
    /**
    * ɾ��
    */
    Boolean deletePersonnelFiles(PersonnelFiles personnelFiles);
}
