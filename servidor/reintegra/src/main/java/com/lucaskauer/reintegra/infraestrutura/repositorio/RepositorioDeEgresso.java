package com.lucaskauer.reintegra.infraestrutura.repositorio;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.lucaskauer.reintegra.entidade.Egresso;

public interface RepositorioDeEgresso extends JpaRepository<Egresso, Serializable> {

	@Transactional
	@Modifying
	@Query(value = "UPDATE Usuario u SET u.Ativo = 0 WHERE u.Id = :id", nativeQuery = true)
	void inativar(@Param("id") long id);

}
