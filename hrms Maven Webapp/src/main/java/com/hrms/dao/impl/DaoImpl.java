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
	 * ��
	 */
	@Override
	public Serializable save(Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().save(entity);
	}

	/**
	 * ɾ
	 */
	@Override
	public void delete(Object entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().delete(entity);
	}

	/**
	 * ��
	 */
	@Override
	public void update(Object entity) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(entity);
	}

	/**
	 * ���������
	 */
	@Override
	public void saveOrUpdate(Object entity) {
		// TODO Auto-generated method stub
		this.saveOrUpdate(entity);
	}

	/**
	 * ���� ������ �� id ���в�ѯ
	 */
	@Override
	public Object get(Class clazz, Serializable id) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().get(clazz, id);
	}

	/**
	 * ����ʵ�������������� ���в�ѯ
	 */
	@Override
	public List find(Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByExample(entity);
	}

	/**
	 *  ����hql �� ���󴫲� ��ѯ
	 */
	@Override
	public List find(String hql, Object entity) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().findByValueBean(hql, entity);
	}

	/**
	 * ���� hql �� ���ϴ��� ��ѯ
	 */
	@Override
	public List find(String hql,Map map) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql, map);
	}

	
	/**
	 * ����ʵ��  �� ����ҳ�� ��ҳ��ѯ
	 */
	@Override
	public List find(final Object entity,Page page) {
		// TODO Auto-generated method stub
		//����page����ҳ��
		page.setPageCountBySize(this.getHibernateTemplate().findByExample(entity).size());
		return this.getHibernateTemplate().findByExample(entity, (page.getPageIndex()-1)*page.getPageSize(), page.getPageSize());
	}

	/**
	 * ���� hql �� �������� ����Page���� ��ҳ��ѯ
	 */
	@Override
	public List find(final String hql, final Object entity,final Page page) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().execute(new HibernateCallback<List>() {
			@Override
			public List doInHibernate(Session session) throws HibernateException,
					SQLException {
				// TODO Auto-generated method stub
				Query query = session.createQuery(hql);
				//����page�������ҳ��
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
			}
		});
	}

	/**
	 * ���� hql �� �������� ����Page���� ��ҳ��ѯ
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
				//����page�������ҳ��
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
				
			}
		});
	}

	/**
	 * �� hql  ��ѯ
	 */
	@Override
	public List find(String hql) {
		// TODO Auto-generated method stub
		return this.getHibernateTemplate().find(hql);
	}
	
	/**
	 * �� hql ��ҳ��ѯ
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
				//����page�������ҳ��
				page.setPageCountBySize(query.list().size());
				query.setFirstResult((page.getPageIndex()-1)*page.getPageSize()).setMaxResults(page.getPageSize());
				return query.list();
				
			}
		});
	}

	
}
