package com.exercicio.valendonota.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.valendonota.domain.exception.NotFoundException;
import com.exercicio.valendonota.domain.model.Cargo;
import com.exercicio.valendonota.domain.model.Funcionario;
import com.exercicio.valendonota.domain.model.Turno;
import com.exercicio.valendonota.domain.repository.FuncionarioRepository;
import com.exercicio.valendonota.domain.service.CRUD.CRUDService;
import com.exercicio.valendonota.dto.FuncionarioDto.FuncionarioRequestDto;
import com.exercicio.valendonota.dto.FuncionarioDto.FuncionarioResponseDto;

@Service
public class FuncionarioService implements CRUDService<FuncionarioRequestDto, FuncionarioResponseDto> {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private TurnoService turnoService;

    @Autowired
    private ModelMapper mapper;

    @Override
    public FuncionarioResponseDto create(FuncionarioRequestDto dto) {
        Cargo cargo = mapper.map(cargoService.findById(dto.getCargoId()), Cargo.class);
        Turno turno = mapper.map(turnoService.findById(dto.getTurnoId()), Turno.class);

        Funcionario funcionario = Funcionario.builder()
                .cargo(cargo)
                .turno(turno)
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .build();

        return mapper.map(funcionarioRepository.save(funcionario), FuncionarioResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        funcionarioRepository.deleteById(id);
    }

    @Override
    public List<FuncionarioResponseDto> findAll() {
        return funcionarioRepository.findAll().stream()
                .map(funcionario -> mapper.map(funcionario, FuncionarioResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FuncionarioResponseDto findById(Long id) {
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(id);

        if (funcionarioOpt.isEmpty()) {
            throw new NotFoundException("Funcionario de id=[" + id + "] não encontrado");
        }

        return mapper.map(funcionarioOpt.get(), FuncionarioResponseDto.class);
    }

    @Override
    public FuncionarioResponseDto updateById(FuncionarioRequestDto dto, Long id) {
        this.findById(id);

        Cargo cargo = mapper.map(cargoService.findById(dto.getCargoId()), Cargo.class);
        Turno turno = mapper.map(turnoService.findById(dto.getTurnoId()), Turno.class);

        Funcionario funcionario = Funcionario.builder()
                .id(id)
                .cargo(cargo)
                .turno(turno)
                .cpf(dto.getCpf())
                .nome(dto.getNome())
                .build();

        return mapper.map(funcionarioRepository.save(funcionario), FuncionarioResponseDto.class);
    }
}
