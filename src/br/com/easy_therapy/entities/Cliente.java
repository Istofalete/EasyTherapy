package br.com.easy_therapy.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.*;
@Entity
@Table(name="cliente")
@NamedQueries(
		{
			@NamedQuery(name=Cliente.FINDBY_PSICOLOGO,
				query="select c from Cliente as c where c.psicologo = :p order by c.nome"),
			@NamedQuery(name=Cliente.FINDBY_NOME,
				query="select c from Cliente as c where c.nome like :c1 order by c.nome"),
			@NamedQuery(name=Cliente.HAS_EMAIL,
			query="select count(c) from Cliente as c where c.email = :c1"),
			@NamedQuery(name=Cliente.HASEMAIL_SENHA,			
			query = "select count(c) from Cliente as c where c.email = :cemail and c.senha = :csenha") 
		}
	)
public class Cliente {
	public static final String FINDBY_PSICOLOGO = "cliente.findbypsicologo";
	public static final String FINDBY_NOME = "cliente.findbyname";
	public static final String HAS_EMAIL = "cliente.hasemail";
	public static final String HASEMAIL_SENHA = "cliente.hasemailsenha";

	@Id
	@Column(name = "id",insertable = false, updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "senha", length = 32, nullable = false)
	private String senha;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "idade")
	private Integer idade;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idpsicologo", nullable = false)
	private Psicologo psicologo;

	@OneToMany(mappedBy="cliente")
	@Column(name="registro")
		private List<Registro> registro;

	public Cliente() {
		
	}
	public Cliente(Integer id, String email, String senha, String nome,
			Integer idade, Psicologo psicologo, Date data_ultimo_registro) {
		
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		this.psicologo = psicologo;
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public Integer getIdade() {
		return idade;
	}
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	public Psicologo getPsicologo() {
		return psicologo;
	}
	public void setPsicologo(Psicologo psicologo) {
		this.psicologo = psicologo;
	}
	
}

