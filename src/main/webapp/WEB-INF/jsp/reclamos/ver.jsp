<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2 class="mt-3">Detalle del reclamo</h2>
<div class="mt-3 lh-lg">
	Id: ${reclamo.id}<br>
	Titulo: ${reclamo.titulo}<br>
	Descripcion: ${reclamo.descripcion}<br>
</div>

<jsp:include page="../template_inferior.jsp"></jsp:include>
