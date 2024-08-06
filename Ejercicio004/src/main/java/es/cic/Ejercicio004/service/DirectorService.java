package es.cic.Ejercicio004.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.cic.Ejercicio004.repository.DirectorRepository;
import es.cic.Ejercicio004.model.Director;


@Service
@Transactional
public class DirectorService {

    @Autowired
    private DirectorRepository directorRepository;

    @Transactional(readOnly = true)
    public Director leer(Long id){
        return directorRepository.findById(id).orElseThrow(() -> new RuntimeException("Director no encontrado con ID: " + id));

    }

}
