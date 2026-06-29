package com.tere.Canciones.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tere.Canciones.models.Cancion;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {

  List<Cancion> findAll();
}
