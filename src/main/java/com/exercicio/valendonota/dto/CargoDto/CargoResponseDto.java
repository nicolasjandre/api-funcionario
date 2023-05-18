package com.exercicio.valendonota.dto.CargoDto;

import java.math.BigDecimal;
import java.util.List;

import com.exercicio.valendonota.domain.model.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoResponseDto {

    private Long id;

    private String nome;

    private BigDecimal salario;

    @JsonIgnoreProperties({ "cargo" })
    private List<Funcionario> funcionarios;
}
