package br.com.easy_therapy.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.easy_therapy.entities.Psicologo;

public class DAOPsicologo {

	private Session session;
	private Transaction transaction;

	public Psicologo findById(Integer idPsicologo) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		Psicologo f = (Psicologo) session.get(Psicologo.class, idPsicologo);
		session.close();
		
		return f;
	}

	public void insert(Psicologo p) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();transaction = session.beginTransaction();
		session.save(p);
		transaction.commit();

		session.close();
	}

	public void update(Psicologo p) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(p); 
		transaction.commit(); 

		session.close();
	}

	public void delete(Psicologo p) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(p);
		transaction.commit();

		session.close();
	}
}
