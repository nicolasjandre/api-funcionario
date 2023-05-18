package com.exercicio.valendonota.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.valendonota.domain.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
