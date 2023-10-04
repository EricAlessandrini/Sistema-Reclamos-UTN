package edu.curso.java.integrador.sistemareclamosv3.service;

import java.util.List;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;

public interface ReclamoService {

	Long altaDeNuevoReclamo(Reclamo reclamo);

	List<Reclamo> recuperarTodosLosReclamos();

	List<Reclamo> recuperarTodosLosReclamos(String titulo);

	Reclamo buscarReclamoPorId(Long id);

	void borrarReclamo(Long id);

	void actualizarReclamo(Reclamo reclamo);

}