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
import com.exercicio.valendonota.domain.service.CargoService;
import com.exercicio.valendonota.dto.CargoDto.CargoRequestDto;
import com.exercicio.valendonota.dto.CargoDto.CargoResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/cargo")
public class CargoController implements CRUDController<CargoRequestDto, CargoResponseDto> {

    @Autowired
    private CargoService cargoService;

    @Override
    @PostMapping
    @Operation(summary = "Cria um novo cargo", description = "Campo 'nome' não pode estar vazio" +
            "<br>Campo 'salario' não pode ser nulo" +
            "<br>Campo 'salario' não pode ser menor que 1305")
    public ResponseEntity<CargoResponseDto> create(@Valid @RequestBody CargoRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.create(dto));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um cargo", description = "Verifica se o ID passado no parâmetro existe. "
            + "Caso exista, deleta o cargo do DB. Caso não exista, explode um NotFoundException")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        cargoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Override
    @GetMapping
    @Operation(summary = "Retorna todos os cargos cadastrados")
    public ResponseEntity<List<CargoResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Retorna um cargo específico pelo ID", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, retorna os dados deste cargo. Caso contrário explode uma NotFoundException.")
    public ResponseEntity<CargoResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(cargoService.findById(id));
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza todas as propriedades do cargo", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, atualiza todas as propriedades do cargo em questão, caso contrário explode uma NotFoundException.")
    public ResponseEntity<CargoResponseDto> updateById(@Valid @RequestBody CargoRequestDto dto, @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cargoService.updateById(dto, id));
    }
}
