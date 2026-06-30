package com.tere.Canciones.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tere.Canciones.models.Artista;

@Repository

public interface RepositorioArtistas extends CrudRepository<Artista, Long> {
  List<Artista> findAll();
}
