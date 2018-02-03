package com.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Holiday;
import com.hrms.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {
    
	@Autowired
	private Dao dao; 
	
	@Override
	public Holiday getHoliday(Serializable id) {
		// TODO Auto-generated method stub
		return (Holiday) dao.get(Holiday.class, id);
	}

	@Override
	public List<Holiday> getHolidays() {
		// TODO Auto-generated method stub
		return dao.find(new Holiday());
	}

	@Override
	public List<Holiday> getHolidays(Holiday holiday) {
		// TODO Auto-generated method stub
		return dao.find(holiday);
	}

	@Override
	public Boolean updateHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		try {
			dao.update(holiday);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteHoliday(Holiday holiday) {
		// TODO Auto-generated method stub
		try {
			dao.delete(holiday);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		}
		return false;
	}
}
