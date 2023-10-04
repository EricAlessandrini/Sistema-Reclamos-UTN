<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2 class="mt-3">Listado de reclamos</h2>

<table class="table table-bordered table-striped table-hover mt-3">
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
				<a class="btn btn-warning" href="/reclamos/${r.id}/editar">Editar</a>
				<a class="btn btn-danger" onclick="borrarReclamo(${r.id})" href="#">Borrar</a>
			</td>
		</tr>
		</c:forEach>
	</tbody>
</table>

<script>
	function borrarReclamo(idReclamo) {
		bootbox.confirm('Seguro que queres borrar el reclamo ' + idReclamo, function(result) {
	    	if(result == true) {
	    		alert('Listo lo borramos......');
	    		window.location = '/reclamos/borrar/' + idReclamo;
	    	}
		});
	}
</script>

<jsp:include page="../template_inferior.jsp"></jsp:include>