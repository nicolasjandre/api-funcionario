package com.exercicio.valendonota.dto.FuncionarioDto;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioRequestDto {

    @NotBlank(message = "Campo 'nome' não pode estar em branco")
    private String nome;

    @CPF(message = "Campo 'CPF' precisa possuir um CPF válido")
    @NotBlank(message = "Campo 'CPF' não pode estar vazio")
    private String cpf;

    @Min(value = 1, message = "Campo 'turnoId' não pode ser menor que 1")
    @NotNull(message = "Campo 'turnoId' não pode ser nulo")
    private Long turnoId;

    @Min(value = 1, message = "Campo 'cargoId' não pode ser menor que 1")
    @NotNull(message = "Campo 'cargoId' não pode ser nulo")
    private Long cargoId;
}
