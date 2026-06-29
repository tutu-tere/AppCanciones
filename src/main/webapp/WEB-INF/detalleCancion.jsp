<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Detalle</title>
  <link rel="stylesheet" href="/css/styledetalle.css">
  </head>
  <body>
    <h1>Detalle de cancion</h1>
    <div class="detalle-cancion">
      <p>${cancion.titulo}</p>
      <p>Artista: ${cancion.artista}</p>
      <p>Album: ${cancion.album}</p>
      <p>Genero: ${cancion.genero}</p>
      <p>Idioma: ${cancion.idioma}</p>
    </div>
    <a class="btn-editar" href="/canciones/formulario/editar/${cancion.id}">Editar Canción</a>

    <a href="/canciones">Volver a la lista de canciones</a>
  </body>
</html>
