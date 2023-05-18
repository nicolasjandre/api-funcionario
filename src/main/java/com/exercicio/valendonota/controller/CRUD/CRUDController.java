package com.exercicio.valendonota.controller.CRUD;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface CRUDController<Req, Res> {

    ResponseEntity<Res> create(Req dto);

    ResponseEntity<Res> findById(Long id);

    ResponseEntity<List<Res>> findAll();

    ResponseEntity<Void> deleteById(Long id);

    ResponseEntity<Res> updateById(Req dto, Long id);
}
