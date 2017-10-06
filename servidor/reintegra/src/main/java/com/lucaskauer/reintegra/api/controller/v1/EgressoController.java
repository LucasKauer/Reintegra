package com.lucaskauer.reintegra.api.controller.v1;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucaskauer.reintegra.aplicacao.egresso.ServicoDeEgresso;
import com.lucaskauer.reintegra.aplicacao.egresso.model.EgressoModel;
import com.lucaskauer.reintegra.aplicacao.egresso.request.AtualizarEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.InserirEgressoRequest;
import com.lucaskauer.reintegra.aplicacao.egresso.request.PesquisarEgressoRequest;

@RestController
@RequestMapping(value = "api/v1/egresso", consumes = "application/json", produces = "application/json")
public class EgressoController {

	@Autowired
	private ServicoDeEgresso servicoDeEgresso;

	@GetMapping("{id}")
	public ResponseEntity<?> pesquisar(@PathVariable long id) throws Exception {
		EgressoModel egresso = this.servicoDeEgresso.pesquisar(id);
		return ResponseEntity.ok(egresso);
	}

	@GetMapping
	public ResponseEntity<?> pesquisar(@RequestParam(required = false) PesquisarEgressoRequest request)
			throws Exception {
		List<EgressoModel> egressos = this.servicoDeEgresso.pesquisar(request);
		return ResponseEntity.ok(egressos);
	}

	@PostMapping
	public ResponseEntity<?> inserir(@RequestBody InserirEgressoRequest request) throws Exception {
		long id = this.servicoDeEgresso.inserir(request);

		String url = String.format("api/v1/usuario/%s", id);
		return ResponseEntity.created(new URI(url)).build();
	}

	@PutMapping
	public ResponseEntity<?> atualizar(@RequestBody AtualizarEgressoRequest request) throws Exception {
		this.servicoDeEgresso.atualizar(request);
		return ResponseEntity.accepted().build();
	}

	@DeleteMapping("{id}")
	public ResponseEntity<?> inativar(@PathVariable long id) throws Exception {
		this.servicoDeEgresso.inativar(id);
		return ResponseEntity.accepted().build();
	}

}
