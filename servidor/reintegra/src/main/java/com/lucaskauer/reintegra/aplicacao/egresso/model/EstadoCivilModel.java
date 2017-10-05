package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.EstadoCivil;

public class EstadoCivilModel {
	private String codigo;
	private String descricao;
	
	public EstadoCivilModel(EstadoCivil estadoCivil) {
		this.setCodigo(estadoCivil.getCodigo());
		this.setDescricao(estadoCivil.getDescricao());
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
