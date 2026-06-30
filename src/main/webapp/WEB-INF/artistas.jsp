<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Lista de Artistas</title>
</head>
<body>
  <h1>Lista de Artistas</h1>

  <ul>
    <c:forEach var="artista" items="${listaArtistas}">
      <li>
        <a href="/artistas/detalle/${artista.id}">
          ${artista.nombre} ${artista.apellido}
        </a>
      </li>
    </c:forEach>
  </ul>
<a href="/artistas/formulario/agregar">Agregar nuevo artista</a>

  <br>
  <a href="/canciones">Ir a canciones</a>
</body>
</html>
