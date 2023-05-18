package com.exercicio.valendonota.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.valendonota.domain.exception.NotFoundException;
import com.exercicio.valendonota.domain.model.Turno;
import com.exercicio.valendonota.domain.repository.TurnoRepository;
import com.exercicio.valendonota.domain.service.CRUD.CRUDService;
import com.exercicio.valendonota.dto.TurnoDto.TurnoRequestDto;
import com.exercicio.valendonota.dto.TurnoDto.TurnoResponseDto;

@Service
public class TurnoService implements CRUDService<TurnoRequestDto, TurnoResponseDto> {

    @Autowired
    private TurnoRepository turnoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public TurnoResponseDto create(TurnoRequestDto dto) {

        Turno turno = new Turno(dto.getTipoTurno());

        turno = turnoRepository.save(turno);

        return mapper.map(turno, TurnoResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        turnoRepository.deleteById(id);
    }

    @Override
    public List<TurnoResponseDto> findAll() {
        return turnoRepository.findAll().stream()
                .map(turno -> mapper.map(turno, TurnoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TurnoResponseDto findById(Long id) {
        Optional<Turno> turnoOpt = turnoRepository.findById(id);

        if (turnoOpt.isEmpty()) {
            throw new NotFoundException("Turno de id=[" + id + "] não encontrado");
        }

        return mapper.map(turnoOpt.get(), TurnoResponseDto.class);
    }

    @Override
    public TurnoResponseDto updateById(TurnoRequestDto dto, Long id) {
        this.findById(id);

        Turno turno = new Turno(dto.getTipoTurno());
        turno.setId(id);
        
        turnoRepository.save(turno);

        return mapper.map(turno, TurnoResponseDto.class);
    }
}
