package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@NamedQuery(name = "TipoEmprego.findAll", query = "SELECT t FROM TipoEmprego t")
public class TipoEmprego implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Codigo")
	@NotNull
	private String codigo;

	@Column(name = "Descricao")
	@NotNull
	private String descricao;

	@ManyToMany
	@JoinTable(name = "OportunidadeTipoEmprego", joinColumns = {
			@JoinColumn(name = "IdTipoEmprego") }, inverseJoinColumns = { @JoinColumn(name = "IdOportunidade") })
	@NotNull
	private List<Oportunidade> oportunidades;

	@OneToMany(mappedBy = "tipoEmprego")
	@NotNull
	private List<Recomendacao> recomendacoes;

	public TipoEmprego() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Oportunidade> getOportunidades() {
		return this.oportunidades;
	}

	public void setOportunidades(List<Oportunidade> oportunidades) {
		this.oportunidades = oportunidades;
	}

	public List<Recomendacao> getRecomendacaos() {
		return this.recomendacoes;
	}

	public void setRecomendacoes(List<Recomendacao> recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public Recomendacao addRecomendacao(Recomendacao recomendacao) {
		getRecomendacaos().add(recomendacao);
		recomendacao.setTipoEmprego(this);

		return recomendacao;
	}

	public Recomendacao removeRecomendacao(Recomendacao recomendacao) {
		getRecomendacaos().remove(recomendacao);
		recomendacao.setTipoEmprego(null);

		return recomendacao;
	}

}