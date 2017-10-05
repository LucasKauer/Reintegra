package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskauer.reintegra.entidade.Perfil;

public interface RepositorioDePerfil extends JpaRepository<Perfil, Serializable> {
	Perfil findByCodigo(String codigo);
}
