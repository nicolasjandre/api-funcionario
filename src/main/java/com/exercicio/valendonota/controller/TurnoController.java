package com.exercicio.valendonota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exercicio.valendonota.controller.CRUD.CRUDController;
import com.exercicio.valendonota.domain.service.TurnoService;
import com.exercicio.valendonota.dto.TurnoDto.TurnoRequestDto;
import com.exercicio.valendonota.dto.TurnoDto.TurnoResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/turno")
public class TurnoController implements CRUDController<TurnoRequestDto, TurnoResponseDto> {

    @Autowired
    private TurnoService turnoService;

    @PostMapping
    @Operation(summary = "Cria um novo turno", description = "Campo 'tipoTurno' não pode ser nulo")
    public ResponseEntity<TurnoResponseDto> create(@Valid @RequestBody TurnoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.create(dto));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Deleta um turno", description = "Verifica se o ID passado no parâmetro existe. "
            + "Caso exista, deleta o turno do DB. Caso não exista, explode um NotFoundException")
    public ResponseEntity<TurnoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.findById(id));
    }

    @GetMapping
    @Operation(summary = "Retorna todos os turnos cadastrados")
    public ResponseEntity<List<TurnoResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(turnoService.findAll());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Retorna um turno específico pelo ID", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, retorna os dados deste turno. Caso contrário explode uma NotFoundException.")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        turnoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza todas as propriedades do turno", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, atualiza todas as propriedades do turno em questão, caso contrário explode uma NotFoundException.")
    public ResponseEntity<TurnoResponseDto> updateById(@Valid @RequestBody TurnoRequestDto dto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(turnoService.updateById(dto, id));
    }
}
