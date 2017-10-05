package com.lucaskauer.reintegra.dominio;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.List;

@Entity
@NamedQuery(name = "DadosContato.findAll", query = "SELECT d FROM DadosContato d")
public class DadosContato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Email")
	@NotNull
	private String email;

	@Column(name = "TelefoneCelular")
	@NotNull
	private String telefoneCelular;

	@Column(name = "TelefoneCelularRecado")
	@NotNull
	private String telefoneCelularRecado;

	@OneToMany(mappedBy = "dadosContato")
	@NotNull
	private List<Usuario> usuarios;

	public DadosContato() {
	}

	public DadosContato(String email, String telefoneCelular, String telefoneCelularRecado) {
		super();
		this.email = email;
		this.telefoneCelular = telefoneCelular;
		this.telefoneCelularRecado = telefoneCelularRecado;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefoneCelular() {
		return this.telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneCelularRecado() {
		return this.telefoneCelularRecado;
	}

	public void setTelefoneCelularRecado(String telefoneCelularRecado) {
		this.telefoneCelularRecado = telefoneCelularRecado;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario adicionarUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDadosContato(this);

		return usuario;
	}

	public Usuario removerUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDadosContato(null);

		return usuario;
	}

}