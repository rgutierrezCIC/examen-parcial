package es.cic.Ejercicio004.model;

import jakarta.persistence.Entity;

@Entity
public class Pelicula {

private Long id;

private String titulo;

private Long year;

private Director director;

public Director getDirector() {
    return director;
}

public void setDirector(Director director) {
    this.director = director;
}

public Long getYear() {
    return year;
}

public void setYear(Long year) {
    this.year = year;
}

public Long getId() {
    return id;
}

public void setId(Long id) {
    this.id = id;
}

public String getTitulo() {
    return titulo;
}

public void setTitulo(String titulo) {
    this.titulo = titulo;
}


}
