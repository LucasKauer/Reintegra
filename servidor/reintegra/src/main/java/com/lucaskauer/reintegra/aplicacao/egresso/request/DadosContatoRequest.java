package com.lucaskauer.reintegra.aplicacao.egresso.request;

public class DadosContatoRequest {

	private String email;

	private String telefoneCelular;

	private String telefoneCelularRecado;

	public DadosContatoRequest() {
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

	public String getTelefoneCelularRecado() {
		return telefoneCelularRecado;
	}

	public void setTelefoneCelularRecado(String telefoneCelularRecado) {
		this.telefoneCelularRecado = telefoneCelularRecado;
	}
}
