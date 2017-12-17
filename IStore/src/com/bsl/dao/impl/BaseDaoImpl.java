package com.bsl.dao.impl;


import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bsl.dao.IBaseDao;

import lombok.Getter;
import lombok.Setter;

@Repository
@Getter@Setter
public class BaseDaoImpl<T> implements IBaseDao<T> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	

	@Override		//根据ID加载实体
	public T get(Class<T> entityClazz, Long id) {
		Session session = sessionFactory.openSession();
		T entity = (T) session.get(entityClazz, id);
		session.close();
		return entity;
	}

	@Override		//保存实体
	public Long save(T entity){
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Long id = (Long) session.save(entity);
		tx.commit();
		session.close();
		return id;
	}

	@Override		//更新实体
	public void update(T entity) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(entity);
		tx.commit();
		session.close();
	}

	@Override		// 删除实体
	public void delete(T entity) {
		
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(entity);;
		tx.commit();
		session.close();
	}
	
	@Override		//根据ID删除实体
	public void delete(Class<T> entityClazz, Long id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.createQuery("delete "
				+ entityClazz.getSimpleName()+" en where en.id = ?0")
				.setParameter("0", id)
				.executeUpdate();
		tx.commit();
		session.close();
	}

	@Override		//获取所有实体
	public List<T> findAll(Class<T> entityClazz) {
		return find("select en from "+entityClazz.getSimpleName()+" en");
	}

	@Override		//获取实体总数
	public long findCount(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		return 0;
	}

	//使用HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql){
		
		Session session = sessionFactory.openSession();
		List<T> list =(List<T>) session.createQuery(hql).getResultList();
		session.close();
		return list;
	}
	
	//根据占位符参数HQL语句查询实体
	@SuppressWarnings("unchecked")
	protected List<T> find(String hql,Object... params){
		Session session = sessionFactory.openSession();
		//创建查询
		Query query = session.createQuery(hql);
		//为包含占位符的HQL语句设置参数
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+"", params[i]);
		}
		List<T> list = query.getResultList();
		session.close();
		return list;
	}
}
