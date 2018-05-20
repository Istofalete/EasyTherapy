package br.com.easy_therapy.persistence.generics;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.easy_therapy.persistence.HibernateUtil;

public abstract class DAOGeneric<T,K extends Serializable > implements IDAOGeneric<T, K > {
	
	
	
	protected Session session;
	protected Transaction transaction;
	protected Query query;
	
	
	private Class<T> tipo;
	
	public DAOGeneric(Class<T> tipo) {
		this.tipo = tipo;
		
	}
	
	@Override
	public void insert(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		transaction =session.beginTransaction();
		session.save(obj);
		transaction.commit();
		
		session.close();
		
	}

	@Override
	public void update(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction =session.beginTransaction();
		session.update(obj);
		transaction.commit();
		
		session.close();
		
	}
	
	@Override
	public void delete(T obj) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		
		transaction =session.beginTransaction();
		session.delete(obj);
		transaction.commit();
		
		session.close();
		
	}
	
	public List<T> findAll() throws Exception{
		session = HibernateUtil.getSessionFactory().openSession();
		
		@SuppressWarnings("unchecked")
		List<T> lista = session.createCriteria(tipo).list();
		session.close();
		return lista;
	}
	
	@Override
	public T findById(K id) throws Exception {
		session = HibernateUtil.getSessionFactory().openSession();
		@SuppressWarnings("unchecked")
		T obj = (T) session.get(tipo, id);
		session.close();
		return obj;
	}
}

