package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "FuncaoTrabalho.findAll", query = "SELECT f FROM FuncaoTrabalho f")
public class FuncaoTrabalho implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long id;

	@Column(name = "Descricao")
	@NotNull
	private String descricao;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@ManyToOne
	@JoinColumn(name = "IdOportunidade")
	@NotNull
	private Oportunidade oportunidade;

	public FuncaoTrabalho() {
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

	public Oportunidade getOportunidade() {
		return this.oportunidade;
	}

	public void setOportunidade(Oportunidade oportunidade) {
		this.oportunidade = oportunidade;
	}

}