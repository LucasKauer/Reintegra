package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.Perfil;

public class PerfilModel {
	private String codigo;
	private String descricao;

	public PerfilModel(Perfil perfil) {
		this.setCodigo(perfil.getCodigo());
		this.setDescricao(perfil.getDescricao());
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
