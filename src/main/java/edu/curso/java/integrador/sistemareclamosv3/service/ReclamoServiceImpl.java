package edu.curso.java.integrador.sistemareclamosv3.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.curso.java.integrador.sistemareclamosv3.bo.CategoriaReclamo;
import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;
import edu.curso.java.integrador.sistemareclamosv3.repository.CategoriaReclamoRepository;
import edu.curso.java.integrador.sistemareclamosv3.repository.ReclamoRepository;
import java.util.*;

@SuppressWarnings("unused")
@Service
@Transactional
public class ReclamoServiceImpl implements ReclamoService {

	
	@Autowired
	private CategoriaReclamoRepository categoriaReclamoRepository;

	@Autowired
	private ReclamoRepository reclamoRepository;
	
	
	@Override
	public Long altaDeNuevoReclamo(Reclamo reclamo) {
		reclamo.setFechaAlta(new Date());
		
		//CategoriaReclamo categoriaReclamo = null;
		//reclamo.setCategoriaReclamo(categoriaReclamo);
		
		reclamoRepository.save(reclamo);
		return reclamo.getId();
	}
	
	@Override
	public List<Reclamo> recuperarTodosLosReclamos() {
		return reclamoRepository.recuperarTodosLosReclamosOrdenadosPorTitulo();
	}

	@Override
	public List<Reclamo> recuperarTodosLosReclamos(String titulo) {
		return reclamoRepository.buscarReclamosPorTitulo(titulo);
	}

	@Override
	public Reclamo buscarReclamoPorId(Long id) {
		Optional<Reclamo> optionalReclamo = reclamoRepository.findById(id);
		if(optionalReclamo.isPresent()) {
			return optionalReclamo.get();
		} else {
			return null;
		}
	}
	
	@Override
	public void borrarReclamo(Long id) {
		reclamoRepository.deleteById(id);
	}
	
	@Override
	public void actualizarReclamo(Reclamo reclamo) {
			reclamoRepository.save(reclamo);
	}
	
	
}
