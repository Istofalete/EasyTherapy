package br.com.easy_therapy.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.easy_therapy.entities.Pensamento;
import br.com.easy_therapy.entities.Pensamento;

public class DAOPensamento {
	
	private Session session;
	private Transaction transaction;
	private Query query;

	public List<Pensamento> findByCliente(Integer cliente) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(Pensamento.FINDBY_CLIENTE);
		query.setLong("c", cliente);

		List<Pensamento> lista = query.list();
		session.close();
		return lista;
	}
	
	public Pensamento findById(Integer idPensamento) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		Pensamento f = (Pensamento) session.get(Pensamento.class, idPensamento);
		session.close();
		
		return f;
	}

	public void insert(Pensamento c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();

		session.close();
	}

	public void update(Pensamento c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c); 
		transaction.commit(); 

		session.close();
	}

	public void delete(Pensamento c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();

		session.close();
	}
}
