package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskauer.reintegra.entidade.Pais;

public interface RepositorioDePais extends JpaRepository<Pais, Serializable> {
	Pais findByNome(String nome);
}
