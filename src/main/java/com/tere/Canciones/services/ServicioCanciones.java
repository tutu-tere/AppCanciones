package com.tere.Canciones.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tere.Canciones.repo.RepositorioCanciones;
import com.tere.Canciones.models.Cancion;

import java.util.List;

@Service
public class ServicioCanciones {

  @Autowired
  private RepositorioCanciones repoCanciones;

  public List<Cancion> obtenerTodasLasCanciones() {
    return this.repoCanciones.findAll();
  }

  public Cancion obtenerCancionPorId(Long id) {
    return repoCanciones.findById(id).orElse(null);
  }

  public Cancion agregarCancion(Cancion cancion) {
    return repoCanciones.save(cancion);
  }

  public Cancion actualizaCancion(Cancion cancion) {
    return repoCanciones.save(cancion);
  }

  public void eliminaCancion(Long id) {
    this.repoCanciones.deleteById(id);
  }

}
