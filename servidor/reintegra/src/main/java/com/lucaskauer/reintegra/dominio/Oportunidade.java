package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Oportunidade.findAll", query = "SELECT o FROM Oportunidade o")
public class Oportunidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataDaPublicacao")
	@NotNull
	private Date dataDaPublicacao;

	@Column(name = "Descricao")
	@NotNull
	private String descricao;

	@Column(name = "Titulo")
	@NotNull
	private String titulo;

	@OneToMany(mappedBy = "oportunidade")
	@NotNull
	private List<FuncaoTrabalho> funcaoTrabalhos;

	@ManyToOne
	@JoinColumn(name = "IdDadosResidenciais")
	@NotNull
	private DadosResidenciais dadosResidenciais;

	@ManyToMany(mappedBy = "oportunidades")
	@NotNull
	private List<Beneficio> beneficios;

	@ManyToMany(mappedBy = "oportunidades")
	@NotNull
	private List<NivelExperiencia> nivelExperiencias;

	@ManyToMany(mappedBy = "oportunidades")
	@NotNull
	private List<TipoEmprego> tipoEmpregos;

	@ManyToMany
	@JoinTable(name = "SetorOportunidade", joinColumns = {
			@JoinColumn(name = "IdOportunidade") }, inverseJoinColumns = { @JoinColumn(name = "IdSetor") })
	@NotNull
	private List<Setor> setors;

	public Oportunidade() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataDaPublicacao() {
		return this.dataDaPublicacao;
	}

	public void setDataDaPublicacao(Date dataDaPublicacao) {
		this.dataDaPublicacao = dataDaPublicacao;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<FuncaoTrabalho> getFuncaoTrabalhos() {
		return this.funcaoTrabalhos;
	}

	public void setFuncaoTrabalhos(List<FuncaoTrabalho> funcaoTrabalhos) {
		this.funcaoTrabalhos = funcaoTrabalhos;
	}

	public FuncaoTrabalho adicionarFuncaoTrabalho(FuncaoTrabalho funcaoTrabalho) {
		getFuncaoTrabalhos().add(funcaoTrabalho);
		funcaoTrabalho.setOportunidade(this);

		return funcaoTrabalho;
	}

	public FuncaoTrabalho removerFuncaoTrabalho(FuncaoTrabalho funcaoTrabalho) {
		getFuncaoTrabalhos().remove(funcaoTrabalho);
		funcaoTrabalho.setOportunidade(null);

		return funcaoTrabalho;
	}

	public DadosResidenciais getDadosResidenciais() {
		return this.dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciais dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public List<Beneficio> getBeneficios() {
		return this.beneficios;
	}

	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}

	public List<NivelExperiencia> getNivelExperiencias() {
		return this.nivelExperiencias;
	}

	public void setNivelExperiencias(List<NivelExperiencia> nivelExperiencias) {
		this.nivelExperiencias = nivelExperiencias;
	}

	public List<TipoEmprego> getTipoEmpregos() {
		return this.tipoEmpregos;
	}

	public void setTipoEmpregos(List<TipoEmprego> tipoEmpregos) {
		this.tipoEmpregos = tipoEmpregos;
	}

	public List<Setor> getSetors() {
		return this.setors;
	}

	public void setSetors(List<Setor> setors) {
		this.setors = setors;
	}

}