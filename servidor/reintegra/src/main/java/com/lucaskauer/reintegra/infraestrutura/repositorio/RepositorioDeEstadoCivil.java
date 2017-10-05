package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskauer.reintegra.entidade.EstadoCivil;

public interface RepositorioDeEstadoCivil extends JpaRepository<EstadoCivil, Serializable> {
	EstadoCivil findByCodigo(String codigo);
}
