package com.exercicio.valendonota.domain.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funcionario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "funcionario_id")
    private Long id;

    private String nome;

    @Column(unique = true)
    private String cpf;

    @JoinColumn(name = "turno_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "funcionarios" })
    private Turno turno;

    @JoinColumn(name = "cargo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({ "funcionarios" })
    private Cargo cargo;
}