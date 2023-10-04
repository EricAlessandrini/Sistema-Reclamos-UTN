<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:include page="../template_superior.jsp"></jsp:include>

<h2 class="mt-3">Formulario Registro</h2>

<div>
<form:form action="/reclamos/guardar" id="formReclamo" modelAttribute="reclamoForm">

	<div class="row">	

		<div class="col-md-6 mt-3">
			
			<div class="mb-3">
			  <label class="form-label">Id</label>
			  <form:input cssClass="form-control" path="id" readonly="true"/>
			</div>
			
			<div class="mb-3">
			  <label class="form-label">Titulo</label>
			  <form:input cssClass="form-control required" path="titulo"/><br>
			  <form:errors path="titulo"></form:errors>
			</div>
			
			<div class="mb-3">
			  <label class="form-label">Descripcion</label>
			  <form:textarea cssClass="form-control required" path="descripcion" rows="5" cols="15"/><br>
			  <form:errors path="descripcion"></form:errors>
			</div>
			
			<button class="btn btn-primary" id="buttonEnviar" type="submit">Enviar</button>
			<button class="btn btn-warning" id="buttonCancelar" type="button">Cancelar</button>
		
		</div>
		
	</div>
	
	<script>
		$(document).ready(function() {
			console.log('Listo, termino de cargar todo el HTML de la pagina...')
			
		
			$('#buttonEnviar').on('click', function() {
				if($('#formReclamo').valid() == true){
					$('#formReclamo').submit();
				} else {
					bootbox.alert('Por favor completar los campos que faltan....');
				}
			})
		});
	</script>
	
</form:form>
</div>
<jsp:include page="../template_inferior.jsp"></jsp:include>
