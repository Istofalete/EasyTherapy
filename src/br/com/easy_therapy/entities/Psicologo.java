package br.com.easy_therapy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="psicologo")
public class Psicologo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="crp")
	private Integer crp;

	@Column(name = "senha", length = 20, nullable = false)
	private String senha;
	
	@Column(name = "nome", length = 100, nullable = false)
	private String nome;

	public Psicologo(Integer crp, String senha, String nome) {
		super();
		this.crp = crp;
		this.senha = senha;
		this.nome = nome;
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
