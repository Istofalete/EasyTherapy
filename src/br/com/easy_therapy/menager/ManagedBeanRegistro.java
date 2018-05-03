package br.com.easy_therapy.menager;

import java.util.List;

import br.com.easy_therapy.entities.Registro;
import br.com.easy_therapy.persistence.DAORegistro;

public class ManagedBeanRegistro {

	private List<Registro> lista;
	
	public ManagedBeanRegistro() {	
	}
	
	public List<Registro> getLista(){
		DAORegistro d = new DAORegistro();
		try {
			lista = d.findAll();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
}
