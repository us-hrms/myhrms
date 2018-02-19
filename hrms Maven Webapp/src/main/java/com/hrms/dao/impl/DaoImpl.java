package com.hrms.dao.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.hrms.dao.Dao;
import com.hrms.page.Page;

public class DaoImpl extends HibernateDaoSupport implements Dao {
	
	/**
	 * 增
	 */
	@Override
	public Serializable save(Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().save(entity);
	}

	/**
	 * 删
	 */
	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * 改
	 */
	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * 新增或更新
	 */
	@Override
	public void saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(entity);
	}

	/**
	 * 根据 对象类 和 id 进行查询
	 */
	@Override
	public Object get(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * 根据实体和其包含的条件 进行查询
	 */
	@Override
	public List find(Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByExample(entity);
	}

	/**
	 *  根据hql 和 对象传参 查询
	 */
	@Override
	public List find(String hql, Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByValueBean(hql, entity);
	}

	/**
	 * 根据 hql 和 集合传参 查询
	 */
	@Override
	public List find(final String hql,final Map map) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql).setProperties(map);
				return query.list();
			}
		});
	}

	
	/**
	 * 根据实体  并 按分页类 分页查询
	 */
	@Override
	public List find(final Object entity,Page page) {
		// TODO Auto-generated method stub
		//设置page类总页数
		page.setPageCountBySize(this.getHibernateTemplate().findByExample(entity).size());
		return this.getHibernateTemplate().findByExample(entity, (page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
	}

	/**
	 * 根据 hql 和 所传参数 并按Page内容 分页查询
	 */
	@Override
	public List find(final String hql, final Object entity,final Page page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql).setProperties(entity);
				//更新page对象的总页数
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
			}
		});
	}

	/**
	 * 根据 hql 和 所传参数 并按Page内容 分页查询
	 */
	@Override
	public List find(final String hql, final Map map,final Page page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql).setProperties(map);
				//更新page对象的总页数
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
				
			}
		});
	}

	/**
	 * 按 hql  查询
	 */
	@Override
	public List find(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * 按 hql 分页查询
	 */
	@Override
	public List find(final String hql,final Page page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				//更新page对象的总页数
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
				
			}
		});
	}

	
}
