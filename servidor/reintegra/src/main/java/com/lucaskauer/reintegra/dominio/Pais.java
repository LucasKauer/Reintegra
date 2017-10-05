package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "Pais")
@NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p")
public class Pais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "pais")
	@NotNull
	private List<DadosPessoais> dadosPessoais;

	@OneToMany(mappedBy = "pais")
	@NotNull
	private List<Estado> estados;

	public Pais() {
	}

	public Pais(String nome) {
		super();
		this.nome = nome;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<DadosPessoais> getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosPessoais adicionarDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().add(dadosPessoais);
		dadosPessoais.setPais(this);

		return dadosPessoais;
	}

	public DadosPessoais removerDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().remove(dadosPessoais);
		dadosPessoais.setPais(null);

		return dadosPessoais;
	}

	public List<Estado> getEstados() {
		return this.estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public Estado adicionarEstado(Estado estado) {
		getEstados().add(estado);
		estado.setPais(this);

		return estado;
	}

	public Estado removerEstado(Estado estado) {
		getEstados().remove(estado);
		estado.setPais(null);

		return estado;
	}

}