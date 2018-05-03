package br.com.easy_therapy.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.easy_therapy.entities.Cliente;
import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.percistence.generics.DAOGeneric;

public class DAOPsicologo extends DAOGeneric<Psicologo, Integer> {

	public DAOPsicologo() {
		super(Psicologo.class);
	}

	private Session session;
	private Transaction transaction;

	public Psicologo findById(Integer idPsicologo) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		Psicologo f = (Psicologo) session.get(Psicologo.class, idPsicologo);
		session.close();
		
		return f;
	}

	public boolean hasEmail(String email) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HAS_CRP);
		query.setString("cemail", email);	
		//verificar se email existe
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
	}
	
	public boolean emailSenha(String email, String senha) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HASCRP_SENHA);
		query.setString("cemail", email);
		query.setString("csenha",senha);
		//verificar se email e senha existem
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
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
