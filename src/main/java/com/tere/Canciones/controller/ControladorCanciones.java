package com.tere.Canciones.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tere.Canciones.models.Cancion;
import com.tere.Canciones.services.ServicioCanciones;

@Controller
public class ControladorCanciones {

  @Autowired
  private ServicioCanciones servicio;

  @GetMapping("/canciones")
  public String desplegarCanciones(Model model) {
    model.addAttribute("listaCanciones", servicio.obtenerTodasLasCanciones());
    return "canciones.jsp";
  }

  @GetMapping("/canciones/detalle/{idCancion}")
  public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
    Cancion cancion = servicio.obtenerCancionPorId(idCancion);
    model.addAttribute("cancion", cancion);
    return "detalleCancion.jsp";
  }
}
