package com.lucaskauer.reintegra.aplicacao.autenticacao;

import org.springframework.stereotype.Service;

import com.lucaskauer.reintegra.aplicacao.autenticacao.models.UsuarioModel;
import com.lucaskauer.reintegra.aplicacao.autenticacao.request.LoginRequest;

@Service
public class ServicoDeAutenticacaoImpl implements ServicoDeAutenticacao {

	public ServicoDeAutenticacaoImpl() {
	}
	
	@Override
	public UsuarioModel login(LoginRequest login) throws Exception {
		if (login.getNome().equals("spiderman") && login.getSenha().equals("aaa123"))
		{
			return new UsuarioModel();
		}
		
		throw new Exception("O usuário não está cadastrado no sistema.");
	}
}
