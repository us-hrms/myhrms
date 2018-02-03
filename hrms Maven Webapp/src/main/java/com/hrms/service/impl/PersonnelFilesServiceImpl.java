package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.PersonnelFiles;
import com.hrms.service.PersonnelFilesService;

@Service
public class PersonnelFilesServiceImpl implements PersonnelFilesService {
    
	@Autowired
	private Dao dao;

	@Override
	public PersonnelFiles getPersonnelFiles(Serializable id) {
		// TODO Auto-generated method stub
		return (PersonnelFiles) dao.get(PersonnelFiles.class, id);
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiles() {
		// TODO Auto-generated method stub
		return dao.find(new PersonnelFiles());
	}

	@Override
	public List<PersonnelFiles> getPersonnelFiless(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		return dao.find(personnelFiles);
	}

	@Override
	public Boolean updatePersonnelFiles(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		try {
			dao.update(personnelFiles);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletePersonnelFiles(PersonnelFiles personnelFiles) {
		// TODO Auto-generated method stub
		try {
			dao.delete(personnelFiles);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	
}
