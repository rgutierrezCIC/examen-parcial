package es.cic.Ejercicio004.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.Ejercicio004.model.Pelicula;
import es.cic.Ejercicio004.repository.PeliculaRepository;

@Service
@Transactional
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Transactional(readOnly = true)
    public Pelicula leer(Long id) {
        return peliculaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pelicula no encontrado con ID: " + id));

    }

}
