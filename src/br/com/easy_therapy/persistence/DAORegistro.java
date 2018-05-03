package br.com.easy_therapy.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.easy_therapy.entities.Registro;
import br.com.easy_therapy.percistence.generics.DAOGeneric;

public class DAORegistro extends DAOGeneric<Registro, Integer> {
	
	public DAORegistro() {
		super(Registro.class);
		
	}

	private Session session;
	private Transaction transaction;
	private Query query;

	public List<Registro> findByCliente(Integer cliente) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(Registro.FINDBY_CLIENTE);
		query.setLong("c", cliente);

		List<Registro> lista = query.list();
		session.close();
		return lista;
	}
	
	public Registro findById(Integer idRegistro) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		Registro f = (Registro) session.get(Registro.class, idRegistro);
		session.close();
		
		return f;
	}

	public void insert(Registro c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();

		session.close();
	}

	public void update(Registro c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c); 
		transaction.commit(); 

		session.close();
	}

	public void delete(Registro c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();

		session.close();
	}
}
