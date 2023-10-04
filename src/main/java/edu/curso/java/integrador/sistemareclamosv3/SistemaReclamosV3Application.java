package edu.curso.java.integrador.sistemareclamosv3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.curso.java.integrador.sistemareclamosv3.bo.CategoriaReclamo;
import edu.curso.java.integrador.sistemareclamosv3.bo.Reclamo;
import edu.curso.java.integrador.sistemareclamosv3.repository.CategoriaReclamoRepository;
import edu.curso.java.integrador.sistemareclamosv3.service.ReclamoService;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SuppressWarnings("unused")
@SpringBootApplication
public class SistemaReclamosV3Application extends SpringBootServletInitializer implements CommandLineRunner {
	
	//@Autowired
	//private CategoriaReclamoRepository categoriaReclamoRepository;

	@Autowired
	private ReclamoService reclamoService;
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaReclamosV3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//CategoriaReclamo categoriaReclamo1 = new CategoriaReclamo();
		//categoriaReclamo1.setNombre("nuevo");
		
		//categoriaReclamoRepository.save(categoriaReclamo1);
		//System.out.println("ID generado: " + categoriaReclamo1.getId());
		
		//System.out.println("Cantidad de categorias: " + categoriaReclamoRepository.count());
		//Long idBuscar = 1l;
		//CategoriaReclamo categoriaReclamo = categoriaReclamoRepository.findById(idBuscar).get();
		//System.out.println("Nombre: " + categoriaReclamo.getNombre());
		
		
		/*
		 * Reclamo reclamo = new Reclamo(); reclamo.setTitulo("Ejemplo 1");
		 * reclamo.setDescripcion("Ejemplo de reclamo creado desde la consola");
		 * 
		 * Long idGenerado = reclamoService.altaDeNuevoReclamo(reclamo);
		 * 
		 * System.out.println("Id generado del nuevo reclamo: " + idGenerado);
		 */
		
		//List<Reclamo> reclamos = reclamoService.recuperarTodosLosReclamos();
		//for (Reclamo reclamo : reclamos) {
		//	System.out.println("Reclamo: " + reclamo.getTitulo());
		//}
		
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SistemaReclamosV3Application.class);
	}

}
