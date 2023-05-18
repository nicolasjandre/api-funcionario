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
import com.exercicio.valendonota.domain.service.FuncionarioService;
import com.exercicio.valendonota.dto.FuncionarioDto.FuncionarioRequestDto;
import com.exercicio.valendonota.dto.FuncionarioDto.FuncionarioResponseDto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController implements CRUDController<FuncionarioRequestDto, FuncionarioResponseDto> {

    @Autowired
    private FuncionarioService funcionarioService;

    @Override
    @PostMapping
    @Operation(summary = "Cria um novo funcionário", description = "Campo 'nome' não pode estar em branco" +
            "<br>Campo 'CPF' precisa possuir um CPF válido" +
            "<br>Campo 'CPF' não pode estar vazio" +
            "<br>Campo 'turnoId' não pode ser nulo" +
            "<br>Campo 'cargoId' não pode ser nulo" +
            "Campo 'turnoId' não pode ser menor que 1" +
            "Campo 'cargoId' não pode ser menor que 1")
    public ResponseEntity<FuncionarioResponseDto> create(@Valid @RequestBody FuncionarioRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.create(dto));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um funcionário", description = "Verifica se o ID passado no parâmetro existe. "
            + "Caso exista, deleta o funcionário do DB. Caso não exista, explode um NotFoundException")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        funcionarioService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

    @Override
    @GetMapping
    @Operation(summary = "Retorna todos os funcionários cadastrados")
    public ResponseEntity<List<FuncionarioResponseDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Retorna um funcionário específico pelo ID", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, retorna os dados deste funcionário. Caso contrário explode uma NotFoundException.")
    public ResponseEntity<FuncionarioResponseDto> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(funcionarioService.findById(id));
    }

    @Override
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza todas as propriedades do funcionário", description = "Verifica se o ID passado no parâmetro existe."
            + "<br>Se sim, atualiza todas as propriedades do funcionário em questão, caso contrário explode uma NotFoundException.")
    public ResponseEntity<FuncionarioResponseDto> updateById(@Valid @RequestBody FuncionarioRequestDto dto,
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioService.updateById(dto, id));
    }
}