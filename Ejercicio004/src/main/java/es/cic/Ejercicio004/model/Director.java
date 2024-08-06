package es.cic.Ejercicio004.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity
public class Director {
    
private Long id;

private String nombre;

private Long birthYear;

private List <Pelicula> peliculas;

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public Long getBirthYear() {
    return birthYear;
}

public void setBirthYear(Long birthYear) {
    this.birthYear = birthYear;
}

public List<Pelicula> getPeliculas() {
    return peliculas;
}

public void setPeliculas(List<Pelicula> peliculas) {
    this.peliculas = peliculas;
}


}
