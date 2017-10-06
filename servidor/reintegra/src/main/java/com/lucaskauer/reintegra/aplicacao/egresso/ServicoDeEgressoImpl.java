package com.lucaskauer.reintegra.aplicacao.egresso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucaskauer.reintegra.aplicacao.egresso.model.EgressoModel;
import com.lucaskauer.reintegra.aplicacao.egresso.request.AtualizarEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.InserirEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.PesquisarEgressoRequest;
import com.lucaskauer.reintegra.entidade.Cidade;
import com.lucaskauer.reintegra.entidade.Egresso;
import com.lucaskauer.reintegra.entidade.EstadoCivil;
import com.lucaskauer.reintegra.entidade.Pais;
import com.lucaskauer.reintegra.entidade.Perfil;
import com.lucaskauer.reintegra.entidade.Usuario;
import com.lucaskauer.reintegra.infraestrutura.repositorio.RepositorioDeCidade;
import com.lucaskauer.reintegra.infraestrutura.repositorio.RepositorioDeEgresso;
import com.lucaskauer.reintegra.infraestrutura.repositorio.RepositorioDeEstadoCivil;
import com.lucaskauer.reintegra.infraestrutura.repositorio.RepositorioDePais;
import com.lucaskauer.reintegra.infraestrutura.repositorio.RepositorioDePerfil;

@Service
public class ServicoDeEgressoImpl implements ServicoDeEgresso {

	@Autowired
	private RepositorioDeEgresso repositorioDeEgresso;
	
	@Autowired
	private RepositorioDeCidade repositorioDeCidade;
	
	@Autowired
	private RepositorioDePais repositorioDePais;
	
	@Autowired
	private RepositorioDeEstadoCivil repositorioDeEstadoCivil;
	
	@Autowired
	private RepositorioDePerfil repositorioDePerfil;
	
	@Override
	public EgressoModel pesquisar(long id) throws Exception {
		Egresso egresso = repositorioDeEgresso.findOne(id);
		return new EgressoModel(egresso);
	}

	@Override
	public List<EgressoModel> pesquisar(PesquisarEgressoRequest request) throws Exception {
		List<Egresso> egressos = repositorioDeEgresso.findAll();
		return egressos.stream().map(u -> new EgressoModel(u)).collect(Collectors.toList());
	}
	
	@Override
	public long inserir(InserirEgressoRequest request) throws Exception {	
		Egresso egresso = request.ParaEntidade();
		
		Cidade naturalidade =
			this.repositorioDeCidade.findByNome(egresso.getDadosPessoais().getCidade().getNome());;
		Pais nacionalidade =
			this.repositorioDePais.findByNome(egresso.getDadosPessoais().getPais().getNome());
		
		EstadoCivil estadoCivil =
				this.repositorioDeEstadoCivil.findByCodigo(egresso.getDadosPessoais().getEstadoCivil().getCodigo());
		
		egresso.getDadosPessoais().setCidade(naturalidade);
		egresso.getDadosPessoais().setPais(nacionalidade);
		egresso.getDadosPessoais().setEstadoCivil(estadoCivil);
		
		Cidade cidade =
			this.repositorioDeCidade.findByNome(egresso.getDadosResidenciais().getCidade().getNome());
		
		egresso.getDadosResidenciais().setCidade(cidade);
		
		Perfil perfil =
			this.repositorioDePerfil.findByCodigo(egresso.getPerfil().getCodigo());
		
		egresso.setPerfil(perfil);
		
		List<Usuario> usuarios = new ArrayList<>();
		usuarios.add(egresso);
		
		egresso.getDadosContato().setUsuarios(usuarios);
		egresso.getDadosPessoais().setUsuarios(usuarios);
		egresso.getDadosResidenciais().setUsuarios(usuarios);
		
		egresso = this.repositorioDeEgresso.save(egresso);
		return egresso.getId();
	}

	@Override
	public void atualizar(AtualizarEgressoRequest request) throws Exception {
		// TODO: implementar atualizacao de egresso do BD
	}

	@Override
	public void inativar(long id) throws Exception {
		this.repositorioDeEgresso.inativar(id);
	}

}
