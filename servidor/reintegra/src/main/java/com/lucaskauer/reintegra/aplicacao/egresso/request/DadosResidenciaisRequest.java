package com.lucaskauer.reintegra.aplicacao.egresso.request;

public class DadosResidenciaisRequest {
	private String bairro;

	private String cep;

	private String complemento;

	private String endereco;

	private int numero;

	private CidadeRequest cidade;

	public DadosResidenciaisRequest() {
	}
	
	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public CidadeRequest getCidade() {
		return cidade;
	}

	public void setCidade(CidadeRequest cidade) {
		this.cidade = cidade;
	}
}
