package edu.curso.java.integrador.sistemareclamosv3.controller.dto;

import javax.validation.constraints.NotEmpty;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;

public class ReclamoDTO {
	
	private Long id;
	
	@NotEmpty(message = "Falta completar el titulo del reclamo")
	private String titulo;
	
	@NotEmpty(message = "Falta completar la descripcion del reclamo")
	private String descripcion;
	
	public ReclamoDTO() {}
	
	public ReclamoDTO(Reclamo reclamo) {
		this.id = reclamo.getId();
		this.titulo = reclamo.getTitulo();
		this.descripcion = reclamo.getDescripcion();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
