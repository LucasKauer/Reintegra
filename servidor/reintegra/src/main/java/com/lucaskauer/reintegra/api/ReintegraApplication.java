package com.lucaskauer.reintegra.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.lucaskauer.reintegra")
@EntityScan("com.lucaskauer.reintegra.entidade")
@EnableJpaRepositories("com.lucaskauer.reintegra.infraestrutura.repositorio")
public class ReintegraApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReintegraApplication.class, args);
	}
}
