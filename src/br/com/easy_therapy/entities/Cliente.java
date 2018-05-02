package br.com.easy_therapy.entities;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="cliente")
@NamedQueries(
		{
			@NamedQuery(name=Cliente.FINDBY_PSICOLOGO,
				query="select c from cliente as c where c.psicologo = :p order by c.nome"),
			@NamedQuery(name=Cliente.FINDBY_NOME,
				query="select c from cliente as c where c.nome like :cnome order by c.nome")
		}
	)
public class Cliente {
	public static final String FINDBY_PSICOLOGO = "cliente.findbypsicologo";
	public static final String FINDBY_NOME = "cliente.findbyname";

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;

	@Column(name = "email", length = 50, nullable = false, unique = true)
	private String email;

	@Column(name = "senha", length = 20, nullable = false)
	private String senha;

	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	@Column(name = "idade")
	private Integer idade;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private Psicologo crp_psicologo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "data_ultimo_registro")
	private Date data_ultimo_registro;

	public Cliente(Integer id, String email, String senha, String nome,
			Integer idade, Psicologo crp_psicologo, Date data_ultimo_registro) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.nome = nome;
		this.idade = idade;
		this.crp_psicologo = crp_psicologo;
		this.data_ultimo_registro = data_ultimo_registro;
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
	public Psicologo getCrp_psicologo() {
		return crp_psicologo;
	}
	public void setCrp_psicologo(Psicologo crp_psicologo) {
		this.crp_psicologo = crp_psicologo;
	}
	public Date getData_ultimo_registro() {
		return data_ultimo_registro;
	}
	public void setData_ultimo_registro(Date data_ultimo_registro) {
		this.data_ultimo_registro = data_ultimo_registro;
	}

}

