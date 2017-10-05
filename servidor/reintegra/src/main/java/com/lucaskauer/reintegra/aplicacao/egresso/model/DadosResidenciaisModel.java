package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.DadosResidenciais;

public class DadosResidenciaisModel {
	private String bairro;
	private String cep;
	private String complemento;
	private String endereco;
	private int numero;
	private CidadeModel cidade;

	public DadosResidenciaisModel(DadosResidenciais dadosResidenciais) {
		this.setBairro(bairro);
		this.setCep(cep);
		this.setComplemento(complemento);
		this.setEndereco(endereco);
		this.setNumero(numero);
		
		CidadeModel cidade = new CidadeModel(dadosResidenciais.getCidade());
		this.setCidadeModel(cidade);
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

	public CidadeModel getCidadeModel() {
		return cidade;
	}

	public void setCidadeModel(CidadeModel cidade) {
		this.cidade = cidade;
	}
}
