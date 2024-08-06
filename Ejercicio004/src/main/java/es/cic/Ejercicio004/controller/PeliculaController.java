package es.cic.Ejercicio004.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.Ejercicio004.model.Pelicula;
import es.cic.Ejercicio004.service.PeliculaService;

@RestController
@RequestMapping("/api/pelicula")
public class PeliculaController {

    @Autowired
    PeliculaService peliculaService;
    
    @GetMapping("/{id}")
    public Pelicula leer(@PathVariable ("id") long id){
        Pelicula pelicula = peliculaService.leer(id);
        return pelicula; 
    }

}
