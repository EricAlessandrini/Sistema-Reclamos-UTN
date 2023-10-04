package edu.curso.java.integrador.sistemareclamosv3.bo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity 
public class Reclamo {

	@Id
	@GeneratedValue
	private Long id;
	
	private String titulo;
	private String descripcion;
	private Date fechaAlta;
	
	@ManyToOne
	private CategoriaReclamo categoriaReclamo;

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

	public Date getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public CategoriaReclamo getCategoriaReclamo() {
		return categoriaReclamo;
	}

	public void setCategoriaReclamo(CategoriaReclamo categoriaReclamo) {
		this.categoriaReclamo = categoriaReclamo;
	}
	
	
	
}
