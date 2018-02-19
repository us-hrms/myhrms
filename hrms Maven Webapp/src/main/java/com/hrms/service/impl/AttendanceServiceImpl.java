package com.hrms.service.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Attendance;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.AttendanceService;
import com.hrms.util.HQLHelper;

@Service
public class AttendanceServiceImpl implements AttendanceService {
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean updateAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.update(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.delete(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Attendance> getAttendances() {
		// TODO Auto-generated method stub
		return dao.find(new Attendance());
	}

	@Override
	public List<Attendance> getAttendances(Attendance attendance) {
		// TODO Auto-generated method stub
		return dao.find(attendance);
	}

	@Override
	public Attendance getAttendance(Serializable id) {
		// TODO Auto-generated method stub
		return (Attendance) dao.get(Attendance.class, id);
	}

	public Dao getDao() {
		return dao;
	}

	public void setDao(Dao dao) {
		this.dao = dao;
	}

	@Override
	public Boolean saveAttendance(Attendance attendance) {
		// TODO Auto-generated method stub
		try {
			dao.save(attendance);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Attendance> getAttendancesOfStaff(Staff staff,Page page) {
		// TODO Auto-generated method stub
		switch (staff.getDataDictionaryByTypeId().getId().intValue()) {
		case 6:
			return dao.find(new Attendance(), page);
		case 7:
		case 8:
			return dao.find("from Attendance where staff.department.id in (select department.id from Staff where id = :id) order by time desc",staff,page);
		case 9:
		case 10:
			return dao.find("from Attendance where staff.id = :id order by time desc",staff,page);
		}
		return null;
	}

	@Override
	public List<Attendance> getAttendancesOfStaff(Staff staff,
			Attendance attendance, Timestamp start, Timestamp stop, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		//拼接条件
		if(attendance!=null){
			Staff staffParam = attendance.getStaff();
			if(staffParam!=null){
				if(staffParam.getName()!=null && staffParam.getName().length()!=0){
					params.add(" staff.name like :name ");
					map.put("name", "%"+staffParam.getName()+"%");
				}
				if(staffParam.getNo()!=null && staffParam.getNo().length()!=0){
					params.add(" staff.no like :num ");
					map.put("num", "%"+staffParam.getNo()+"%");
				}
			}
			if(attendance.getDataDictionary()!=null && attendance.getDataDictionary().getId()!=null && attendance.getDataDictionary().getId()!=-1){
				params.add(" dataDictionary.id = :did ");
				map.put("did", attendance.getDataDictionary().getId());
			}
			if(start!=null){
				params.add(" time > :start ");
				map.put("start", start);
			}
			if(stop!= null){
				params.add(" time < :stop ");
				map.put("stop", stop);
			}
		}
		//合成string
		StringBuffer param = HQLHelper.toHqlWhere(params);
		switch (staff.getDataDictionaryByTypeId().getId().intValue()) {
		case 6:
			if(params.size()>0)
				return dao.find("from Attendance where "+param.toString()+" order by time desc",map,page);
		case 7:
		case 8:
			if(params.size()>0){
				map.put("id", staff.getId());
				return dao.find("from Attendance where staff.department.id in (select department.id from Staff where id = :id) and "
						+param.toString()+" order by time desc",map,page);
			}
		case 9:
		case 10:
			if(params.size()>0){
				map.put("id", staff.getId());
				return dao.find("from Attendance where staff.id = :id and"+param.toString()+" order by time desc",map,page);
			}
		}
		return getAttendancesOfStaff(staff,page);
	}
	
	
	
}
