package edu.curso.java.integrador.sistemareclamosv3.controller;

import javax.validation.constraints.NotEmpty;

public class ReclamoForm {
	
	private Long id;
	
	@NotEmpty(message = "Falta completar el titulo del reclamo")
	private String titulo;
	
	@NotEmpty(message = "Falta completar la descripcion del reclamo")
	private String descripcion;
	
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
