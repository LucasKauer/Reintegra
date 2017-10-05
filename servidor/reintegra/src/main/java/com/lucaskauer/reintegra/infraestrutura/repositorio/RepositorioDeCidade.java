package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskauer.reintegra.entidade.Cidade;

public interface RepositorioDeCidade extends JpaRepository<Cidade, Serializable> {
	Cidade findByNome(String nome);	
}
