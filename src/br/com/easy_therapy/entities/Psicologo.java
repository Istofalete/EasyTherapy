package br.com.easy_therapy.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="psicologo")
@NamedQueries(
		{	
			@NamedQuery(name=Psicologo.HAS_CRP,
			query="select count(p) from Psicologo as p where p.crp = :p1"),
			@NamedQuery(name=Psicologo.HASCRP_SENHA,			
			query = "select count(p) from Psicologo as p where p.crp = :pcrp and p.senha = :psenha"), 
			@NamedQuery(name=Psicologo.FINDBY_ID,
			query="select count(p) from Psicologo as p where p.id = :p1"),
			@NamedQuery(name=Psicologo.HAS_ID,
			query="select count(p) from Psicologo as p where p.id = :p1"),
			
		}
	)

public class Psicologo {
	public static final String HAS_CRP = "psicologo.hascrp";
	public static final String HASCRP_SENHA = "psicologo.hascrpsenha";
	public static final String FINDBY_ID = "psicologo.findbyid";
	public static final String HAS_ID = "psicologo.hasid";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id",  nullable = false)
	private Integer id;
	
	@Column(name="crp", nullable = false, unique = true)
	private Integer crp;

	@Column(name = "senha", length = 32 , nullable = false)
	private String senha;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;
	
	@OneToMany(mappedBy="psicologo")
	@Column(name="cliente")
		private List<Cliente> clientes;
	
	public Psicologo() {
		
	}

	public Psicologo(Integer id, Integer crp, String senha, String nome, List<Cliente> clientes) {
		super();
		this.id = id;
		this.crp = crp;
		this.senha = senha;
		this.nome = nome;
		this.clientes = clientes;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCrp() {
		return crp;
	}
	public void setCrp(Integer crp) {
		this.crp = crp;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
