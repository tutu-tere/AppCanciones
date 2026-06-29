<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Formulario</title>
    <link rel="stylesheet" href="/css/styleform.css" />
  </head>
  <body>
    <h1>Agrega tú canción</h1>

    <form:form
      action="/canciones/procesa/agregar"
      method="post"
      modelAttribute="cancion"
    >
      <div>
        <form:label path="titulo">Título:</form:label>
        <form:input path="titulo" />
        <form:errors path="titulo" cssClass="error" />
      </div>

      <div>
        <form:label path="artista">Artista:</form:label>
        <form:input path="artista" />
        <form:errors path="artista" cssClass="error" />
      </div>

      <div>
        <form:label path="album">Álbum:</form:label>
        <form:input path="album" />
        <form:errors path="album" cssClass="error" />
      </div>

      <div>
        <form:label path="genero">Género:</form:label>
        <form:input path="genero" />
        <form:errors path="genero" cssClass="error" />
      </div>

      <div>
        <form:label path="idioma">Idioma:</form:label>
        <form:input path="idioma" />
        <form:errors path="idioma" cssClass="error" />
      </div>

      <div>
        <input type="submit" value="Guardar Canción" />
      </div>
    </form:form>

    <br />
    <a href="/canciones">Volver al listado</a>
  </body>
</html>
