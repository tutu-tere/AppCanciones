package com.tere.Canciones.controller;

import com.tere.Canciones.services.ServicioArtistas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tere.Canciones.models.Artista;
import com.tere.Canciones.models.Cancion;
import com.tere.Canciones.services.ServicioCanciones;

import jakarta.validation.Valid;

@Controller
public class ControladorCanciones {

  @Autowired
  private ServicioCanciones servicioCanciones;

  @Autowired
  private ServicioArtistas servicioArtistas;

  @GetMapping("/canciones")
  public String desplegarCanciones(Model model) {
    model.addAttribute("listaCanciones", servicioCanciones.obtenerTodasLasCanciones());
    return "canciones.jsp";
  }

  @GetMapping("/canciones/detalle/{idCancion}")
  public String desplegarDetalleCancion(@PathVariable("idCancion") Long idCancion, Model model) {
    Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
    model.addAttribute("cancion", cancion);
    return "detalleCancion.jsp";
  }

  @GetMapping("/canciones/formulario/agregar")
  public String formularioAgregarCancion(@ModelAttribute("cancion") Cancion cancion, Model model) {
    model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas()); // ✅ plural
    return "agregarCancion.jsp";
  }

  @PostMapping("/canciones/procesa/agregar")
  public String procesarAgregarCancion(@Valid @ModelAttribute("cancion") Cancion cancion,
      BindingResult result,
      @RequestParam("artistaId") Long artistaId,
      Model model) {
    if (result.hasErrors()) {
      model.addAttribute("listaArtistas", servicioArtistas.obtenerTodosLosArtistas());
      return "agregarCancion.jsp";
    }
    Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
    cancion.setArtista(artista);
    servicioCanciones.agregarCancion(cancion);
    return "redirect:/canciones";
  }

  @GetMapping("/canciones/formulario/editar/{idCancion}")
  public String formularioEditarCancion(@PathVariable("idCancion") Long idCancion, Model model) {
    Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
    if (cancion == null) {
      return "redirect:/canciones";
    }
    model.addAttribute("cancion", cancion);
    return "editarCancion.jsp";
  }

  @PostMapping("/canciones/procesa/editar/{idCancion}")
  public String procesarEditarCancion(
      @PathVariable("idCancion") Long idCancion,
      @Valid @ModelAttribute("cancion") Cancion cancion,
      BindingResult result) {

    if (result.hasErrors()) {
      return "editarCancion.jsp";
    }

    cancion.setId(idCancion);
    servicioCanciones.actualizaCancion(cancion);

    return "redirect:/canciones";
  }

  @DeleteMapping("/canciones/procesa/eliminar/{idCancion}")
  public String procesarEliminarCancion(@PathVariable("idCancion") Long idCancion) {
    servicioCanciones.eliminaCancion(idCancion);
    return "redirect:/canciones";
  }
}
