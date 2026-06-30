<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="java.util.*, java.text.*" %> <%@ taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> <%@ taglib prefix="form"
uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <meta charset="UTF-8" />
    <title>Agregar Artista</title>
  </head>
  <body>
    <h1>Agregar Artista</h1>
    <form:form
      action="/artistas/procesa/agregar"
      method="post"
      modelAttribute="artista"
    >
      <div>
        <form:label path="nombre">Nombre:</form:label>
        <form:input path="nombre" />
        <form:errors path="nombre" cssClass="error" />
      </div>
      <div>
        <form:label path="apellido">Apellido:</form:label>
        <form:input path="apellido" />
        <form:errors path="apellido" cssClass="error" />
      </div>
      <div>
        <form:label path="biografia">Biografía:</form:label>
        <form:textarea path="biografia" />
        <form:errors path="biografia" cssClass="error" />
      </div>
      <div>
        <input type="submit" value="Guardar Artista" />
      </div>
    </form:form>
    <br />
    <a href="/artistas">Volver a lista de artistas</a>
  </body>
</html>
