package es.cic.Ejercicio004.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.cic.Ejercicio004.model.Director;
import es.cic.Ejercicio004.service.DirectorService;

@RestController
@RequestMapping("/api/director")
public class DirectorController {

    @Autowired
    DirectorService directorService;
    
    @GetMapping("/{id}")
    public Director leer(@PathVariable ("id") long id){
        Director director = directorService.leer(id);
        return director; 
    }

}
