package com.lucaskauer.reintegra.entidade;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.List;

@Entity
@Table(name = "DadosResidenciais")
@NamedQuery(name = "DadosResidenciais.findAll", query = "SELECT d FROM DadosResidenciais d")
public class DadosResidenciais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private long id;

	@Column(name = "Bairro", length = 100)
	@NotNull
	@Size(min = 4)
	private String bairro;

	@Column(name = "Cep", length = 8)
	@NotNull
	@Size(min = 8, max = 8)
	private String cep;

	@Column(name = "Complemento", length = 200)
	private String complemento;

	@Column(name = "Endereco", length = 100)
	@NotNull
	@Size(min = 4)
	private String endereco;

	@Column(name = "Numero")
	@NotNull
	private int numero;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "IdCidade")
	@NotNull
	private Cidade cidade;

	@OneToMany(mappedBy = "dadosResidenciais")
	private List<Oportunidade> oportunidades;

	@OneToMany(mappedBy = "dadosResidenciais")
	@NotNull
	private List<Usuario> usuarios;

	public DadosResidenciais() {
	}

	public DadosResidenciais(String bairro, String cep, String complemento, String endereco, int numero,
			Cidade cidade) {
		super();
		this.bairro = bairro;
		this.cep = cep;
		this.complemento = complemento;
		this.endereco = endereco;
		this.numero = numero;
		this.cidade = cidade;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return this.cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getEndereco() {
		return this.endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Oportunidade> getOportunidades() {
		return this.oportunidades;
	}

	public void setOportunidades(List<Oportunidade> oportunidades) {
		this.oportunidades = oportunidades;
	}

	public Oportunidade adicionarOportunidade(Oportunidade oportunidade) {
		getOportunidades().add(oportunidade);
		oportunidade.setDadosResidenciais(this);

		return oportunidade;
	}

	public Oportunidade removerOportunidade(Oportunidade oportunidade) {
		getOportunidades().remove(oportunidade);
		oportunidade.setDadosResidenciais(null);

		return oportunidade;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario adicionarUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setDadosResidenciais(this);

		return usuario;
	}

	public Usuario removerUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setDadosResidenciais(null);

		return usuario;
	}

}