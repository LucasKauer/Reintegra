package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "DadosPessoais")
@NamedQuery(name = "DadosPessoais.findAll", query = "SELECT d FROM DadosPessoais d")
public class DadosPessoais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	@NotNull
	private long id;

	@Column(name = "Cpf")
	@NotNull
	private String cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "DataDeNascimento")
	@NotNull
	private Date dataDeNascimento;

	@Column(name = "Nome")
	@NotNull
	private String nome;

	@Column(name = "Rg")
	@NotNull
	private String rg;

	@Column(name = "Sexo")
	@NotNull
	private String sexo;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdNaturalidade")
	@NotNull
	private Cidade cidade;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdNacionalidade")
	@NotNull
	private Pais pais;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "IdEstadoCivil")
	@NotNull
	private EstadoCivil estadoCivil;

	@OneToMany(mappedBy = "dadosPessoais")
	@NotNull
	private List<Usuario> usuarios;

	public DadosPessoais() {
	}
	
	public DadosPessoais(String cpf, Date dataDeNascimento, String nome, String rg, String sexo, Cidade cidade,
			Pais pais, EstadoCivil estadoCivil) {
		super();
		this.cpf = cpf;
		this.dataDeNascimento = dataDeNascimento;
		this.nome = nome;
		this.rg = rg;
		this.sexo = sexo;
		this.cidade = cidade;
		this.pais = pais;
		this.estadoCivil = estadoCivil;
	}



	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataDeNascimento() {
		return this.dataDeNascimento;
	}

	public void setDataDeNascimento(Date dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return this.rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return this.sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Pais getPais() {
		return this.pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public EstadoCivil getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(EstadoCivil estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario adicionarUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDadosPessoais(this);

		return usuario;
	}

	public Usuario removerUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDadosPessoais(null);

		return usuario;
	}

}