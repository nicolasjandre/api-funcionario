package com.exercicio.valendonota.dto.CargoDto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequestDto {

    @NotBlank(message = "Campo 'nome' não pode estar vazio")
    private String nome;

    @NotNull(message = "Campo 'salario' não pode ser nulo")
    @DecimalMin(value = "1305", message = "Campo 'salario' não pode ser menor que 1305")
    private BigDecimal salario;
}
