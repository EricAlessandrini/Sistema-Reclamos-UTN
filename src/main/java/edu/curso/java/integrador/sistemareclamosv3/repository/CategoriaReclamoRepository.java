package edu.curso.java.integrador.sistemareclamosv3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.curso.java.integrador.sistemareclamosv3.bo.CategoriaReclamo;

@Repository
public interface CategoriaReclamoRepository extends CrudRepository<CategoriaReclamo, Long> {

}
