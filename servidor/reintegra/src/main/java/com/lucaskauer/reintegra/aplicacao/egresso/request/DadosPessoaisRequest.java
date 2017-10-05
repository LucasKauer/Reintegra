package com.lucaskauer.reintegra.aplicacao.egresso.request;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class DadosPessoaisRequest {

	private String cpf;

	@JsonFormat(locale = "pt_BR", pattern = "dd/MM/yyy")
	private Date dataDeNascimento;

	private String nome;

	private String rg;

	private String sexo;

	private CidadeRequest naturalidade;

	private PaisRequest nacionalidade;

	private EstadoCivilRequest estadoCivil;

	public DadosPessoaisRequest() {
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public CidadeRequest getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(CidadeRequest naturalidade) {
		this.naturalidade = naturalidade;
	}

	public PaisRequest getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(PaisRequest nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public EstadoCivilRequest getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilRequest estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}
