package es.cic.Ejercicio004.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.Ejercicio004.model.Director;
import es.cic.Ejercicio004.model.Pelicula;
import es.cic.Ejercicio004.repository.DirectorRepository;
import jakarta.persistence.EntityManager;


@SpringBootTest
@AutoConfigureMockMvc
public class DirectorControllerIntegrationTest {

    @Autowired
    DirectorRepository directorRepository;

    @Autowired
    private EntityManager em;
    
    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    Director director;

    @BeforeEach
    public void setUp(){
        director = new Director();
        director= directorRepository.save(director);
        director.setNombre("Ramiro");
        director.setBirthYear(1979l);
        
        Pelicula pelicula = new Pelicula();
        pelicula.setDirector(director);
        pelicula.setTitulo("Mi vida es asis");

        
        List <Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula);
        director.setPeliculas(peliculas);

        directorRepository.save(director);
        directorRepository.flush();

    }

    @Test
    void testLeer() throws Exception {
        MvcResult mvcResult = mvc.perform(get("/api/director/{1}", director.getId())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(director.getId()))
                .andReturn();

        String body = mvcResult.getResponse().getContentAsString();
        Director directorRes = objectMapper.readValue(body, Director.class);

        assertTrue(directorRes.getPeliculas().size() >= 1);
    }

}
