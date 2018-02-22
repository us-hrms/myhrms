package com.hrms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.dao.Dao;
import com.hrms.entity.Certificate;
import com.hrms.entity.Cultivate;
import com.hrms.entity.CultivateRecord;
import com.hrms.page.Page;
import com.hrms.service.CultivateService;
import com.hrms.util.HQLHelper;

@Service
public class CultivateServiceImpl implements  CultivateService{
    
	@Autowired
	private Dao dao;

	@Override
	public Boolean updateCultivate(Cultivate cultivate) {
		// TODO Auto-generated method stub
		try {
			dao.update(cultivate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deleteCultivate(Cultivate cultivate) {
		// TODO Auto-generated method stub
		try {
			dao.delete(cultivate);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Cultivate getCultivate(Serializable id) {
		// TODO Auto-generated method stub
		return (Cultivate) dao.get(Cultivate.class, id);
	}

	@Override
	public List<Cultivate> getCultivates() {
		// TODO Auto-generated method stub
		return dao.find(new Cultivate());
	}

	@Override
	public List<Cultivate> getCultivates(Cultivate cultivate) {
		// TODO Auto-generated method stub
		return dao.find(cultivate);
	}

	@Override
	public List<Cultivate> getCultivates(Page page) {
		// TODO Auto-generated method stub
		return dao.find("from Cultivate",page);
	}

	@Override
	public List<Cultivate> getCultivates(Cultivate cultivate,Certificate certificate, Page page) {
		// TODO Auto-generated method stub
		List<String> params = new ArrayList<String>();
		Map<String, Object> map = new HashMap<String, Object>();
		if(cultivate != null){
			if(cultivate.getName() != null){
				params.add(" name like :name ");
				map.put("name", "%"+cultivate.getName()+"%");
			}
		}
		if(certificate != null && certificate.getId() != null && certificate.getId() != -1){
			params.add(" id in (select cultivates.id from Certificate where id = :cerid ) ");
			map.put("cerid", certificate.getId());
		}
		StringBuffer param = HQLHelper.toHqlWhere(params);
		return dao.find("from Cultivate "+(params.size()>0?" where " + param.toString():""), map, page);
	}

	@Override
	public List<Cultivate> getCultivates(Cultivate cultivate, Page page) {
		// TODO Auto-generated method stub
		return getCultivates(cultivate,null,page);
	}
}
