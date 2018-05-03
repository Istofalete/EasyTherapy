package br.com.easy_therapy.menager;

import java.util.List;

import br.com.easy_therapy.entities.Psicologo;
import br.com.easy_therapy.persistence.DAOPsicologo;

public class ManagedBeanPsicologo {
		private List<Psicologo> lista;
		
		public ManagedBeanPsicologo() {	
		}
		
		public List<Psicologo> getLista(){
			DAOPsicologo d = new DAOPsicologo();
			try {
				lista = d.findAll();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			return lista;
		}

}
