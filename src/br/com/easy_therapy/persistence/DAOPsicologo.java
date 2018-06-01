package br.com.easy_therapy.persistence;

import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.persistence.generics.DAOGeneric;

public class DAOPsicologo extends DAOGeneric<Psicologo, Integer> {

	public DAOPsicologo() {
		super(Psicologo.class);
	}

	public boolean hasCRP(String crp) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HAS_CRP);
		query.setString("p1", crp);	
		//verificar se email existe
		Long qtd = (Long) query.uniqueResult();
		session.close();
		return qtd >0;
	}
	
	public boolean hasCrpSenha(String crp, String senha) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.HASCRP_SENHA);
		query.setString("pcrp", crp);
		query.setString("psenha",senha);
		Long qtd = (Long) query.uniqueResult();	
		session.close();
		return qtd >0;
	}	
	
	public boolean hasID(Integer id) throws Exception{
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		query = session.getNamedQuery(Psicologo.FINDBY_ID);
		query.setInteger("p1", id);	
		Long qtd = (Long) query.uniqueResult();
		session.close();
		return qtd >0;
	}
	
}
