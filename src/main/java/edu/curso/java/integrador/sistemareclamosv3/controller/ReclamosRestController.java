package edu.curso.java.integrador.sistemareclamosv3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;
import edu.curso.java.integrador.sistemareclamosv3.controller.dto.ReclamoDTO;
import edu.curso.java.integrador.sistemareclamosv3.service.ReclamoService;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/reclamos")
public class ReclamosRestController {
	
	@Autowired
	private ReclamoService reclamoService;

	
	@GetMapping //URL FINAL ES: /api/reclamos
	public ResponseEntity<List<ReclamoDTO>> recuperarTodosLosReclamos() {
		List<ReclamoDTO> reclamosDTO = new ArrayList<ReclamoDTO>();
		
		List<Reclamo> reclamos = reclamoService.recuperarTodosLosReclamos();
		for (Reclamo reclamo : reclamos) {
			reclamosDTO.add(new ReclamoDTO(reclamo));
		}
		return ResponseEntity.ok(reclamosDTO);
	}
	
	
	@GetMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ResponseEntity<ReclamoDTO> recuperarReclamoPorId(@PathVariable Long id) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		
		if(reclamo != null) {
			ReclamoDTO reclamoDTO = new ReclamoDTO(reclamo);
			return ResponseEntity.ok(reclamoDTO);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
			
	}
	
	@PostMapping //URL FINAL ES: /api/reclamos
	public ResponseEntity<ReclamoDTO> altaDeNuevoReclamo(@RequestBody @Valid ReclamoDTO reclamoDTO,
			UriComponentsBuilder uriComponentsBuilder) {
		Reclamo reclamo = new Reclamo();
		reclamo.setTitulo(reclamoDTO.getTitulo());
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		Long idNuevoReclamo = reclamoService.altaDeNuevoReclamo(reclamo);
		reclamoDTO.setId(idNuevoReclamo);
		URI url = uriComponentsBuilder.path("/api/reclamos/{id}").buildAndExpand(reclamoDTO.getId()).toUri();
		return ResponseEntity.created(url).body(reclamoDTO);
	}
	
	
	@DeleteMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ResponseEntity borrarReclamoPorId(@PathVariable Long id) {
		reclamoService.borrarReclamo(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/{id}") //URL FINAL ES: /api/reclamos/123456
	public ResponseEntity<ReclamoDTO> altaDeNuevoReclamo(@PathVariable Long id, @RequestBody @Valid ReclamoDTO reclamoDTO) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		reclamo.setTitulo(reclamoDTO.getTitulo());
		reclamo.setDescripcion(reclamoDTO.getDescripcion());
		reclamoService.actualizarReclamo(reclamo);
		return ResponseEntity.ok(reclamoDTO);
	}
	
}
