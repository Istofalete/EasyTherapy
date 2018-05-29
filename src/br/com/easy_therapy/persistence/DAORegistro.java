package br.com.easy_therapy.persistence;

import java.util.List;
import br.com.easy_therapy.entities.Registro;
import br.com.easy_therapy.persistence.generics.DAOGeneric;

public class DAORegistro extends DAOGeneric<Registro, Integer> {
	
	public DAORegistro() {
		super(Registro.class);
		
	}

	public List<Registro> findByCliente(Integer cliente) throws Exception{

		session = HibernateUtil.getSessionFactory().openSession();

		query = session.getNamedQuery(Registro.FINDBY_CLIENTE);
		query.setInteger("cli", cliente);
		List<Registro> lista = query.list();
		
		session.close();
		return lista;
	}
	
	
}
