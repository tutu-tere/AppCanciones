<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Detalle Artista</title>
</head>
<body>
  <h1>Detalle del Artista</h1>

  <p><strong>Nombre:</strong> ${artista.nombre}</p>
  <p><strong>Apellido:</strong> ${artista.apellido}</p>
  <p><strong>Biografía:</strong> ${artista.biografia}</p>
  <p><strong>Fecha creación:</strong> ${artista.fechaCreacion}</p>
  <p><strong>Fecha actualización:</strong> ${artista.fechaActualizacion}</p>

  <h2>Canciones del artista</h2>
  <ul>
    <c:forEach var="cancion" items="${artista.canciones}">
      <li>${cancion.titulo} (${cancion.album})</li>
    </c:forEach>
  </ul>

  <br>
  <a href="/artistas">Volver a lista de artistas</a>
</body>
</html>