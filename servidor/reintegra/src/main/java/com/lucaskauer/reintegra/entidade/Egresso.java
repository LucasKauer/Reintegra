package com.lucaskauer.reintegra.entidade;

import javax.persistence.*;

import java.util.List;

@Entity
@NamedQuery(name = "Egresso.findAll", query = "SELECT e FROM Egresso e")
public class Egresso extends Usuario {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "egresso")
	private List<Curriculo> curriculos;

	@ManyToMany(mappedBy = "egressos")
	private List<Competencia> competencias;

	@OneToMany(mappedBy = "egresso")
	private List<Recomendacao> recomendacoes;
	
	public Egresso() {
	}

	public Egresso(String apelido, String email, String senha, DadosPessoais dadosPessoais, Perfil perfil,
			DadosResidenciais dadosResidenciais, DadosContato dadosContato) {
		super(apelido, email, senha, true, dadosPessoais, perfil, dadosResidenciais, dadosContato);
	}

	public List<Curriculo> getCurriculos() {
		return this.curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public Curriculo adicionarCurriculo(Curriculo curriculo) {
		getCurriculos().add(curriculo);
		curriculo.setEgresso(this);

		return curriculo;
	}

	public Curriculo removerCurriculo(Curriculo curriculo) {
		getCurriculos().remove(curriculo);
		curriculo.setEgresso(null);

		return curriculo;
	}
	
	public List<Competencia> getCompetencias() {
		return this.competencias;
	}

	public void setCompetencias(List<Competencia> competencias) {
		this.competencias = competencias;
	}

	public List<Recomendacao> getRecomendacoes() {
		return this.recomendacoes;
	}

	public void setRecomendacoes(List<Recomendacao> recomendacoes) {
		this.recomendacoes = recomendacoes;
	}

	public Recomendacao adicionarRecomendacao(Recomendacao recomendacao) {
		getRecomendacoes().add(recomendacao);
		recomendacao.setEgresso(this);

		return recomendacao;
	}

	public Recomendacao removerRecomendacao(Recomendacao recomendacao) {
		getRecomendacoes().remove(recomendacao);
		recomendacao.setEgresso(null);

		return recomendacao;
	}
}