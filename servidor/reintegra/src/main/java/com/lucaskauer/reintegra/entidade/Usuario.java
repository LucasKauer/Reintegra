package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Usuario")
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public abstract class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Apelido")
	@NotNull
	private String apelido;

	@Column(name = "Email")
	@NotNull
	private String email;

	@Column(name = "Senha")
	@NotNull
	private String senha;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDadosPessoais")
	@NotNull
	private DadosPessoais dadosPessoais;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdPerfil")
	@NotNull
	private Perfil perfil;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDadosResidenciais")
	@NotNull
	private DadosResidenciais dadosResidenciais;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdDadosContato")
	@NotNull
	private DadosContato dadosContato;

	public Usuario() {
	}

	public Usuario(String apelido, String email, String senha, DadosPessoais dadosPessoais, Perfil perfil,
			DadosResidenciais dadosResidenciais, DadosContato dadosContato) {
		super();
		this.apelido = apelido;
		this.email = email;
		this.senha = senha;
		this.dadosPessoais = dadosPessoais;
		this.perfil = perfil;
		this.dadosResidenciais = dadosResidenciais;
		this.dadosContato = dadosContato;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getApelido() {
		return this.apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return this.senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public DadosPessoais getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public Perfil getPerfil() {
		return this.perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public DadosResidenciais getDadosResidenciais() {
		return this.dadosResidenciais;
	}

	public void setDadosResidenciais(DadosResidenciais dadosResidenciais) {
		this.dadosResidenciais = dadosResidenciais;
	}

	public DadosContato getDadosContato() {
		return this.dadosContato;
	}

	public void setDadosContato(DadosContato dadosContato) {
		this.dadosContato = dadosContato;
	}

}