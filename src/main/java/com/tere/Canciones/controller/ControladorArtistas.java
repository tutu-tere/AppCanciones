package com.tere.Canciones.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;

import com.tere.Canciones.models.Artista;
import com.tere.Canciones.services.ServicioArtistas;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.Valid;

@Controller
public class ControladorArtistas {
  @Autowired
  private ServicioArtistas servicio;

  @GetMapping("/artistas")
  public String desplegarArtistas(Model model) {
    model.addAttribute("listaArtistas", servicio.obtenerTodosLosArtistas());
    return "artistas.jsp";
  }

  @GetMapping("/artistas/detalle/{idArtista}")
  public String detalleArtista(@PathVariable Long idArtista, Model model) {
    Artista artista = servicio.obtenerArtistaPorId(idArtista);
    model.addAttribute("artista", artista);
    return "detalleArtista.jsp";
  }

  @GetMapping("/artistas/formulario/agregar")
  public String formularioAgregar(@ModelAttribute("artista") Artista artista) {
    return "agregarArtista.jsp";
  }

  @PostMapping("/artistas/procesa/agregar")
  public String procesarAgregar(@Valid @ModelAttribute("artista") Artista artista, BindingResult result) {
    if (result.hasErrors())
      return "agregarArtista.jsp";
    servicio.agregarArtista(artista);
    return "redirect:/artistas";
  }
}