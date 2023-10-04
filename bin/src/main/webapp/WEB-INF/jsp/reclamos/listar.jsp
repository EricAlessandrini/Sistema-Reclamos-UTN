<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2>Listado de reclamos</h2>

<table class="table table-bordered table-striped table-hover">
	<thead>
		<tr>
			<th>Id</th>
			<th>Titulo</th>
			<th>Descripcion</th>
			<th></th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${reclamos}" var="r">
		<tr>
			<td>${r.id}</td>
			<td>${r.titulo}</td>
			<td>${r.descripcion}</td>
			<td>
				<a class="btn btn-primary" href="/reclamos/${r.id}">Ver</a>
				<a class="btn btn-warning" href="/reclamos/editar/${r.id}">Editar</a>
				<a class="btn btn-danger" href="/reclamos/borrar/${r.id}">Borrar</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<jsp:include page="../template_inferior.jsp"></jsp:include>