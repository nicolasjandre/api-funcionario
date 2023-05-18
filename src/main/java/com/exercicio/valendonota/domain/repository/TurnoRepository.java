package com.exercicio.valendonota.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.valendonota.domain.model.Turno;

public interface TurnoRepository extends JpaRepository<Turno, Long> {
    
}
