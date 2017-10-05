package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@NamedQuery(name = "PreRequisito.findAll", query = "SELECT p FROM PreRequisito p")
public class PreRequisito implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "Descricao", length = 200)
	@NotNull
	@Size(min = 4)
	private String descricao;

	@Column(name = "Titulo", length = 100)
	@NotNull
	@Size(min = 4)
	private String titulo;

	@ManyToMany
	@JoinTable(name = "CursoPreRequisito", joinColumns = {
			@JoinColumn(name = "IdPreRequisito") }, inverseJoinColumns = { @JoinColumn(name = "IdCurso") })
	@NotNull
	private List<Curso> cursos;

	public PreRequisito() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}