package com.lucaskauer.reintegra.aplicacao.autenticacao.models;

public class UsuarioModel {
	private String nome;
	
	public UsuarioModel() {
		this.nome = "Lucas";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
