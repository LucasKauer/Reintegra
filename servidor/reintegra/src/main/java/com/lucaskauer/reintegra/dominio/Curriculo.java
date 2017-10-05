package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQuery(name = "Curriculo.findAll", query = "SELECT c FROM Curriculo c")
public class Curriculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Idioma")
	@NotNull
	private String idioma;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@ManyToOne
	@JoinColumn(name = "IdArquivo")
	@NotNull
	private Arquivo arquivo;

	@ManyToOne
	@JoinColumn(name = "IdUsuarioEgresso")
	@NotNull
	private Egresso egresso;

	public Curriculo() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIdioma() {
		return this.idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Arquivo getArquivo() {
		return this.arquivo;
	}

	public void setArquivo(Arquivo arquivo) {
		this.arquivo = arquivo;
	}

	public Egresso getEgresso() {
		return this.egresso;
	}

	public void setEgresso(Egresso egresso) {
		this.egresso = egresso;
	}

}