package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Modulo.findAll", query = "SELECT m FROM Modulo m")
public class Modulo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataFim")
	@NotNull
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataInicio")
	@NotNull
	private Date dataInicio;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@ManyToMany
	@JoinTable(name = "CursoModulo", joinColumns = { @JoinColumn(name = "IdModulo") }, inverseJoinColumns = {
			@JoinColumn(name = "IdCurso") })
	@NotNull
	private List<Curso> cursos;

	public Modulo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getDataFim() {
		return this.dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataInicio() {
		return this.dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}