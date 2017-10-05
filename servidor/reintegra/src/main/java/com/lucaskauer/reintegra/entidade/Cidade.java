package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c")
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "Nome", length = 100)
	@NotNull
	@Size(min = 4)
	private String nome;

	@ManyToOne
	@JoinColumn(name = "IdEstado")
	@NotNull
	private Estado estado;

	@OneToMany(mappedBy = "cidade")
	@NotNull
	private List<DadosPessoais> dadosPessoais;

	@OneToMany(mappedBy = "cidade")
	@NotNull
	private List<DadosResidenciais> dadosResidenciais;

	public Cidade() {
	}
	
	public Cidade(String nome) {
		super();
		this.nome = nome;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<DadosPessoais> getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosPessoais adicionarDadosPessoais(DadosPessoais dadosPessoai) {
		getDadosPessoais().add(dadosPessoai);
		dadosPessoai.setCidade(this);

		return dadosPessoai;
	}

	public DadosPessoais removerDadosPessoai(DadosPessoais dadosPessoai) {
		getDadosPessoais().remove(dadosPessoai);
		dadosPessoai.setCidade(null);

		return dadosPessoai;
	}

	public List<DadosResidenciais> getDadosResidenciais() {
		return this.dadosResidenciais;
	}

	public void setDadosResidenciais(List<DadosResidenciais> dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public DadosResidenciais adicionarDadosResidenciais(DadosResidenciais dadosResidenciais) {
		getDadosResidenciais().add(dadosResidenciais);
		dadosResidenciais.setCidade(this);

		return dadosResidenciais;
	}

	public DadosResidenciais removerDadosResidenciais(DadosResidenciais dadosResidenciais) {
		getDadosResidenciais().remove(dadosResidenciais);
		dadosResidenciais.setCidade(null);

		return dadosResidenciais;
	}
}