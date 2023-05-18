package com.exercicio.valendonota.dto.FuncionarioDto;

import com.exercicio.valendonota.domain.model.Cargo;
import com.exercicio.valendonota.domain.model.Turno;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioResponseDto {

    private Long id;

    private String nome;

    private String cpf;

    @JsonIgnoreProperties({ "funcionarios", "id" })
    private Turno turno;

    @JsonIgnoreProperties({ "funcionarios", "id" })
    private Cargo cargo;
}
