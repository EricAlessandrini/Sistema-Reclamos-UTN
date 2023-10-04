<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Detalle del reclamo</h2>
Id: ${reclamo.id}<br>
Titulo: ${reclamo.titulo}<br>
Descripcion: ${reclamo.descripcion}<br>

<jsp:include page="../template_inferior.jsp"></jsp:include>
