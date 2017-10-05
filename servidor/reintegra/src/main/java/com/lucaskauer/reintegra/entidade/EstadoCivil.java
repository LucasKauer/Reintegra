package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@NamedQuery(name = "EstadoCivil.findAll", query = "SELECT e FROM EstadoCivil e")
public class EstadoCivil implements Serializable {
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

	@OneToMany(mappedBy = "estadoCivil")
	@NotNull
	private List<DadosPessoais> dadosPessoais;

	public EstadoCivil() {
	}

	public EstadoCivil(String codigo) {
		super();
		this.codigo = codigo;
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

	public List<DadosPessoais> getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosPessoais adicionarDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().add(dadosPessoais);
		dadosPessoais.setEstadoCivil(this);

		return dadosPessoais;
	}

	public DadosPessoais removerDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().remove(dadosPessoais);
		dadosPessoais.setEstadoCivil(null);

		return dadosPessoais;
	}

}