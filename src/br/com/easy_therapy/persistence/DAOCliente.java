package br.com.easy_therapy.persistence;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.easy_therapy.entities.Cliente;
import br.com.easy_therapy.persistence.generics.DAOGeneric;

public class DAOCliente extends DAOGeneric<Cliente, Integer>{

	public DAOCliente() {
		super(Cliente.class);
	}

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
	
	public boolean hasEmail(String email) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Cliente.HAS_EMAIL);
		query.setString("cemail", email);	
		//verificar se email existe
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
	}
	
	public boolean emailSenha(String email, String senha) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Cliente.HASEMAIL_SENHA);
		query.setString("cemail", email);
		query.setString("csenha",senha);
		//verificar se email e senha existem
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
	}

	
}