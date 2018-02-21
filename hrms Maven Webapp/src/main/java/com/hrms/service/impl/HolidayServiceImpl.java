package com.hrms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Department;
import com.hrms.entity.Holiday;
import com.hrms.entity.Position;
import com.hrms.entity.Staff;
import com.hrms.page.Page;
import com.hrms.service.HolidayService;
import com.hrms.util.HQLHelper;

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

	@Override
	public List<Holiday> getHolidays(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from Holiday order by startDate desc ",page);
	}

	@Override
	public List<Holiday> getHolidays(Holiday holiday, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();//�洢hql�������
		Map<String, Object> map = new HashMap<String, Object>();//�洢hql��Ҫ�����ֵ
		if(holiday != null){
			//���Ա������
			Staff staff  = holiday.getStaff();
			//ƴ��Ա�������еĲ���
			if(staff != null){//�п�
				if(staff.getNo()!=null){
					params.add(" staff.no like :no ");
					map.put("no", "%"+staff.getNo()+"%");
				}
				if(staff.getName() != null){
					params.add(" staff.name like :name ");
					map.put("name", "%"+staff.getName()+"%");
				}
				//��ò��Ŷ���
				Department dept =  staff.getDepartment();
				//ƴ�Ӳ��Ŷ����е�ֵ
				if(dept != null && dept.getId() != null && dept.getId() != -1){//�п�
					params.add(" staff.department.id = :did ");
					map.put("did", dept.getId());
				}
				//���ְλ����
				Position position = staff.getPosition();
				//ƴ��ְλ�����е�ֵ
				if(position != null && position.getId() != null && position.getId() != -1){//�п�
					params.add(" staff.position.id = :pid ");
					map.put("pid", position.getId());
				}
			}
			
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from Holiday "+(params.size()>0?" where "+param.toString():"")+" order by startDate desc ",map,page);
	}
	
	
	
	
	
}
