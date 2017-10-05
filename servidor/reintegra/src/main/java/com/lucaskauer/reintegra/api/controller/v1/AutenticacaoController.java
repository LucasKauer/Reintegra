package com.lucaskauer.reintegra.api.controller.v1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucaskauer.reintegra.aplicacao.autenticacao.ServicoDeAutenticacao;
import com.lucaskauer.reintegra.aplicacao.autenticacao.models.UsuarioModel;
import com.lucaskauer.reintegra.aplicacao.autenticacao.request.LoginRequest;

@RestController()
@RequestMapping("api/v1/autenticacao")
public class AutenticacaoController {

	@Autowired
	private ServicoDeAutenticacao servicoAutenticacao;
	
	@PostMapping(value = "login", consumes = "application/json", produces = "application/json")
	public UsuarioModel login(@RequestBody LoginRequest login) throws Exception {
		return this.servicoAutenticacao.login(login);
	}
}
