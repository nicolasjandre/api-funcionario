package com.exercicio.valendonota.dto.TurnoDto;

import com.exercicio.valendonota.domain.Enum.TipoTurno;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurnoRequestDto {

    @NotNull(message = "Campo 'tipoTurno' não pode ser nulo")
    private TipoTurno tipoTurno;
}
