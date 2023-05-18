package com.exercicio.valendonota.domain.service.CRUD;

import java.util.List;

public interface CRUDService<Req, Res> {

    Res create(Req dto);

    Res updateById(Req dto, Long id);

    List<Res> findAll();

    Res findById(Long id);

    void deleteById(Long id);
}
