package com.hrms.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.hrms.page.Page;

public interface Dao {
	Serializable save(Object entity);
	void delete(Object entity);
	void update(Object entity);
	void saveOrUpdate(Object entity);
	Object get(Class clazz,Serializable id);
	//Serializable getSquenceValue(String sequenceName);
	List find(Object entity);
	List find(String hql);
	List find(String hql, Page page);
	List find(String hql,Object entity);
	List find(String hql,Map map);
	//List find(Object entity,int pageSize,int pageIndex);
	List find(Object entity,Page page);
	//List find(String hql,Object entity,int pageSize,int pageIndex);
	List find(String hql,Object entity,Page page);
	//List find(String hql,Map map,int pageSize,int pageIndex);
	List find(String hql,Map map,Page page);
}
