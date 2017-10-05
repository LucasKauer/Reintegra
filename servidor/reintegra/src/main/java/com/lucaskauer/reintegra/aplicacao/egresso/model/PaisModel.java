package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.Pais;

public class PaisModel {
	private String nome;
	
	public PaisModel(Pais pais) {
		this.setNome(pais.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
