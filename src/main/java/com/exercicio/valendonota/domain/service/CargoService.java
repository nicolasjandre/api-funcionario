package com.exercicio.valendonota.domain.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.valendonota.domain.exception.NotFoundException;
import com.exercicio.valendonota.domain.model.Cargo;
import com.exercicio.valendonota.domain.repository.CargoRepository;
import com.exercicio.valendonota.domain.service.CRUD.CRUDService;
import com.exercicio.valendonota.dto.CargoDto.CargoRequestDto;
import com.exercicio.valendonota.dto.CargoDto.CargoResponseDto;

@Service
public class CargoService implements CRUDService<CargoRequestDto, CargoResponseDto> {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ModelMapper mapper;

    @Override
    public CargoResponseDto create(CargoRequestDto dto) {

        Cargo cargo = cargoRepository.save(mapper.map(dto, Cargo.class));

        return mapper.map(cargo, CargoResponseDto.class);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        cargoRepository.deleteById(id);
    }

    @Override
    public List<CargoResponseDto> findAll() {
        return cargoRepository.findAll().stream()
                .map(cargo -> mapper.map(cargo, CargoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CargoResponseDto findById(Long id) {
        Optional<Cargo> cargoOpt = cargoRepository.findById(id);

        if (cargoOpt.isEmpty()) {
            throw new NotFoundException("Cargo de id=[" + id + "] não encontrado");
        }

        return mapper.map(cargoOpt.get(), CargoResponseDto.class);
    }

    @Override
    public CargoResponseDto updateById(CargoRequestDto dto, Long id) {
        this.findById(id);

        Cargo cargo = mapper.map(dto, Cargo.class);
        cargo.setId(id);

        return mapper.map(cargoRepository.save(cargo), CargoResponseDto.class);
    }
}
