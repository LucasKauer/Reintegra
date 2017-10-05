package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucaskauer.reintegra.entidade.Egresso;

public interface RepositorioDeEgresso extends JpaRepository<Egresso, Serializable> {

}
