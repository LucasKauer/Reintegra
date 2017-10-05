package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "CargaHoraria")
	@NotNull
	private int cargaHoraria;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataFim")
	@NotNull
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataInicio")
	@NotNull
	private Date dataInicio;

	@Column(name = "Encerrado")
	@NotNull
	private byte encerrado;

	@Column(name = "NumeroDeVagas")
	@NotNull
	private int numeroDeVagas;

	@Column(name = "Resumo")
	@NotNull
	private String resumo;

	@Column(name = "Titulo")
	@NotNull
	private String titulo;

	@ManyToMany(mappedBy = "cursos")
	@NotNull
	private List<Modulo> modulos;

	@ManyToMany(mappedBy = "cursos")
	@NotNull
	private List<PreRequisito> preRequisitos;

	public Curso() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
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

	public byte getEncerrado() {
		return this.encerrado;
	}

	public void setEncerrado(byte encerrado) {
		this.encerrado = encerrado;
	}

	public int getNumeroDeVagas() {
		return this.numeroDeVagas;
	}

	public void setNumeroDeVagas(int numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
	}

	public String getResumo() {
		return this.resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<Modulo> getModulos() {
		return this.modulos;
	}

	public void setModulos(List<Modulo> modulos) {
		this.modulos = modulos;
	}

	public List<PreRequisito> getPreRequisitos() {
		return this.preRequisitos;
	}

	public void setPreRequisitos(List<PreRequisito> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}

}