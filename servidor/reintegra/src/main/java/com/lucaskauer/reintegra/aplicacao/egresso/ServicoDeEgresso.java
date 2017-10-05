package com.lucaskauer.reintegra.aplicacao.egresso;

import java.util.List;

import com.lucaskauer.reintegra.aplicacao.egresso.model.EgressoModel;
import com.lucaskauer.reintegra.aplicacao.egresso.request.AtualizarEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.DeletarEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.InserirEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.PesquisarEgressoRequest;

public interface ServicoDeEgresso {
	EgressoModel pesquisar(long id) throws Exception;
	List<EgressoModel> pesquisar(PesquisarEgressoRequest request) throws Exception;
	long inserir(InserirEgressoRequest request) throws Exception;
	void atualizar(AtualizarEgressoRequest request) throws Exception;
	void deletar(DeletarEgressoRequest request) throws Exception;
}
