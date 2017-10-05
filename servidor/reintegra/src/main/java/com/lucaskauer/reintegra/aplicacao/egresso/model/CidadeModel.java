package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.Cidade;

public class CidadeModel {
	private String nome;
	
	public CidadeModel(Cidade cidade) {
		this.setNome(cidade.getNome());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
