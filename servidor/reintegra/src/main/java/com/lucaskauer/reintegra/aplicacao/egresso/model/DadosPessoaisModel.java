package com.lucaskauer.reintegra.aplicacao.egresso.model;

import java.util.Date;

import com.lucaskauer.reintegra.entidade.DadosPessoais;

public class DadosPessoaisModel {
	private String cpf;
	private Date dataDeNascimento;
	private String nome;
	private String rg;
	private String sexo;
	private CidadeModel naturalidade;
	private PaisModel nacionalidade;
	private EstadoCivilModel estadoCivil;

	public DadosPessoaisModel(DadosPessoais dadosPessoais) {
		this.setCpf(dadosPessoais.getCpf());
		this.setDataDeNascimento(dadosPessoais.getDataDeNascimento());
		this.setNome(dadosPessoais.getNome());
		this.setRg(dadosPessoais.getRg());
		this.setSexo(dadosPessoais.getSexo());
		
		CidadeModel naturalidade = new CidadeModel(dadosPessoais.getCidade());
		PaisModel nacionalidade = new PaisModel(dadosPessoais.getPais());
		EstadoCivilModel estadoCivil = new EstadoCivilModel(dadosPessoais.getEstadoCivil());
		
		this.setNaturalidade(naturalidade);
		this.setNacionalidade(nacionalidade);
		this.setEstadoCivil(estadoCivil);
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

	public CidadeModel getNaturalidade() {
		return naturalidade;
	}

	public void setNaturalidade(CidadeModel naturalidade) {
		this.naturalidade = naturalidade;
	}

	public PaisModel getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(PaisModel nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public EstadoCivilModel getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(EstadoCivilModel estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
}
