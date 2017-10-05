package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.DadosContato;

public class DadosContatoModel {
	private String email;
	private String telefoneCelular;
	private String telefoneContato;

	public DadosContatoModel(DadosContato dadosContato) {
		this.setEmail(dadosContato.getEmail());
		this.setTelefoneCelular(dadosContato.getTelefoneCelular());
		this.setTelefoneContato(dadosContato.getTelefoneCelularRecado());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneContato() {
		return telefoneContato;
	}

	public void setTelefoneContato(String telefoneContato) {
		this.telefoneContato = telefoneContato;
	}
}
