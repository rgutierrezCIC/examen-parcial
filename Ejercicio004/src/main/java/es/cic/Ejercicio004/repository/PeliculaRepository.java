package es.cic.Ejercicio004.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.cic.Ejercicio004.model.Pelicula;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{

}
