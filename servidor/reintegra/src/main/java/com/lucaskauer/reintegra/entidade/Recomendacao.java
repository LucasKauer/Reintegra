package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;

@Entity
@NamedQuery(name = "Recomendacao.findAll", query = "SELECT r FROM Recomendacao r")
public class Recomendacao implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RecomendacaoPK id;

	@Temporal(TemporalType.DATE)
	@Column(name = "Data")
	@NotNull
	private Date data;

	@ManyToOne
	@JoinColumn(name = "IdUsuarioFez", insertable = false, updatable = false)
	@NotNull
	private TipoEmprego tipoEmprego;

	@ManyToOne
	@JoinColumn(name = "IdUsuarioEgressoRecebeu", insertable = false, updatable = false)
	@NotNull
	private Egresso egresso;

	@ManyToOne
	@JoinColumn(name = "IdCompetencia", insertable = false, updatable = false)
	@NotNull
	private Competencia competencia;

	public Recomendacao() {
	}

	public RecomendacaoPK getId() {
		return this.id;
	}

	public void setId(RecomendacaoPK id) {
		this.id = id;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public TipoEmprego getTipoEmprego() {
		return this.tipoEmprego;
	}

	public void setTipoEmprego(TipoEmprego tipoEmprego) {
		this.tipoEmprego = tipoEmprego;
	}

	public Egresso getEgresso() {
		return this.egresso;
	}

	public void setEgresso(Egresso egresso) {
		this.egresso = egresso;
	}

	public Competencia getCompetencia() {
		return this.competencia;
	}

	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}

}