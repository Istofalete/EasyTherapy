package br.com.easy_therapy.menager;

import java.util.List;

import br.com.easy_therapy.entities.Cliente;
import br.com.easy_therapy.persistence.DAOCliente;

public class ManagedBeanCliente {
	
	private List<Cliente> lista;
	
	public ManagedBeanCliente() {	
	}
	
	public List<Cliente> getLista(){
		DAOCliente d = new DAOCliente();
		try {
			lista = d.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}

}
