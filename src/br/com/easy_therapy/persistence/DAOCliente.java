package br.com.easy_therapy.persistence;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import br.com.easy_therapy.entities.Cliente;

public class DAOCliente {

	private Session session;
	private Transaction transaction;
	private Query query;

	public List<Cliente> findByPsicologo(Integer psicologo) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(Cliente.FINDBY_PSICOLOGO);
		query.setLong("p", psicologo);

		List<Cliente> lista = query.list();
		session.close();
		return lista;
	}
	
	public List<Cliente> findByNome(String nome) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(Cliente.FINDBY_NOME);
		query.setString("cnome", "%"+nome+"%");

		List<Cliente> lista = query.list();
		session.close();
		return lista;
	}

	public Cliente findById(Integer idCliente) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		Cliente f = (Cliente) session.get(Cliente.class, idCliente);
		session.close();
		
		return f;
	}

	public void insert(Cliente c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();transaction = session.beginTransaction();
		session.save(c);
		transaction.commit();

		session.close();
	}

	public void update(Cliente c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.update(c); 
		transaction.commit(); 

		session.close();
	}

	public void delete(Cliente c) throws Exception {

		session = HibernateUtil.getSessionFactory().openSession();
		transaction = session.beginTransaction();
		session.delete(c);
		transaction.commit();

		session.close();
	}
}