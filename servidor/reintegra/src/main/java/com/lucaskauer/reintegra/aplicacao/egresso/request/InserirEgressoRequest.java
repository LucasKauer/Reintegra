package com.lucaskauer.reintegra.aplicacao.egresso.request;

import com.lucaskauer.reintegra.entidade.Cidade;
import com.lucaskauer.reintegra.entidade.DadosContato;
import com.lucaskauer.reintegra.entidade.DadosPessoais;
import com.lucaskauer.reintegra.entidade.DadosResidenciais;
import com.lucaskauer.reintegra.entidade.Egresso;
import com.lucaskauer.reintegra.entidade.EstadoCivil;
import com.lucaskauer.reintegra.entidade.Pais;
import com.lucaskauer.reintegra.entidade.Perfil;

public class InserirEgressoRequest {

	private String apelido;

	private String email;

	private String senha;

	private DadosPessoaisRequest dadosPessoais;

	private PerfilRequest perfil;

	private DadosResidenciaisRequest dadosResidenciais;

	private DadosContatoRequest dadosContato;

	public InserirEgressoRequest() {
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

	public DadosPessoaisRequest getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoaisRequest dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public PerfilRequest getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilRequest perfil) {
		this.perfil = perfil;
	}

	public DadosResidenciaisRequest getDadosResidenciais() {
		return dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciaisRequest dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public DadosContatoRequest getDadosContato() {
		return dadosContato;
	}

	public void setDadosContato(DadosContatoRequest dadosContato) {
		this.dadosContato = dadosContato;
	}

	public Egresso ParaEntidade() {
		Cidade cidade = new Cidade(this.getDadosPessoais().getNaturalidade().getNome());
		Pais pais = new Pais(this.getDadosPessoais().getNacionalidade().getNome());
		EstadoCivil estadoCivil = new EstadoCivil(this.getDadosPessoais().getEstadoCivil().getCodigo());
		DadosPessoais dadosPessoais = new DadosPessoais(this.getDadosPessoais().getCpf(),
				this.getDadosPessoais().getDataDeNascimento(), this.getDadosPessoais().getNome(),
				this.getDadosPessoais().getRg(), this.getDadosPessoais().getSexo(), cidade, pais, estadoCivil);
		Perfil perfil = new Perfil(this.getPerfil().getCodigo());
		Cidade cidadeDadosResidenciais = new Cidade(this.getDadosResidenciais().getCidade().getNome());
		DadosResidenciais dadosResidenciais = new DadosResidenciais(this.getDadosResidenciais().getBairro(),
				this.getDadosResidenciais().getCep(), this.getDadosResidenciais().getComplemento(),
				this.getDadosResidenciais().getEndereco(), this.getDadosResidenciais().getNumero(),
				cidadeDadosResidenciais);
		DadosContato dadosContato = new DadosContato(this.getDadosContato().getEmail(),
				this.getDadosContato().getTelefoneCelular(), this.getDadosContato().getTelefoneCelularRecado());

		Egresso egresso = new Egresso(this.getApelido(), this.getEmail(), this.getSenha(), dadosPessoais, perfil,
				dadosResidenciais, dadosContato);

		return egresso;
	}
}
