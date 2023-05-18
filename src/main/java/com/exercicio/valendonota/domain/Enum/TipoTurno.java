package com.exercicio.valendonota.domain.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum TipoTurno {
    MANHA("06:00", "11:00", "14:00"),
    TARDE("14:00", "19:00", "22:00"),
    NOITE("22:00", "03:00", "06:00");

    private String horarioEntrada;
    private String horarioDescanso;
    private String horarioSaida;
}