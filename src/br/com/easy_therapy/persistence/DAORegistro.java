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
	
	
}
