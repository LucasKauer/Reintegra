package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQuery(name = "NivelExperiencia.findAll", query = "SELECT n FROM NivelExperiencia n")
public class NivelExperiencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "Codigo", length = 100)
	@NotNull
	@Size(min = 4)
	private String codigo;

	@Column(name = "Descricao", length = 200)
	@NotNull
	@Size(min = 4)
	private String descricao;

	@ManyToMany
	@JoinTable(name = "OportunidadeNivelExperiencia", joinColumns = {
			@JoinColumn(name = "IdNivelExperiencia") }, inverseJoinColumns = { @JoinColumn(name = "IdOportunidade") })
	@NotNull
	private List<Oportunidade> oportunidades;

	public NivelExperiencia() {
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

}