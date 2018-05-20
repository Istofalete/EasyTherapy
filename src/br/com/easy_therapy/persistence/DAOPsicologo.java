package br.com.easy_therapy.persistence;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.easy_therapy.entities.Cliente;
import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.persistence.generics.DAOGeneric;

public class DAOPsicologo extends DAOGeneric<Psicologo, Integer> {

	public DAOPsicologo() {
		super(Psicologo.class);
	}

	private Session session;
	private Transaction transaction;

	public boolean hasCRP(String email) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HAS_CRP);
		query.setString("cemail", email);	
		//verificar se email existe
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
	}
	
	public boolean hasCrpSenha(String email, String senha) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HASCRP_SENHA);
		query.setString("cemail", email);
		query.setString("csenha",senha);
		//verificar se email e senha existem
		Long qtd = (Long) query.uniqueResult();
		
		return qtd >0;
	}	
	
}
