package com.exercicio.valendonota.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.exercicio.valendonota.domain.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
