package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQuery(name = "Competencia.findAll", query = "SELECT c FROM Competencia c")
public class Competencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "Descricao", length = 200)
	@NotNull
	@Size(min = 4)
	private String descricao;

	@Column(name = "Nome", length = 100)
	@NotNull
	@Size(min = 4)
	private String nome;

	@ManyToMany
	@JoinTable(name = "EgressoCompetencia", joinColumns = {
			@JoinColumn(name = "IdCompetencia") }, inverseJoinColumns = { @JoinColumn(name = "IdUsuarioEgresso") })
	@NotNull
	private List<Egresso> egressos;

	@OneToMany(mappedBy = "competencia")
	@NotNull
	private List<Recomendacao> recomendacoes;

	public Competencia() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Egresso> getEgressos() {
		return this.egressos;
	}

	public void setEgressos(List<Egresso> egressos) {
		this.egressos = egressos;
	}

	public List<Recomendacao> getRecomendacoes() {
		return this.recomendacoes;
	}

	public void setRecomendacoes(List<Recomendacao> recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public Recomendacao adicionarRecomendacao(Recomendacao recomendacao) {
		getRecomendacoes().add(recomendacao);
		recomendacao.setCompetencia(this);

		return recomendacao;
	}

	public Recomendacao removerRecomendacao(Recomendacao recomendacao) {
		getRecomendacoes().remove(recomendacao);
		recomendacao.setCompetencia(null);

		return recomendacao;
	}

}