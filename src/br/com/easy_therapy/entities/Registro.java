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
@Table(name="registro")
@NamedQueries(
		{
			@NamedQuery(name=Registro.FINDBY_CLIENTE,
				query="select r from Registro as r where r.cliente like :cli order by r.data ")
		}
	)
public class Registro {
	public static final String FINDBY_CLIENTE = "registro.findbycliente";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id",insertable = false, updatable = false, nullable = false)
	private Integer id;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idcliente")
	private Cliente cliente;

	@Temporal(TemporalType.TIMESTAMP)
	@Column (name = "data")
	private Date data;

	@Column(name = "situacao", length = 300, nullable = false)
	private String situacao;

	@Column(name = "pensamentos_automaticos", length = 300, nullable = false)
	private String pensamentos_automaticos;

	@Column(name = "emocoes", length = 300, nullable = false)
	private String emocoes;

	@Column(name = "conclusao", length = 300, nullable = false)
	private String conclusao;

	@Column(name = "resultado", length = 300, nullable = false)
	private String resultado;
	
	
	public Registro(Integer id, Cliente cliente, Date data, String situacao, String pensamentos_automaticos,
			String emocoes, String conclusao, String resultado) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.data = data;
		this.situacao = situacao;
		this.pensamentos_automaticos = pensamentos_automaticos;
		this.emocoes = emocoes;
		this.conclusao = conclusao;
		this.resultado = resultado;
	}
	
	public Registro() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getPensamentos_automaticos() {
		return pensamentos_automaticos;
	}

	public void setPensamentos_automaticos(String pensamentos_automaticos) {
		this.pensamentos_automaticos = pensamentos_automaticos;
	}

	public String getEmocoes() {
		return emocoes;
	}

	public void setEmocoes(String emocoes) {
		this.emocoes = emocoes;
	}

	public String getConclusao() {
		return conclusao;
	}

	public void setConclusao(String conclusao) {
		this.conclusao = conclusao;
	}

	public String getResultado() {
		return resultado;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
}
