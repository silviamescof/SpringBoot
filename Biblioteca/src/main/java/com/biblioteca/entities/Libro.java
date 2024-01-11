package com.biblioteca.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="libro")
public class Libro {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String autor;
    private Integer paginas;

//////////////////////////CONSTRUCTORS///////////////////////////////////
    public Libro(String titulo, String autor, Integer paginas) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
    }

    public Libro() {
    }
    /////////////////////////////////////SETTERS//////////////////////

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    ///////////////////////////GETTERS//////////////////////////////////////////////////

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getPaginas() {
        return paginas;
    }

    //////////////////TOSTTRING/////////////////////////////////////////////////////////


    @Override
    public String toString() {
        return "Libro{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", paginas=" + paginas +
                '}';
    }

    ////////////////////////////IQUAL////////////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(id, libro.id) && Objects.equals(titulo, libro.titulo) && Objects.equals(autor, libro.autor) && Objects.equals(paginas, libro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, autor, paginas);
    }
}

