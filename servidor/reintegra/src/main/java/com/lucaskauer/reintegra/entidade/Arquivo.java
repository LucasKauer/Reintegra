package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@NamedQuery(name = "Arquivo.findAll", query = "SELECT a FROM Arquivo a")
public class Arquivo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Caminho")
	@NotNull
	private String caminho;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataUpload")
	@NotNull
	private Date dataUpload;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@OneToMany(mappedBy = "arquivo")
	@NotNull
	private List<Curriculo> curriculos;

	public Arquivo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCaminho() {
		return this.caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public Date getDataUpload() {
		return this.dataUpload;
	}

	public void setDataUpload(Date dataUpload) {
		this.dataUpload = dataUpload;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curriculo> getCurriculos() {
		return this.curriculos;
	}

	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}

	public Curriculo adicionarCurriculo(Curriculo curriculo) {
		getCurriculos().add(curriculo);
		curriculo.setArquivo(this);

		return curriculo;
	}

	public Curriculo removerCurriculo(Curriculo curriculo) {
		getCurriculos().remove(curriculo);
		curriculo.setArquivo(null);

		return curriculo;
	}

}