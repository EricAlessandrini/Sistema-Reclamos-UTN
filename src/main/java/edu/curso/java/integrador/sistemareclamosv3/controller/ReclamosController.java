package edu.curso.java.integrador.sistemareclamosv3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;
import edu.curso.java.integrador.sistemareclamosv3.service.ReclamoService;

@Controller
@RequestMapping(value = "/reclamos")
public class ReclamosController {
	
	@Autowired
	private ReclamoService reclamoService;
	
	@RequestMapping
	public String paginaPrincipal(Model model) {
		String bienvenido = "Bienvenido al sistema de reclamos V3";
		model.addAttribute("bienvenido", bienvenido);
		return "/reclamos/reclamos";
	}
	
	@RequestMapping(value = "/listar") //URL FINAL /reclamos/listar
	public String listarReclamos(Model model) {
		List<Reclamo> reclamos = reclamoService.recuperarTodosLosReclamos();
		model.addAttribute("reclamos", reclamos);
		return "/reclamos/listar";
	}
	
	@RequestMapping(value = "/{id}") //URL FINAL /reclamos/1233434543645
	public String verReclamo(Model model,@PathVariable  Long id) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		model.addAttribute("reclamo", reclamo);
		return "/reclamos/ver";
	}

	@RequestMapping(value = "/borrar/{id}") //URL FINAL /reclamos/borrar/1233434543645
	public String borrarReclamo(Model model,@PathVariable  Long id) {
		reclamoService.borrarReclamo(id);
		return "redirect:/reclamos/listar";
	}
	
	@RequestMapping(value = "/nuevo")
	public String nuevoReclamo(Model model) {
		ReclamoForm reclamoForm = new ReclamoForm();
		model.addAttribute("reclamoForm", reclamoForm);
		return "/reclamos/form";
	}
	
	@RequestMapping(value = "/{id}/editar")
	public String editarReclamo(Model model, @PathVariable Long id) {
		Reclamo reclamo = reclamoService.buscarReclamoPorId(id);
		ReclamoForm reclamoForm = new ReclamoForm();
		reclamoForm.setId(reclamo.getId());
		reclamoForm.setTitulo(reclamo.getTitulo());
		reclamoForm.setDescripcion(reclamo.getDescripcion());
		model.addAttribute("reclamoForm", reclamoForm);
		return "/reclamos/form";
	}
	
	@RequestMapping(value = "/guardar", method = RequestMethod.POST)
	public String guardarReclamo(Model model, @Valid ReclamoForm reclamoForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors() == true) {
			return "/reclamos/form";
		}
		
		Long idActual = reclamoForm.getId();
		
		if (idActual == null) {
			Reclamo reclamo = new Reclamo();
			reclamo.setTitulo(reclamoForm.getTitulo());
			reclamo.setDescripcion(reclamoForm.getDescripcion());
			reclamoService.altaDeNuevoReclamo(reclamo);
		} else {
			Reclamo reclamo = reclamoService.buscarReclamoPorId(idActual);
			reclamo.setTitulo(reclamoForm.getTitulo());
			reclamo.setDescripcion(reclamoForm.getDescripcion());
			reclamoService.actualizarReclamo(reclamo);
		}
		
		return "redirect:/reclamos/listar";
	}
}
