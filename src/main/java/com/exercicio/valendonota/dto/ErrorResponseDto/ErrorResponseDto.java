package com.exercicio.valendonota.dto.ErrorResponseDto;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {

    private String message;

    private HttpStatus httpStatus;

    private Integer statusCode;

}
