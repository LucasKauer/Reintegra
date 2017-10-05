package com.lucaskauer.reintegra.aplicacao.autenticacao;

import com.lucaskauer.reintegra.aplicacao.autenticacao.models.UsuarioModel;
import com.lucaskauer.reintegra.aplicacao.autenticacao.request.LoginRequest;

public interface ServicoDeAutenticacao {
	UsuarioModel login(LoginRequest login) throws Exception;
}
