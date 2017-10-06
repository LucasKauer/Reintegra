package com.lucaskauer.reintegra.aplicacao.egresso.model;

import com.lucaskauer.reintegra.entidade.Egresso;

public class EgressoModel {
	private String apelido;
	private String email;
	private String senha;
	private boolean ativo;
	private PerfilModel perfil;
	private DadosPessoaisModel dadosPessoais;
	private DadosResidenciaisModel dadosResidenciais;
	private DadosContatoModel dadosContato;
	
	public EgressoModel(Egresso egresso) {
		this.setApelido(egresso.getApelido());
		this.setEmail(egresso.getEmail());
		this.setSenha(egresso.getSenha());
		this.setAtivo(egresso.isAtivo());
		
		PerfilModel perfil = new PerfilModel(egresso.getPerfil());
		DadosPessoaisModel dadosPessoais = new DadosPessoaisModel(egresso.getDadosPessoais());
		DadosResidenciaisModel dadosResidenciais = new DadosResidenciaisModel(egresso.getDadosResidenciais());
		DadosContatoModel dadosContato = new DadosContatoModel(egresso.getDadosContato());
		
		this.setPerfil(perfil);
		this.setDadosPessoais(dadosPessoais);
		this.setDadosResidenciais(dadosResidenciais);
		this.setDadosContato(dadosContato);
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public PerfilModel getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilModel perfil) {
		this.perfil = perfil;
	}

	public DadosPessoaisModel getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoaisModel dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosResidenciaisModel getDadosResidenciais() {
		return dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciaisModel dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public DadosContatoModel getDadosContato() {
		return dadosContato;
	}

	public void setDadosContato(DadosContatoModel dadosContato) {
		this.dadosContato = dadosContato;
	}
}
