package com.exercicio.valendonota.dto.TurnoDto;

import java.util.List;

import com.exercicio.valendonota.domain.Enum.TipoTurno;
import com.exercicio.valendonota.domain.model.Funcionario;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoResponseDto {
    
    private Long id;

    private TipoTurno tipoTurno;

    private String horaEntrada;

    private String horaSaida;

    private String horaDescanso;

    private Integer duracaoDescanso;

    @JsonIgnoreProperties({"turno"})
    private List<Funcionario> funcionarios;
}
